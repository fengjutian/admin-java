package net.lab1024.sa.base.module.support.helpdoc.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 帮助文档的 目录
 */
@Data
public class HelpDocCatalogVO {

    @Schema(description = "帮助文档目录id")
    private Long helpDocCatalogId;

    @Schema(description = "帮助文档目录-名称")
    private String name;

    @Schema(description = "帮助文档目录-父级id")
    private Long parentId;

    @Schema(description = "帮助文档目录-排序")
    private Integer sort;

}
