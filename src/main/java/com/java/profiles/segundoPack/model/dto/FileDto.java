package com.java.profiles.segundoPack.model.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileDto  implements Serializable {

    @NotEmpty(message = "El nombre del archivo no puede estar vacío")
    private String name;

    @NotEmpty(message = "El tipo de archivo no puede estar vacío")
    private String type;
}
