package com.planificadortareas.thyra.Controller;

import com.planificadortareas.thyra.Dto.CreateTaskRequest;
import com.planificadortareas.thyra.Dto.UpdateTaskRequest;
import com.planificadortareas.thyra.Model.Task;
import com.planificadortareas.thyra.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @AuthenticationPrincipal Jwt jwt
    ) {
        UUID userId = getUserId(jwt);

        return ResponseEntity.ok(
                taskService.findAllByUserId(userId)
        );
    }

    @PostMapping
    public ResponseEntity<Task> createTask(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateTaskRequest request
    ) {
        UUID userId = getUserId(jwt);

        Task savedTask = taskService.create(userId, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskRequest request
    ) {
        UUID userId = getUserId(jwt);

        Task updatedTask = taskService.update(
                userId,
                id,
                request
        );

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable Long id
    ) {
        UUID userId = getUserId(jwt);

        taskService.delete(userId, id);

        return ResponseEntity.noContent().build();
    }

    private UUID getUserId(Jwt jwt) {
        return UUID.fromString(jwt.getSubject());
    }
}