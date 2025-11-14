package net.lab1024.sa.base.module.support.shop.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.lab1024.sa.base.common.domain.PageParam;
import net.lab1024.sa.base.common.swagger.SchemaEnum;
import net.lab1024.sa.base.common.validator.enumeration.CheckEnum;
import net.lab1024.sa.base.module.support.shop.constant.ShopStatusEnum;
import org.hibernate.validator.constraints.Length;

/**
 * 店铺查询表单
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "店铺查询表单")
public class ShopQueryForm extends PageParam {

    @Schema(description = "店铺名称")
    @Length(max = 100, message = "店铺名称最多100字符")
    private String name;

    @Schema(description = "店主ID")
    private Long ownerId;

    @SchemaEnum(value = ShopStatusEnum.class, desc = "状态")
    @CheckEnum(value = ShopStatusEnum.class, message = "状态错误")
    private Integer status;

    @Schema(description = "删除状态", hidden = true)
    private Integer deletedFlag;
}