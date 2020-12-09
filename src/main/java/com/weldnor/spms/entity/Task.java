package com.weldnor.spms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    private long taskId;
    private long projectId;
    private long creatorId;
    private String name;
    private String description;
    private String status_id;
}
