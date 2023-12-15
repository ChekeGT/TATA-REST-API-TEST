package com.example.tatarestapitest.services;

import com.example.tatarestapitest.models.TaskModel;
import com.example.tatarestapitest.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public ArrayList<TaskModel> getTasks(){
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public TaskModel saveTask(TaskModel task){
        return taskRepository.save(task);
    }

    public Optional<TaskModel> getById(Long id){
        return taskRepository.findById(id);
    }

    public TaskModel updateTask(Long id, Optional<String> title, Optional<String> description, Optional<Boolean> completed){
        TaskModel task = taskRepository.findById(id).orElse(null);
        if (task != null){
            title.ifPresent(task::setTitle);
            description.ifPresent(task::setDescription);
            completed.ifPresent(task::setCompleted);
            taskRepository.save(task);
        }
        return task;
    }
    public boolean deleteTask (Long id){
        try{
            TaskModel task = taskRepository.findById(id).orElse(null);
            if (task == null){
                return  false;
            }
            taskRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
