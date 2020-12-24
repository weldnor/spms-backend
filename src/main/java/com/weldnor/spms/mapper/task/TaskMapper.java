package com.weldnor.spms.mapper.task;

import com.weldnor.spms.dto.task.NewTaskDto;
import com.weldnor.spms.dto.task.TaskDto;
import com.weldnor.spms.dto.task.UpdateTaskDto;
import com.weldnor.spms.entity.Task;
import com.weldnor.spms.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {
    private final ModelMapper mapper;
    private final TaskRepository taskRepository;

    public TaskMapper(ModelMapper mapper, TaskRepository taskRepository) {
        this.mapper = mapper;
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    private void configMapper() {
    }

    public Task toEntity(NewTaskDto dto) {
        return mapper.map(dto, Task.class);
    }

    public Task toEntity(UpdateTaskDto dto) {
        return mapper.map(dto, Task.class);
    }

    public TaskDto toDto(Task entity) {
        return mapper.map(entity, TaskDto.class);
    }

    public List<TaskDto> toDto(List<Task> entityList) {
        List<TaskDto> dtoList = new ArrayList<>();

        for (Task entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }

    public void merge(Task original, Task updated) {
        if (updated.getName() != null) {
            original.setName(updated.getName());
        }
        if (updated.getDescription() != null) {
            original.setDescription(updated.getDescription());
        }
        if (updated.getStatusId() != null) {
            original.setStatusId(updated.getStatusId());
        }
    }
}

