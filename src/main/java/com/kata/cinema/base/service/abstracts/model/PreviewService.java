package com.kata.cinema.base.service.abstracts.model;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface PreviewService {
    void upload(Long id, MultipartFile file);
}
