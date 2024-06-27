package com.java.profiles.dao.service;

import com.java.profiles.modals.ArchivoData;
import com.java.profiles.modals.response.ResponseFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IArchivoDataServiceImpl {

    ArchivoData store(MultipartFile file) throws IOException;

    Optional<ArchivoData> getFile (UUID id) throws FileNotFoundException;


    List<ResponseFile> findAll();


}
