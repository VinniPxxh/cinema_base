package com.kata.cinema.base.service.impl.entity;
import com.kata.cinema.base.models.entitys.User;
import com.kata.cinema.base.dao.abstracts.dto.UserRepositoryDto;
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

    private UserRepositoryDto userRepository;

    @Autowired
    public UserServiceImpl(UserRepositoryDto userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return (User) userRepository.findUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = (User) userRepository.findUserByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User: " + email + " not found");
        }


        return new User(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getBirthday(), user.getAvatarUrl());
    }
}
