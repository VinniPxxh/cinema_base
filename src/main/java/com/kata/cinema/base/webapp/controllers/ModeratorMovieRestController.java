package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.entitys.Movies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ModeratorMovieRestController {
    @Value("${upload.path}")
    private String uploadPath;

    Movies movies;

    private String filename;

    @PostMapping("{id}/uploadPreview")
    public String uploadPreview(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(resultFilename));

            movies.setName(resultFilename);

        }
        return null;
    }
}
