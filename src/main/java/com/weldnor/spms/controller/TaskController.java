package com.weldnor.spms.controller;

import com.weldnor.spms.dto.task.NewTaskDto;
import com.weldnor.spms.dto.task.TaskDto;
import com.weldnor.spms.dto.task.UpdateTaskDto;
import com.weldnor.spms.entity.Task;
import com.weldnor.spms.mapper.task.TaskMapper;
import com.weldnor.spms.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        path = "api/tasks",
        produces = "application/json"
)
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping(path = "")
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskService.getAll();
        return taskMapper.toDto(tasks);
    }

    @GetMapping(path = "/{id}")
    public TaskDto getTask(@PathVariable("id") long id) {
        Task task = taskService.getById(id).orElseThrow();
        return taskMapper.toDto(task);
    }

    @PutMapping(path = "")
    public TaskDto addTask(@RequestBody @Valid NewTaskDto taskDto) {
        System.out.println(taskDto);
        Task task = taskMapper.toEntity(taskDto);
        task = taskService.add(task);
        return taskMapper.toDto(task);
    }

    @PostMapping(path = "/{id}")
    public void updateTask(@PathVariable(name = "id") long id, @RequestBody @Valid UpdateTaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        taskService.update(task, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTask(@PathVariable("id") long id) {
        taskService.deleteById(id);
    }
}
