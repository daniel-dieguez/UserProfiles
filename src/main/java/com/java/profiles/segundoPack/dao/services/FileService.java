package com.java.profiles.segundoPack.dao.services;

import com.java.profiles.segundoPack.dao.imple.IFileImple;
import com.java.profiles.segundoPack.dao.repository.IFileRepository;
import com.java.profiles.segundoPack.model.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileService implements IFileImple {

    @Autowired
    private IFileRepository iFileRepository;



    @Override
    public List<FileEntity> findAll() {
        return this.iFileRepository.findAll();
    }

    @Override
    public FileEntity findById(String id) {
        return this.iFileRepository.findById(id).orElse(null);
    }

    @Override
    public FileEntity save(FileEntity file) {
        return this.iFileRepository.save(file);
    }


    // servicio de guardado

    public FileEntity store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileEntity fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes());
        fileEntity.setId(UUID.randomUUID().toString());
        return this.iFileRepository.save(fileEntity);

    }

    public FileEntity storeFile(FileEntity fileEntity) {
        return this.iFileRepository.save(fileEntity);
    }

    @Override
    public void detele(FileEntity fileEntity) {
        this.iFileRepository.delete(fileEntity);
    }
}
