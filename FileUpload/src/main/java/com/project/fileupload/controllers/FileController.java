package com.project.fileupload.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.fileupload.dtos.FileResponse;
import com.project.fileupload.services.FileService;

@RestController
@RequestMapping("/upload")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/doc")
    public ResponseEntity<FileResponse> uploadFile(@RequestParam("document") MultipartFile file){
        String document = fileService.uploadFile(file, path);
        FileResponse fileResponse = FileResponse.builder().message("Document uploaded successfully!!").success(true).status(HttpStatus.CREATED).build();
        return new ResponseEntity<FileResponse>(fileResponse, HttpStatus.CREATED);
    }
}
