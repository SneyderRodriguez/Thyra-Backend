package com.planificadortareas.thyra.Model;

import jakarta.persistence.Column;
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
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @NotBlank(message = "El nombre de la tarea es obligatorio")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "La categoría de la tarea es obligatoria")
    @Column(nullable = false)
    private String category;

    @NotBlank(message = "La prioridad de la tarea es obligatoria")
    @Column(nullable = false)
    private String priority;

    @NotBlank(message = "La descripción de la tarea es obligatoria")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "La fecha de inicio de la tarea es obligatoria")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull(message = "La fecha de vencimiento de la tarea es obligatoria")
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @NotBlank(message = "El estado de la tarea es obligatorio")
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private boolean completed;
}