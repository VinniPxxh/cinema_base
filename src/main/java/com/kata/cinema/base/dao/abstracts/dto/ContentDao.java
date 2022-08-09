package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.entitys.Content;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDao extends AbstractDao<Content, Long> {
    void saveImageWithMovieId(String URL, Long id);

    void findById(Long id);

    void save(Content content);
}
