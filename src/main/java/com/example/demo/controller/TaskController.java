package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {

        return taskRepository.save(task);

    }

    /*
    * Нужно реализовать такие ресты:

    (GET) /tasks - Список всех задач
    (GET) /tasks/{id} - Задача по id. Пример /tasks/1
    (PUT) /tasks/{id} - Редактирование задачи
    (DELETE) /tasks/{id} - Удаление задачи

    Будут использованы аннотации: @GetMapping, @PutMapping, @PathVariable, @RequestBody
    */

    @GetMapping("/tasks/{id}")
    public Task getTaskById (@PathVariable Long id){
        return taskRepository.findById(id);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks (){
        return taskRepository.findAll();
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskById (@PathVariable Long id, @RequestBody Task newTask) {
        Task updatedTask = taskRepository.findById(id);
        updatedTask.setDate(newTask.getDate());
        updatedTask.setDescription(newTask.getDescription());

        return taskRepository.save(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public String delete(@PathVariable Long id){
        taskRepository.deleteById(id);
        return "Task id = "+ id +" is deleted";
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id, @RequestBody Task task){
        if (task.isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable Long id){
        taskRepository.markAsDone(id);
    }
}