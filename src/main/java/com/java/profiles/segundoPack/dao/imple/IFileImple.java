package com.java.profiles.segundoPack.dao.imple;

import com.java.profiles.segundoPack.model.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileImple {


    public List<FileEntity> findAll();
    public FileEntity findById(String id);
    public FileEntity save(FileEntity file);
    public void detele (FileEntity fileEntity);

}
