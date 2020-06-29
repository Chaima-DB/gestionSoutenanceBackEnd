/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zsmart.gestionDesSoutenances.uploads.service;

import com.zsmart.gestionDesSoutenances.uploads.model.FileInfo;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
public interface FileInfoService {

    public int save(MultipartFile file);
    public List<FileInfo> findAll();
    FileInfo findByUrl(String url);

}
