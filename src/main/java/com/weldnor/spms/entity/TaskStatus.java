package com.weldnor.spms.entity;

import com.weldnor.spms.entity.pk.UserGlobalRolePK;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "task_statuses")
@Data
@NoArgsConstructor
public class TaskStatus {
    @Id
    private long taskStatusId;
    private String name;
}
