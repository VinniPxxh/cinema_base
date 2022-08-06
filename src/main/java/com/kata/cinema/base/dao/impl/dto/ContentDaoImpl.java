package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.ContentDao;
import com.kata.cinema.base.models.entitys.Content;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoImpl extends AbstractDaoImpl<Content, Long> implements ContentDao {

    @Override
    public void saveImageWithMovieId(Content content, Long id) {
        content.setMovies(entityManager.find(Movies.class, id));
        entityManager.persist(content);
    }
}
