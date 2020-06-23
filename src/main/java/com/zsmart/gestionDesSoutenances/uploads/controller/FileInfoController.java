/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.uploads.controller;

import com.zsmart.gestionDesSoutenances.uploads.model.FileInfo;
import com.zsmart.gestionDesSoutenances.uploads.service.FileInfoService;
import io.swagger.annotations.Api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class FileInfoController {

    @Autowired
    FileInfoService fileInfoService;
    
    @GetMapping("/url/{url}")
	public FileInfo findByUrl(@PathVariable String url) {
		return fileInfoService.findByUrl(url);
	}

	@PostMapping("/")
    public void save(@RequestParam("file") MultipartFile file) {
        fileInfoService.save(file);
    }

    @GetMapping("/")
    public List<FileInfo> findAll() {
        return fileInfoService.findAll();
    }

}
