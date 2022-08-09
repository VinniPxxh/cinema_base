package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.ContentDao;
import com.kata.cinema.base.models.entitys.Content;
import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoImpl extends AbstractDaoImpl<Content, Long> implements ContentDao {

    @Override
    public void saveImageWithMovieId(String URL, Long id) {
        Content content = new Content();
        content.setContentUrl(URL);
        content.setMovies(entityManager.find(Movies.class, id));
        entityManager.persist(content);
    }

    @Override
    public void findById(Long id) {
        entityManager.persist(id);
    }
}
