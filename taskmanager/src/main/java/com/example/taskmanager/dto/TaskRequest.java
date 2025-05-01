package com.example.taskmanager.dto;

import com.example.taskmanager.model.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {

    @NotBlank(message = "Title not empty! ")
    @Size(min = 3, max = 100, message = " title only be between 3 and 100 character. ")
    private String title;
    @Size(max = 500, message = "Description max 500 characters")
    private String decription;
    @NotNull(message = "Status can't be empty")
    private Task.Status status;
    private LocalDate dueDate;

}
