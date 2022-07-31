package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import com.kata.cinema.base.dao.impl.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractDaoImpl implements AbstractDao<Long, User> {

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.ofNullable(users.get(Math.toIntExact(id)));
    }

    @Override
    public void update(User entity) {
        if (!users.contains(entity)) {
            log.warn("user {} cannot be updated", entity);
            return;
        }
        users.removeIf(user -> user.equals(entity));
        users.add(entity);
    }

    @Override
    public void delete(User entity) {
        users.remove(entity);
    }

    @Override
    public void deleteById(Long id) {
        users.stream().filter(user -> user.getId().equals(id)).findFirst().ifPresent(users::remove);
    }

    @Override
    public boolean existById(Long id) {
        return users.contains(users.get(Math.toIntExact(id)));
    }

    @Override
    public void create(User entity) {
        users.add(entity);
    }
}
