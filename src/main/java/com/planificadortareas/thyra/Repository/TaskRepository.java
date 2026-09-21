package com.planificadortareas.thyra.Repository;

import com.planificadortareas.thyra.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(UUID userId);

    Optional<Task> findByIdAndUserId(Long id, UUID userId);
}
