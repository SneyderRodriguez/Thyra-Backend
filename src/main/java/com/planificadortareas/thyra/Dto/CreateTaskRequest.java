package com.planificadortareas.thyra.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateTaskRequest(

        @NotBlank(message = "El nombre de la tarea es obligatorio")
        String name,

        @NotBlank(message = "La categoría de la tarea es obligatoria")
        String category,

        @NotBlank(message = "La prioridad de la tarea es obligatoria")
        String priority,

        @NotBlank(message = "La descripción de la tarea es obligatoria")
        String description,

        @NotNull(message = "La fecha de inicio de la tarea es obligatoria")
        LocalDate startDate,

        @NotNull(message = "La fecha de vencimiento de la tarea es obligatoria")
        LocalDate dueDate,

        @NotBlank(message = "El estado de la tarea es obligatorio")
        String status,

        boolean completed
) {
}