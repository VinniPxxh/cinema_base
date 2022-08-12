package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.MoviePersonDao;
import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.entitys.MoviePerson;
import com.kata.cinema.base.models.enums.TypeCharacter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviePersonDaoImpl extends AbstractDaoImpl<Long, MoviePerson> implements MoviePersonDao {
    public List<MoviePerson> getAllFetch() {
        return entityManager.createQuery("select distinct mp from MoviePerson mp left join fetch mp.movie " +
                "where mp.type = :type", MoviePerson.class)
                .setParameter("type", TypeCharacter.MAIN_CHARACTER)
                .setMaxResults(2)
                .getResultList();
    }
}
