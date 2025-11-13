package net.lab1024.sa.admin.module.system.department.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 部门 更新表单
 *
 */
@Data
public class DepartmentUpdateForm extends DepartmentAddForm {

    @Schema(description = "部门id")
    @NotNull(message = "部门id不能为空")
    private Long departmentId;

}
