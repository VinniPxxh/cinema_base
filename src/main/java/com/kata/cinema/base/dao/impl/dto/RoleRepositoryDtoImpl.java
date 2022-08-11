package com.kata.cinema.base.dao.impl.dto;
import com.kata.cinema.base.dao.abstracts.dto.RoleRepositoryDto;
import com.kata.cinema.base.models.entitys.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class RoleRepositoryDtoImpl implements RoleRepositoryDto {


    private EntityManager entityManager;

    public RoleRepositoryDtoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findByName(String name) {
        return entityManager.createQuery("select r from Role r where r.name=:name", Role.class)
                .setParameter("name", name)
                .getResultList().stream().findAny().orElse(null);
    }
}
