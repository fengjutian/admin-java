package net.lab1024.sa.base.module.support.helpdoc.domain.form;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 帮助文档 目录
 *
 */
@Data
public class HelpDocCatalogAddForm {

    @Schema(description = "名称")
    @NotBlank(message = "名称不能为空")
    @Length(max = 200, message = "名称最多200字符")
    private String name;

    @Schema(description = "父级")
    private Long parentId;

    @Schema(description = "排序")
    private Integer sort;
}
