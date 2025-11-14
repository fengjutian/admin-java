package net.lab1024.sa.base.module.support.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.lab1024.sa.base.common.validator.enumeration.CheckEnum;
import net.lab1024.sa.base.module.support.shop.constant.ShopStatusEnum;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

/**
 * 店铺 实体类
 */
@Data
@TableName("shop")
public class Shop {

    @TableId(type = IdType.AUTO)
    private Long id;

    @Length(max = 100, message = "店铺名称最多100字符")
    @Schema(description = "店铺名称")
    private String name;

    @Schema(description = "店主ID")
    private Long ownerId;

    @Schema(description = "店铺Logo")
    private String logoUrl;

    @Schema(description = "店铺描述")
    private String description;

    @CheckEnum(value = ShopStatusEnum.class, message = "状态错误")
    @Schema(description = "状态")
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    @TableLogic
    @Schema(description = "是否删除")
    private Integer isDeleted;
}
