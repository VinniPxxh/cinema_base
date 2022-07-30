package com.kata.cinema.base.models.entitys;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserAvatar implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private String avatarUrl;
}
