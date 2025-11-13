package net.lab1024.sa.admin.module.system.position.domain.form;

import net.lab1024.sa.base.common.domain.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 职务表 分页查询表单
 *
 */

@Data
public class PositionQueryForm extends PageParam{

    @Schema(description = "关键字查询")
    private String keywords;

    @Schema(hidden = true)
    private Boolean deletedFlag;
}