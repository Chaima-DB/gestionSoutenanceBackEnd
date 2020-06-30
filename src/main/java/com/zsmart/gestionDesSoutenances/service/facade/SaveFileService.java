package com.zsmart.gestionDesSoutenances.service.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SaveFileService {
	
	ResponseEntity<String> handleFileUploadBac(MultipartFile file); 
}
