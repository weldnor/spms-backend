package com.weldnor.spms.entity.pk;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectMemberPK implements Serializable {
    private long userId;
    private long projectId;
}
