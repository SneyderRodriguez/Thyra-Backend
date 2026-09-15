package com.planificadortareas.thyra.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
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
    public Task() {
    }
    public Task(Long id, String name, String category, String priority, String description, LocalDate startDate, LocalDate dueDate, String status, boolean completed) {
        Id = id;
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.completed = completed;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
