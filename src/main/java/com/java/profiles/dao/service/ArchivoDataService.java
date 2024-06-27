package com.java.profiles.dao.service;

import com.java.profiles.dao.IArchivoRepositoryDao;
import com.java.profiles.modals.ArchivoData;
import com.java.profiles.modals.response.ResponseFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ArchivoDataService implements IArchivoDataServiceImpl{

    @Autowired
    private IArchivoRepositoryDao iArchivoRepositoryDao;



    //Enviar imagenes
    @Override
    public ArchivoData store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ArchivoData archivoData = ArchivoData.builder()
                .name(fileName)
                .type(file.getContentType())
                .build();
        return iArchivoRepositoryDao.save(archivoData);
    }

    //descargar
    @Override
    public Optional<ArchivoData> getFile(UUID id) throws FileNotFoundException {
        Optional<ArchivoData> file = iArchivoRepositoryDao.findById(id);
        if(file.isPresent()){
            return file;
        }
        throw new FileNotFoundException();
    }

    //Muestra los datos
    @Override
    public List<ResponseFile> findAll() {
        List<ResponseFile> file = iArchivoRepositoryDao.findAll().stream().map(dbFile ->{
           String fileGuardar = ServletUriComponentsBuilder.fromCurrentContextPath()
                   .path("archivo/files/")
                   .path(dbFile.getId().toString())
                   .toUriString();

           return ResponseFile.builder()
                   .name(dbFile.getName())
                   .url(fileGuardar)
                   .type(dbFile.getType())
                   .size(dbFile.getData().length).build();
        }).collect(Collectors.toList());
        return file;
    }


}
