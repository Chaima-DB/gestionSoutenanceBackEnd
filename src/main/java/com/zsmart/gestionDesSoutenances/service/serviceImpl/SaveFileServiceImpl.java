package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zsmart.gestionDesSoutenances.bean.Article;
import com.zsmart.gestionDesSoutenances.service.facade.SaveFileService;

@Service
public class SaveFileServiceImpl implements SaveFileService {
	
	Article article = new Article();
	
	List<String> files = new ArrayList<String>();
// Path to save the file
	private final Path rootLocation = Paths.get("uploads");

	@Override
	public ResponseEntity<String> handleFileUploadBac(MultipartFile file) {
		String message;
		try {
			try {
				Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			} catch (Exception e) {
				throw new RuntimeException("FAIL!");
			}
			files.add(file.getOriginalFilename());
			message = "Successfully uploaded!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Failed to upload!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
}
