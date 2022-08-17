package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.GenresDao;
import com.kata.cinema.base.models.dto.GenreResponseDto;
import com.kata.cinema.base.models.entitys.Genres;
import com.kata.cinema.base.service.abstracts.model.AbstractServiceImpl;
import com.kata.cinema.base.service.abstracts.model.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreServiceImpl extends AbstractServiceImpl<Long, Genres> implements GenreService {
    private final GenresDao genresDao;

    @Autowired
    public GenreServiceImpl(GenresDao genresDao) {
        super(genresDao);
        this.genresDao = genresDao;
    }


    @Override
    public List<GenreResponseDto> findGenres() {
        return genresDao.getListOfGenres();
    }

    @Override
    public List<Genres> findGenreList() {
        return genresDao.getAll();
    }

    @Transactional
    @Override
    public void save(Genres genres) {
        genresDao.create(genres);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        genresDao.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Genres genres) {
        genresDao.update(genres);
    }

    @Override
    public Genres findById(Long id) {
        return genresDao.getById(id).orElseThrow();
    }

    @Override
    public boolean isExistsById(Long id) {
        return genresDao.isExistById(id);
    }

}
