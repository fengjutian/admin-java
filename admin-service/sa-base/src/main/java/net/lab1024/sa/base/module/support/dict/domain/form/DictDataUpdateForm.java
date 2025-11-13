package net.lab1024.sa.base.module.support.dict.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * 字典数据表 更新表单
 *
 */

@Data
public class DictDataUpdateForm extends DictDataAddForm {

    @Schema(description = "字典数据id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "字典数据id 不能为空")
    private Long dictDataId;

    @Schema(description = "字典数据编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "字典数据编码 不能为空")
    private String dictCode;


}