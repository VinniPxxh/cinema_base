package com.kata.cinema.base.service.abstracts.model;

import com.kata.cinema.base.dao.abstracts.dto.AbstractDao;
import org.springframework.stereotype.Service;

@Service
public interface PreviewService {
    void upload(Long id, String URL);
}
