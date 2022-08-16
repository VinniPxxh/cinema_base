package com.kata.cinema.base.converter;

import com.kata.cinema.base.models.dto.request.NewsRequestDto;
import com.kata.cinema.base.models.entitys.News;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface NewsMapper extends Converter<NewsRequestDto, News> {

    News toNews(NewsRequestDto dto);

}
