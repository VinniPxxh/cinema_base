package com.kata.cinema.base.dao.impl.dto;
import com.kata.cinema.base.dao.abstracts.dto.UserRepositoryDto;
import com.kata.cinema.base.models.entitys.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class UserRepositoryDtoImpl implements UserRepositoryDto {



    private EntityManager entityManager;

    public UserRepositoryDtoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findUserByEmail(String email) {
        String q = "select u from User u where u.email=:email";
        TypedQuery<User> res = entityManager.createQuery(q , User.class);
        res.setParameter("email" , email);
        return res.getSingleResult();
    }
}
