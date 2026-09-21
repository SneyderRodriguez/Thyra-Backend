package com.planificadortareas.thyra.Service;

import com.planificadortareas.thyra.Dto.CreateTaskRequest;
import com.planificadortareas.thyra.Dto.UpdateTaskRequest;
import com.planificadortareas.thyra.Exception.TaskNotFoundException;
import com.planificadortareas.thyra.Model.Task;
import com.planificadortareas.thyra.Repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<Task> findAllByUserId(UUID userId) {
        return taskRepository.findAllByUserId(userId);
    }

    public Task create(UUID userId, CreateTaskRequest request) {
        Task task = new Task();

        task.setUserId(userId);
        task.setName(request.name());
        task.setCategory(request.category());
        task.setPriority(request.priority());
        task.setDescription(request.description());
        task.setStartDate(request.startDate());
        task.setDueDate(request.dueDate());
        task.setStatus(request.status());
        task.setCompleted(request.completed());

        return taskRepository.save(task);
    }

    public Task update(
            UUID userId,
            Long taskId,
            UpdateTaskRequest request
    ) {
        Task task = taskRepository.findByIdAndUserId(taskId, userId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        task.setName(request.name());
        task.setCategory(request.category());
        task.setPriority(request.priority());
        task.setDescription(request.description());
        task.setStartDate(request.startDate());
        task.setDueDate(request.dueDate());
        task.setStatus(request.status());
        task.setCompleted(request.completed());

        return taskRepository.save(task);
    }

    public void delete(UUID userId, Long taskId) {
        Task task = taskRepository.findByIdAndUserId(taskId, userId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        taskRepository.delete(task);
    }
}