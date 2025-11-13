package net.lab1024.sa.admin.module.business.oa.enterprise.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 企业员工
 *
 */
@Data
public class EnterpriseEmployeeForm {

    @Schema(description = "企业id")
    @NotNull(message = "企业id不能为空")
    private Long enterpriseId;

    @Schema(description = "员工信息id")
    @NotEmpty(message = "员工信息id不能为空")
    private List<Long> employeeIdList;
}