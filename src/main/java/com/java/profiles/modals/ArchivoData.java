package com.java.profiles.modals;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "modalbase")
@Entity
@Builder
public class ArchivoData implements Serializable {

    @Id
    @Column(name = "id_modal")
    private String id_modal;
    @Column(name = "nombre_completo")
    private String nombre_completo;
    @Column(name = "edad")
    private int edad;
    @Column(name = "comentario")
    private String comentario;
    @Lob
    @Column(name = "foto", length = 1000)
    private byte[] foto;

    private String type;
    private String filepath;

}
