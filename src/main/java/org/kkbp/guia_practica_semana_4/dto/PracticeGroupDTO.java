package org.kkbp.guia_practica_semana_4.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PracticeGroupDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String name;

    @Positive(message = "El tamaño debe ser mayor a 0")
    @NotNull(message = "El tamaño no puede estar vacío")
    private Integer size;

    @NotBlank(message = "El rol no puede estar vacío")
    @Size(min = 5, max = 20, message = "El rol debe tener entre 5 y 20 caracteres")
    private String role;

    @PositiveOrZero(message = "El tamaño debe ser mayor o igual a 0")
    @NotNull(message = "El conteo de estudiantes no puede estar vacío")
    private Integer currentStudentCount;

    @NotNull(message = "El campo activo no puede estar vacío")
    private Boolean isActive;
}
