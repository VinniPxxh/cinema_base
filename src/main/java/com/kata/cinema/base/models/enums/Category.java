package com.kata.cinema.base.models.enums;

public enum Category {

    WAITING_MOVIES("Буду смотреть" ),
    FAVORITE_MOVIES("Любимые фильмы" ),
    VIEWED_MOVIES("Просмотренные" ),
    CUSTOM("Новый список" );

    private final String name;
    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
