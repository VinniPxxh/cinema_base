package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.service.impl.entity.PreviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController()
@RequestMapping("/api/moderator/movie")
public class ModeratorMovieRestController extends AbstractDaoImpl<Long, MultipartFile> {
    private final PreviewServiceImpl previewService;

    @Autowired
    public ModeratorMovieRestController(PreviewServiceImpl previewService) {
        this.previewService = previewService;
    }


    @PostMapping("/{id}/uploadPreview")
    public File uploadPreview(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Path relPath = Paths.get("uploads/movies/preview/");
        Path absPath = relPath.toAbsolutePath();
        File conFile = new File(absPath + "\\" + file.getOriginalFilename());
        System.out.println(conFile.getPath());
        try (FileOutputStream fos = new FileOutputStream(conFile)) {
            fos.write(file.getBytes());
            previewService.upload(id, conFile.toString());
        }
        return conFile;
    }
}
