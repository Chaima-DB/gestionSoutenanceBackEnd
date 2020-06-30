package com.zsmart.gestionDesSoutenances.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zsmart.gestionDesSoutenances.service.facade.SaveFileService;

import io.swagger.annotations.Api;

@Api
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SaveFile {

	@Autowired
	SaveFileService saveFileService;

	@PostMapping("/savefile")
	public ResponseEntity<String> handleFileUploadBac(@RequestParam("file") MultipartFile file) {
		return saveFileService.handleFileUploadBac(file);
	}

}
