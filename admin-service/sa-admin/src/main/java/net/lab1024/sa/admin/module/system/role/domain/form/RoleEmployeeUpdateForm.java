package net.lab1024.sa.admin.module.system.role.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

/**
 * 角色的员工更新
 *
 */
@Data
public class RoleEmployeeUpdateForm {

    @Schema(description = "角色id")
    @NotNull(message = "角色id不能为空")
    protected Long roleId;

    @Schema(description = "员工id集合")
    @NotEmpty(message = "员工id不能为空")
    protected Set<Long> employeeIdList;

}
