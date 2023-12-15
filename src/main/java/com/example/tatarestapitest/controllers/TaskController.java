package com.example.tatarestapitest.controllers;

import com.example.tatarestapitest.DataTransferObjects.CreateDTO.TaskCreationDTO;
import com.example.tatarestapitest.models.TaskModel;
import com.example.tatarestapitest.services.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@Api(tags = "Tasks-api")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/getAllTasks")
    @ApiOperation("Get all tasks")
    public ArrayList<TaskModel> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/getTaskById/{id}")
    @ApiOperation("Get a task by ID")
    public Optional<TaskModel> getTaskById(@PathVariable Long id){
        return taskService.getById(id);
    }


    @PostMapping({"/create"})
    @ApiOperation("Create a new task")
    public TaskModel saveTask(@Valid @RequestBody TaskCreationDTO taskCreationDTO) {
        TaskModel task = new TaskModel();
        BeanUtils.copyProperties(taskCreationDTO, task);
        return taskService.saveTask(task);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Update an existing task")
    public ResponseEntity<String> updateTask(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Optional<String> title,
            @RequestParam(required = false) Optional<String> description,
            @RequestParam(required = false) Optional<Boolean> completed
    ){
        TaskModel task = taskService.updateTask(id, title, description, completed);
        if (task == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Object not found");
        }
        return ResponseEntity.ok("Edited with success.");
    }

    @DeleteMapping( path = "/delete/{id}")
    @ApiOperation("Delete a task by ID")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        boolean ok = this.taskService.deleteTask(id);
        if (ok){
            return ResponseEntity.ok("Deleted with success.");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete entity");
        }
    }
}
