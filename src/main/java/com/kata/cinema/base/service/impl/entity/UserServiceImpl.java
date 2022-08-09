package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.repositories.UserRepository;
import com.kata.cinema.base.service.abstracts.model.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User: " + email + " not found");
        }


        return new User(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getBirthday(), user.getAvatarUrl());
    }
}
