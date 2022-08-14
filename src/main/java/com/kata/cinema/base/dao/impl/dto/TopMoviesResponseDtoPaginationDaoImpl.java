package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.TopMoviesResponseDtoPaginationDao;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.models.enums.TopMoviesType;
import com.kata.cinema.base.models.enums.Type;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TopMoviesResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Movies> implements TopMoviesResponseDtoPaginationDao {
    @Override
    public List<List<TopMoviesResponseDto>> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        String order;
        switch ((TopMoviesType) parameters.get("topMoviesType")) {
            case NAME -> order = " order by m.name";
            case COUNT_SCORE -> order = " order by countScore desc";
            case DATE_RELEASE -> order = " order by m.dateRelease";
            default -> order = " order by avgScore desc";
        }

        List<TopMoviesResponseDto> dtos = entityManager.createQuery("select new com.kata.cinema.base.models.dto.TopMoviesResponseDto" +
                "(m.id, m.name, m.originName, m.countries, m.time, c.contentUrl, cast(count(distinct s) as int) as countScore, cast(sum(s.score) as double)/count(s) as avgScore) " +
                "from Movies m left join Content c on m.id = c.movies.id left join Score s on m.id = s.movie.id join m.genres g where " +
                "(select count(si) from Score si where si.movie.id = m.id) > 100 and (g.id in (:genreId) or :genreId is null) and (c.type in (:type) or c.type is null) " +
                "and ((m.dateRelease between :startDate and :endDate)  or (cast(:startDate as date) is null and m.dateRelease <= :endDate) or (cast(:endDate as date) is null " +
                "and m.dateRelease >= :startDate) or (cast(:startDate as date) is null and cast(:endDate as date) is null )) group by m.id, c.id" + order, TopMoviesResponseDto.class)
                .setMaxResults((Integer) parameters.get("count"))
                .setParameter("genreId", parameters.get("genreId"))
                .setParameter("startDate", parameters.get("startDate"))
                .setParameter("endDate", parameters.get("endDate"))
                .setParameter("type", List.of(Type.MOVIES, Type.SERIALS))
                .getResultList();

        return splitToPages(dtos, itemsOnPage);
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select count(distinct m) from Movies m left join Content c on m.id = c.movies.id left join Score s on m.id = s.movie.id join m.genres g " +
                        "where (select count(si) from Score si where si.movie.id = m.id) > 100 and (g.id in (:genreId) or :genreId is null) and (c.type in (:type) or c.type is null) " +
                        "and ((m.dateRelease between :startDate and :endDate)  or (cast(:startDate as date) is null and m.dateRelease <= :endDate) or (cast(:endDate as date) is null " +
                        "and m.dateRelease >= :startDate) or (cast(:startDate as date) is null and cast(:endDate as date) is null ))", Long.class)
                .setMaxResults((Integer) parameters.get("count"))
                .setParameter("genreId", parameters.get("genreId"))
                .setParameter("startDate", parameters.get("startDate"))
                .setParameter("endDate", parameters.get("endDate"))
                .setParameter("type", List.of(Type.MOVIES, Type.SERIALS))
                .getSingleResult();
    }
    private List<List<TopMoviesResponseDto>> splitToPages(List<TopMoviesResponseDto> dtos, int itemsOnPage) {
        List<List<TopMoviesResponseDto>> result = new ArrayList<>();
        for (int i = 0; i < dtos.size(); i = i + itemsOnPage) {
            int end = i + itemsOnPage;
            if (end > dtos.size()) {
                result.add(dtos.subList(i, dtos.size()));
            } else {
                result.add(dtos.subList(i, end));
            }
        }
        return result;
    }

}
