package com.java.profiles.dao.service;

import com.java.profiles.modals.ArchivoData;

import java.util.List;

public interface IArchivoDataServiImpl {

    public List<ArchivoData> findAll();
    public ArchivoData findById(String id_usuario);
    public ArchivoData save (ArchivoData archivoData);
    public void delete (ArchivoData archivoData);
}
