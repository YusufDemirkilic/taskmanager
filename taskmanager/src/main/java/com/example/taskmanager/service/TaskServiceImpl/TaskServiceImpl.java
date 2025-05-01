package com.example.taskmanager.service.TaskServiceImpl;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task=Task.builder()
                .title(taskRequest.getTitle())
                .description(taskRequest.getDecription())
                .status(taskRequest.getStatus())
                .dueDate(taskRequest.getDueDate())
                .build();
        Task savedTask = taskRepository.save(task);
        return mapToResponse(savedTask) ;
    }
    
    private TaskResponse mapToResponse(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDescription(),
                task.getDueDate()
        );
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)){
           throw new RuntimeException("Task not found with id "+id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this ::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id "+id));
        return mapToResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        Task task= taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id "+id));
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDecription());
        task.setStatus(taskRequest.getStatus());
        task.setDueDate(taskRequest.getDueDate());
        Task updateTask = taskRepository.save(task);
        return mapToResponse(updateTask);
    }
}
