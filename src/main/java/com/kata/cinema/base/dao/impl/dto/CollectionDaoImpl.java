package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.CollectionDao;
import com.kata.cinema.base.models.entitys.Collections;
import com.kata.cinema.base.models.enums.CollectionType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class CollectionDaoImpl extends AbstractDaoImpl<Long, Collections> implements CollectionDao {

    private EntityManager entityManager;

    public CollectionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Query("select m from Movies m")
    public Collections findCollectionByType(CollectionType collectionType) {

        return (Collections) entityManager.createQuery("select c from Collections c where c.collectionType=:type").setParameter("type", collectionType)
                .getSingleResult();
    }


    @Override
    public void create(Collections entity) {
        super.create(entity);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public Optional<Collections> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public void update(Collections entity) {
        super.update(entity);
    }
}
