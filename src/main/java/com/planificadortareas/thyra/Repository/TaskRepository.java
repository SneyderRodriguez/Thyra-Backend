package com.planificadortareas.thyra.Repository;

import com.planificadortareas.thyra.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
