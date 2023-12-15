package com.example.tatarestapitest.repositories;

import com.example.tatarestapitest.models.TaskModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, Long> {
}
