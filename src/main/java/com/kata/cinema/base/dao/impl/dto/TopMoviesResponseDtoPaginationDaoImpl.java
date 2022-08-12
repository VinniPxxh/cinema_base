package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.TopMoviesResponseDtoPaginationDao;
import com.kata.cinema.base.models.dto.TopMoviesResponseDto;
import com.kata.cinema.base.models.entitys.Movies;
import com.kata.cinema.base.models.enums.TopMoviesType;
import com.kata.cinema.base.models.enums.Type;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TopMoviesResponseDtoPaginationDaoImpl extends AbstractDaoImpl<Long, Movies> implements TopMoviesResponseDtoPaginationDao {
    @Override
    public List<TopMoviesResponseDto> getItemsDto(Integer currentPage, Integer itemsOnPage, Map<String, Object> parameters) {
        String order;
        switch ((TopMoviesType) parameters.get("topMoviesType")) {
            case NAME -> order = " order by m.name";
            case COUNT_SCORE -> order = " order by countScore desc";
            case DATE_RELEASE -> order = " order by m.dateRelease";
            default -> order = " order by avgScore desc";
        }

        List<TopMoviesResponseDto> dtos = entityManager.createQuery("select new com.kata.cinema.base.models.dto.TopMoviesResponseDto" +
                "(m.id, m.name, m.originName, m.countries, m.time, c.contentUrl, cast(count(s) as int) as countScore, sum(s.score)/cast(count(s) as double) as avgScore) " +
                "from Movies m left join Content c on m.id = c.movies.id left join Score s on m.id = s.movie.id join m.genres g where " +
                "(select count(si) from Score si where si.movie.id = m.id) > -1 and (g.name in (:genre) or :genre is null) and (c.type in (:type) or c.type is null) " +
                "and ((m.dateRelease between :startDate and :endDate)  or (cast(:startDate as date) is null and m.dateRelease <= :endDate) or (cast(:endDate as date) is null " +
                "and m.dateRelease >= :startDate) or (cast(:startDate as date) is null and cast(:endDate as date) is null )) group by m.id, c.id" + order, TopMoviesResponseDto.class)
                .setMaxResults((Integer) parameters.get("count"))
                .setParameter("genre", parameters.get("genre"))
                .setParameter("startDate", parameters.get("startDate"))
                .setParameter("endDate", parameters.get("endDate"))
                .setParameter("type", List.of(Type.MOVIES, Type.SERIALS))
                .getResultList();

        return dtos.subList((currentPage-1)*itemsOnPage, (currentPage-1)*itemsOnPage+itemsOnPage);
    }

    @Override
    public Long getResultTotal(Map<String, Object> parameters) {
        return entityManager.createQuery("select distinct count(m) from Movies m left join Content c on m.id = c.movies.id left join Score s on m.id = s.movie.id join m.genres g " +
                        "where (select count(si) from Score si where si.movie.id = m.id) > -1 and (g.name in (:genres) or :genres is null) and (c.type in (:type) or c.type is null) " +
                        "and ((m.dateRelease between :startDate and :endDate)  or (cast(:startDate as date) is null and m.dateRelease <= :endDate) or (cast(:endDate as date) is null " +
                        "and m.dateRelease >= :startDate) or (cast(:startDate as date) is null and cast(:endDate as date) is null )) group by m.id, c.id, s.id, g.id", Long.class)
                .setMaxResults((Integer) parameters.get("count"))
                .setParameter("genres", parameters.get("genres"))
                .setParameter("startDate", parameters.get("startDate"))
                .setParameter("endDate", parameters.get("endDate"))
                .setParameter("type", List.of(Type.MOVIES, Type.SERIALS))
                .getSingleResult();
    }
}
