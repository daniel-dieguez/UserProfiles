package com.java.profiles.modals;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Blob;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "modalbase")
@Entity
@Builder
public class ArchivoData implements Serializable {

    @Id
    private UUID id; // Cambiado a String para usar UUID
    private String name;
    private String type;

    @Lob
    private byte[] data;

}
