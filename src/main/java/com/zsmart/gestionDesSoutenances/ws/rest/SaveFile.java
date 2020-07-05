package com.zsmart.gestionDesSoutenances.ws.rest;

import com.zsmart.gestionDesSoutenances.bean.Doctorant;
import com.zsmart.gestionDesSoutenances.bean.These;
import com.zsmart.gestionDesSoutenances.service.facade.DoctorantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zsmart.gestionDesSoutenances.service.facade.SaveFileService;
import com.zsmart.gestionDesSoutenances.service.facade.TheseService;

import io.swagger.annotations.Api;
import java.io.BufferedOutputStream;
import java.io.File;
import org.springframework.core.io.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Api
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SaveFile {

    @Autowired
    SaveFileService saveFileService;
    @Autowired
    TheseService theseService;
    @Autowired
    DoctorantService doctorantService;

    @PostMapping("/savefile")
    public ResponseEntity<String> handleFileUploadBac(@RequestParam("file") MultipartFile file) {
        return saveFileService.handleFileUploadBac(file);
    }

    
    
    private final Path root = Paths.get("uploads");
    public static String uploadDirectory = System.getProperty("user.dir")+ "/uploads";
    @PostMapping("/saveThese/reference/{reference}/titre/{titre}")
     public ResponseEntity<String> saveThese(@PathVariable String reference,@PathVariable String titre ,@RequestParam("file") MultipartFile file) throws FileNotFoundException, IOException {
         
         String fileName = file.getOriginalFilename();
         String filePath = Paths.get(uploadDirectory, fileName).toString();
        
         // save file locally
         BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
         stream.write(file.getBytes());
         stream.close();
         These these = new These();
         // Doctorant doctorant = doctorantService.findByUserEmail(these.getDoctorant().getUser().getEmail());
         these.setDatePublicationThese(new Date());
         these.setFileName(fileName);
         these.setFilepath(filePath);
         these.setReference(reference);
         these.setTitre(titre);
         // these.setDoctorant(doctorant);
         theseService.save(these);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     @GetMapping("/")
    public List<These> findAll() {
        return theseService.findAll();
    }
      @GetMapping("/files/{filename:.+}")
  @ResponseBody
  public ResponseEntity<Resource> getFile(@PathVariable String filename) throws MalformedURLException {
    Resource file =load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }   
   public Resource load(String filename) throws MalformedURLException {
       Path file = root.resolve(filename);
       Resource resource = new UrlResource(file.toUri());
       if (resource.exists() || resource.isReadable()) {
           return resource;
       } else {
           throw new RuntimeException("Could not read the file!");
       }
  }
    
}
