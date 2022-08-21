package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;


import java.util.Optional;


public interface CollectionService {

    public Collections findCollectionByType(CollectionType collectionType);

    public void create(Collections entity);

    public void deleteById(Long id);

    public Optional<Collections> getById(Long id);

    public void update(Collections entity);

    public boolean isExistById(Long id);



}
