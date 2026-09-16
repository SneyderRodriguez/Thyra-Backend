package com.planificadortareas.thyra.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre de la tarea es obligatorio")
    private String name;
    @NotBlank(message = "La categoría de la tarea es obligatoria")
    private String category;
    @NotBlank(message = "La prioridad de la tarea es obligatoria")
    private String priority;
    @NotBlank(message = "La descripción de la tarea es obligatoria")
    private String description;
    @NotNull(message = "La fecha de inicio de la tarea es obligatoria")
    private LocalDate startDate;
    @NotNull(message = "La fecha de vencimiento de la tarea es obligatoria")
    private LocalDate dueDate;
    @NotBlank(message = "El estado de la tarea es obligatorio")
    private String status;

    private boolean completed;
}
