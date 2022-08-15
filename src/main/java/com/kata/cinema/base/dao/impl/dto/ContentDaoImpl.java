package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.model.ContentDao;
import com.kata.cinema.base.models.entitys.Content;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDaoImpl extends AbstractDaoImpl<Long, Content> implements ContentDao {

}
