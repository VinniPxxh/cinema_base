package com.kata.cinema.base.models.entitys;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class News {
    @Id
    int id;
    @NotNull
    @Enumerated
    private Rubric rubric;
    @NotNull private Date date;
    @NotNull private String title;
    @NotNull private String htmlBody;

    @ManyToOne
    private User user;
}
