package com.kata.cinema.base.webapp.controllers.admin;

import com.kata.cinema.base.service.abstracts.model.PreviewService;
import com.kata.cinema.base.service.impl.entity.PreviewServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController()
@RequestMapping("/api/admin/movie")
@Api(tags = "Загрузка превью")
public class AdminMovieRestController {

    private final PreviewService previewService;

    @Autowired
    public AdminMovieRestController(PreviewServiceImpl previewService) {
        this.previewService = previewService;
    }


    @PostMapping("/{id}/uploadPreview")
    @ApiOperation(value = "Загрузка превью")
    public File uploadPreview(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Path relPath = Paths.get("uploads/movies/preview/");
        File conFile = new File(relPath + "\\" + file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(conFile)) {
            fos.write(file.getBytes());
            previewService.upload(id, conFile.toString());
        }
        return conFile;
    }
}
