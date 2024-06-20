package com.java.profiles.dao.service;


import com.java.profiles.dao.IArchivoDataDao;
import com.java.profiles.modals.ArchivoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Service
public class ArchivoDataService implements IArchivoDataServiImpl{

    @Autowired
    private IArchivoDataDao iArchivoDataDao;

    private final String FOLDER_PATH="D:\\4)Proyectos\\BackEnd\\Java\\API REST\\8. Perfil de Usuarios\\imagenes";


    @Override
    public List<ArchivoData> findAll() {
        return null;
    }

    @Override
    public ArchivoData findById(String id_usuario) {
        return null;
    }

    @Override
    public ArchivoData save(ArchivoData archivoData) {
        return null;
    }

    @Override
    public void delete(ArchivoData archivoData) {

    }



    public String uploadImage(MultipartFile file) throws IOException {

        String filepath=FOLDER_PATH+file.getOriginalFilename();

        ArchivoData archivoData = IArchivoDataDao.save(ArchivoData.builder()
                .nombre_completo(file.getOriginalFilename())
                .type(file.getContentType())
                .filepath(filepath).build());

        file.transferTo(new File(filepath));

        if (archivoData != null) {
            return "file uploaded successfully : " + filepath;
        }
        return null;
    }



     public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<ArchivoData> fileData = IArchivoDataDao.findByNombre_completo(fileName);
        String filePath = fileData.get().getFilepath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
