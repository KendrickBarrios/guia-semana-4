package org.kkbp.guia_practica_semana_4.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String name;

    @Positive(message = "Las horas prácticos deben ser mayores de 0")
    @NotNull(message = "Las horas prácticas no pueden estar vacías")
    private Integer practiceHours;

    @NotBlank(message = "La abreviación no puede estar vacía")
    @Size(min = 5, max = 20, message = "La abreviación debe ser entre 5 y 20 caracteres")
    private String abbreviation;

    @NotNull(message = "El campo de rotación no puede estar vacío")
    private Boolean rotates;

    @NotNull(message = "El campo activo no puede estar vacío")
    private Boolean isActive;
}
