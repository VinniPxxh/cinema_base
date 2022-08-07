package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.SearchUserDao;
import com.kata.cinema.base.models.dto.SearchUserResponseDto;
import com.kata.cinema.base.models.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class SearchUserDaoImpl extends AbstractDaoImpl<Long, User> implements SearchUserDao {

    private final EntityManager entityManager;

    @Autowired
    public SearchUserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<SearchUserResponseDto> findSearchUserByEmail(String email) {
        return Optional.ofNullable(
                (SearchUserResponseDto) entityManager
                        .createQuery("select SearchUserResponseDto from users user where user.email = :email")
                        .setParameter("email", email)
                        .getResultList().get(0));
    }
}
