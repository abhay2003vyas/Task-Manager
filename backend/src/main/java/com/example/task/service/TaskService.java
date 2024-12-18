package com.example.task.service;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Retrieve all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Update an existing task
    public Task updateTask(String id, Task updatedTask) {
        Optional<Task> existingTaskOpt = taskRepository.findById(id);
        if (existingTaskOpt.isPresent()) {
            Task existingTask = existingTaskOpt.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            return taskRepository.save(existingTask);
        } else {
            throw new IllegalArgumentException("Task with ID " + id + " not found");
        }
    }

    // Delete a task
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
