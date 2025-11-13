package net.lab1024.sa.admin.module.system.employee.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * 员工更新部门
 *
 */
@Data
public class EmployeeBatchUpdateDepartmentForm {

    @Schema(description = "员工id")
    @NotEmpty(message = "员工id不能为空")
    @Size(max = 99, message = "一次最多调整99个员工")
    private List<Long> employeeIdList;

    @Schema(description = "部门ID")
    @NotNull(message = "部门ID不能为空")
    private Long departmentId;
}
