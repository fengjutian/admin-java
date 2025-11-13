package net.lab1024.sa.admin.module.system.employee.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 修改登录人头像
 *
 */
@Data
public class EmployeeUpdateAvatarForm {

    @Schema(hidden = true)
    private Long employeeId;

    @Schema(description = "头像")
    @NotBlank(message = "头像不能为空哦")
    private String avatar;
}
