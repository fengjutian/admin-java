package net.lab1024.sa.admin.module.system.department.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 部门 添加表单
 *
 */
@Data
public class DepartmentAddForm {

    @Schema(description = "部门名称")
    @Length(min = 1, max = 50, message = "请输入正确的部门名称(1-50个字符)")
    @NotNull(message = "请输入正确的部门名称(1-50个字符)")
    private String departmentName;

    @Schema(description = "排序")
    @NotNull(message = "排序值")
    private Integer sort;

    @Schema(description = "部门负责人id")
    private Long managerId;

    @Schema(description = "上级部门id (可选)")
    private Long parentId;

}
