/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.upload;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.These;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import com.zsmart.gestionDesSoutenances.service.facade.TheseService;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController

@CrossOrigin(origins = {"http://localhost:4200"})
public class FilesController {

  @Autowired
  FilesStorageService storageService;
  @Autowired
  TheseService theseService;
  @Autowired
  DoctorantService doctorantService;

  @PostMapping("/upload/description/{description}/titre/{titre}/email/{email}")
  public ResponseEntity<ResponseMessage> uploadFile(@PathVariable String description,@PathVariable String titre,@PathVariable String email ,@RequestParam("file") MultipartFile file) {
    String message = "";
    try {
      storageService.save(file);
       String fileName = file.getOriginalFilename();
        These these = new These();
         Doctorant doctorant = doctorantService.findByUserEmail(email);
         these.setDatePublicationThese(new Date());
         these.setFileName(fileName);
         these.setReference("These_"+new Date().getTime());
         these.setTitre(titre);
         these.setDesciption(description);
         these.setDoctorant(doctorant);
         theseService.save(these);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
  
   // Methode to get the All files URLs
  @GetMapping("/files")
  public ResponseEntity<List<FileInfo>> getListFiles() {
    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

      return new FileInfo(filename, url);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
  }
  // Methode to download a File
  @GetMapping("/files/{filename:.+}")
  @ResponseBody
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }
  
  
}