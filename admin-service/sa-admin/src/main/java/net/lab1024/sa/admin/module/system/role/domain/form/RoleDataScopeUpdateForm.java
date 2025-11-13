package net.lab1024.sa.admin.module.system.role.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 角色的数据范围更新
 *
 */
@Data
public class RoleDataScopeUpdateForm {

    @Schema(description = "角色id")
    @NotNull(message = "角色id不能为空")
    private Long roleId;

    @Schema(description = "设置信息")
    @Valid
    private List<RoleUpdateDataScopeListFormItem> dataScopeItemList;


    @Data
    public static class RoleUpdateDataScopeListFormItem {

        @Schema(description = "数据范围类型")
        @NotNull(message = "数据范围类型不能为空")
        private Integer dataScopeType;

        @Schema(description = "可见范围")
        @NotNull(message = "可见范围不能为空")
        private Integer viewType;
    }

}
