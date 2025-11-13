package net.lab1024.sa.admin.module.system.menu.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 菜单 更新Form
 *
 */
@Data
public class MenuUpdateForm extends MenuBaseForm {

    @Schema(description = "菜单ID")
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;

    @Schema(hidden = true)
    private Long updateUserId;
}
