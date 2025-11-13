package net.lab1024.sa.base.module.support.codegenerator.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 代码生成 预览 表单
 *
 */
@Data
public class CodeGeneratorPreviewForm {

    @NotBlank(message = "模板文件 不能为空")
    @Schema(description = "模板文件")
    private String templateFile;

    @NotBlank(message = "表名 不能为空")
    @Schema(description = "表名")
    private String tableName;

}
