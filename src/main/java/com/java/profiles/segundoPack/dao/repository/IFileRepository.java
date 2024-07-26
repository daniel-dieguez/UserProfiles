package com.java.profiles.segundoPack.dao.repository;

import com.java.profiles.segundoPack.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFileRepository extends JpaRepository<FileEntity, String> {




}
