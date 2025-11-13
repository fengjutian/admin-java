package net.lab1024.sa.base.module.support.serialnumber.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 单据序列号 生成表单
 *
 */
@Data
public class SerialNumberGenerateForm {

    @Schema(description = "单号id")
    @NotNull(message = "单号id不能为空")
    private Integer serialNumberId;

    @Schema(description = "生成的数量")
    @NotNull(message = "生成的数量")
    private Integer count;

}
