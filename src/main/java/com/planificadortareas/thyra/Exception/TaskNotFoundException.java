package com.planificadortareas.thyra.Exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long taskId) {
        super("No existe una tarea accesible con el ID " + taskId);
    }
}