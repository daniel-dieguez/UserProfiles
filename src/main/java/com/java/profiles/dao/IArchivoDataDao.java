package com.java.profiles.dao;

import com.java.profiles.modals.ArchivoData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArchivoDataDao extends JpaRepository<ArchivoData, Integer> {

    Optional<ArchivoData> findByNombre_completo(String fileName);
}
