package com.planificadortareas.thyra.Controller;

import com.planificadortareas.thyra.Model.Task;
import com.planificadortareas.thyra.Repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        Task savedTask = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                existingTask.setName(taskDetails.getName());
                    existingTask.setCategory(taskDetails.getCategory());
                    existingTask.setPriority(taskDetails.getPriority());
                    existingTask.setDescription(taskDetails.getDescription());
                    existingTask.setStartDate(taskDetails.getStartDate());
                    existingTask.setDueDate(taskDetails.getDueDate());
                    existingTask.setStatus(taskDetails.getStatus());
                    existingTask.setCompleted(taskDetails.isCompleted());

                    Task updatedTask = taskRepository.save(existingTask);
                    return ResponseEntity.ok(updatedTask);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
