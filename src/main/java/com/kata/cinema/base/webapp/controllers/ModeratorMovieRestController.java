package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.dao.impl.dto.AbstractDaoImpl;
import com.kata.cinema.base.models.entitys.Content;
import com.kata.cinema.base.service.impl.entity.PreviewServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController("/api/moderator/movie")
public class ModeratorMovieRestController extends AbstractDaoImpl<Long, MultipartFile> {
    private final PreviewServiceImpl previewService;
    private final static Logger log = LoggerFactory.getLogger(ModeratorMovieRestController.class);
    private final HttpServletRequest request;
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public ModeratorMovieRestController(PreviewServiceImpl previewService, HttpServletRequest request) {
        this.previewService = previewService;
        this.request = request;
    }

    @PostMapping("{id}/uploadPreview")
    public void uploadPreview(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
//        Content content = new Content();
//        id = content.getId();
        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        ImageIO.write(bufferedImage, "png", new File(uploadPath));
        previewService.upload(id, file);
//        if (!file.isEmpty()) {
//            String realPathToUploads = request.getServletContext().getRealPath(uploadPath);
//            if (!new File(realPathToUploads).exists()) {
//                new File(realPathToUploads).mkdir();
//            }
//            log.info("realPathToUploads = {}", realPathToUploads);
//            String orgName = file.getOriginalFilename();
//            String filePath = uploadPath + orgName + "(" + id + ")";
//            File dest = new File(filePath);
//            file.transferTo(dest);
//        }
    }
}
