package com.java.profiles.segundoPack.model.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileDto  implements Serializable {

    @NotEmpty(message = "El nombre del archivo no puede estar vacío")
    private String name;

    @NotEmpty(message = "El tipo de archivo no puede estar vacío")
    private String type;

    @NotEmpty(message = "El File no debe de estar vacio")
    private byte[] data;

    public void setData(MultipartFile file) throws IOException {
        this.data = file.getBytes();
    }
}
