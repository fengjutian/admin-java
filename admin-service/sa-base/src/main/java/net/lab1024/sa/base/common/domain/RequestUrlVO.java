package net.lab1024.sa.base.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 请求url返回对象
 *
 */
@Data
public class RequestUrlVO {

    @Schema(description = "注释说明")
    private String comment;

    @Schema(description = "controller.method")
    private String name;

    @Schema(description = "url")
    private String url;
}
