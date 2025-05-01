package com.example.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;


}
