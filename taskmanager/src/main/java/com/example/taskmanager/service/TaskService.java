package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskResponse> getAllTasks();
    TaskResponse getTaskById(Long id);
    TaskResponse createTask(TaskRequest taskRequest);
    TaskResponse updateTask(Long id, TaskRequest taskRequest);
    void deleteTask(Long id);

    //Task dto
}
