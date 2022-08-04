package com.kata.cinema.base.models.dto;

import java.util.List;

public class PageDto<T> {
    Long count;
    List<T> entities;
}
