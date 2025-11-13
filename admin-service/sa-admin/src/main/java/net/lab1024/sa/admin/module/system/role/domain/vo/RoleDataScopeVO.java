package net.lab1024.sa.admin.module.system.role.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 角色的数据范围
 *
 */
@Data
public class RoleDataScopeVO {

    @Schema(description = "数据范围id")
    private Integer dataScopeType;

    @Schema(description = "可见范围")
    private Integer viewType;
}
