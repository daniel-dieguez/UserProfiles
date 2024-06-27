package com.java.profiles.dao;

import com.java.profiles.modals.ArchivoData;
import org.hibernate.validator.cfg.defs.UUIDDef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IArchivoRepositoryDao extends JpaRepository<ArchivoData, UUID> {
}
