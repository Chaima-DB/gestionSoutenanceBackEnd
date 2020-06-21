/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.uploads.service;

import com.zsmart.gestionDesSoutenances.uploads.model.FileInfo;
import com.zsmart.gestionDesSoutenances.uploads.model.FileInfoDao;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Autowired
    FileInfoDao fileInfoDao;


  @Override
  public int save(MultipartFile file) {
      String message = "";
    try {
      FileInfo fileInfo = new FileInfo();
      fileInfo.setName(file.getOriginalFilename());
      fileInfoDao.save(fileInfo);
      
      message = "Uploaded the file successfully: " + file.getOriginalFilename();
     
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
    }
    return 1;
  }

 
    @Override
    public List<FileInfo> findAll() {
        return fileInfoDao.findAll();
    }

   
}