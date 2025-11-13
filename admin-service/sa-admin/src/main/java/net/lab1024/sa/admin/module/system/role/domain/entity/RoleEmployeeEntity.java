package net.lab1024.sa.admin.module.system.role.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色 员工关系
 *
 */
@Data
@TableName("t_role_employee")
public class RoleEmployeeEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long roleId;

    private Long employeeId;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    public RoleEmployeeEntity() {
    }

    public RoleEmployeeEntity(Long roleId, Long employeeId) {
        this.roleId = roleId;
        this.employeeId = employeeId;
    }
}
