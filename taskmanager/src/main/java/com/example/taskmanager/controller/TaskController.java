package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {

        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }
    @PostMapping
    public TaskResponse createTask(@RequestBody @Valid TaskRequest taskRequest){
        return taskService.createTask(taskRequest);
    }
    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody @Valid TaskRequest taskRequest){
      return taskService.updateTask(id,taskRequest);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
