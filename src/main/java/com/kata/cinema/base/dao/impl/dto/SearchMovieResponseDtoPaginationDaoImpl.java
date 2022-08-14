package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.PaginationDtoDao;
import com.kata.cinema.base.dao.abstracts.dto.SearchMovieResponseDtoPaginationDao;
import com.kata.cinema.base.models.dto.SearchMovieResponseDto;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.models.enums.MovieSortType;
import com.kata.cinema.base.models.enums.Type;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SearchMovieResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Movies> implements SearchMovieResponseDtoPaginationDao {
    @Override
    public List<SearchMovieResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        List<SearchMovieResponseDto> dtos = getDtoWithParameters(parameters);
        int start = (currentPage-1)*itemsOnPage;
        int end = start+itemsOnPage;

        if (dtos.size() <= itemsOnPage || dtos.size() <= end) {
            end = dtos.size();
        }
        return dtos.subList(start, end);
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count (distinct m)" +
                        "from Movies m join Content c on m.id = c.movies.id join m.genres g where (g.name in (:genres) or :genres is null) and (c.type in (:type) or c.type is null)" +
                        "and (m.name = :name or :name is null) and ((m.dateRelease between :startDate and :endDate)  or (cast(:startDate as date) is null and m.dateRelease <= :endDate) " +
                        "or (cast(:endDate as date) is null and m.dateRelease >= :startDate) or (cast(:startDate as date) is null and cast(:endDate as date) is null ))" +
                        "and (m.rars >= :rars or :rars is null) and (m.mpaa >= :mpaa or :mpaa is null)", Long.class)
                .setParameter("genres", parameters.get("genres"))
                .setParameter("type", List.of(Type.MOVIES, Type.SERIALS)) // за тип контента взяты только фильмы или сериалы.
                //TODO Отрефакторить после изменения контента
                .setParameter("name", parameters.get("name"))
                .setParameter("startDate", parameters.get("startDate"))
                .setParameter("endDate", parameters.get("endDate"))
                .setParameter("rars", parameters.get("rars"))
                .setParameter("mpaa", parameters.get("mpaa"))
                .getSingleResult();
    }


    private List<SearchMovieResponseDto> getDtoWithParameters(Map<String, Object> parameters) {
        String sortTypeText;
        switch ((MovieSortType)parameters.get("sortType")) {
            case NAME_ASC -> sortTypeText = " order by m.name asc";
            case NAME_DESC -> sortTypeText = " order by m.name desc";
            case DATE_RELEASE_DESC -> sortTypeText = " order by m.dateRelease desc";
            default -> sortTypeText = " order by m.dateRelease asc";
        }
        //Получаем дтошки без жанров
        List<SearchMovieResponseDto> dtos = entityManager.createQuery("select distinct " +
                        "new com.kata.cinema.base.models.dto.SearchMovieResponseDto(m.id, m.name, m.dateRelease, c.contentUrl) " +
                        "from Movies m join Content c on m.id = c.movies.id join m.genres g where (g.name in (:genres) or :genres is null) and (c.type in (:type) or c.type is null)" +
                        "and (m.name = :name or :name is null) and ((m.dateRelease between :startDate and :endDate)  or (cast(:startDate as date) is null and m.dateRelease <= :endDate) " +
                        "or (cast(:endDate as date) is null and m.dateRelease >= :startDate) or (cast(:startDate as date) is null and cast(:endDate as date) is null ))" +
                        "and (m.rars >= :rars or :rars is null) and (m.mpaa >= :mpaa or :mpaa is null)"
                        + sortTypeText, SearchMovieResponseDto.class)
                .setParameter("genres", parameters.get("genres"))
                .setParameter("type", List.of(Type.MOVIES, Type.SERIALS)) // за тип контента взяты только фильмы или сериалы.
                .setParameter("name", parameters.get("name"))
                .setParameter("startDate", parameters.get("startDate"))
                .setParameter("endDate", parameters.get("endDate"))
                .setParameter("rars", parameters.get("rars"))
                .setParameter("mpaa", parameters.get("mpaa"))
                .getResultList();

        return dtos;
    }
}
