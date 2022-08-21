package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.models.entitys.Content;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDao extends AbstractDao<Long, Content> {
}
