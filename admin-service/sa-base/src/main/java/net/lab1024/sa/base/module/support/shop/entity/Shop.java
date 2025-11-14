package net.lab1024.sa.base.module.support.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.lab1024.sa.base.common.swagger.SchemaEnum;
import net.lab1024.sa.base.common.validator.enumeration.CheckEnum;
import net.lab1024.sa.base.module.support.shop.constant.ShopStatusEnum;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 店铺实体类
 *
 */
@Data
@TableName("shop")
@Schema(description = "店铺实体")
public class Shop {

    @TableId(type = IdType.AUTO)
    @Schema(description = "店铺ID")
    private Long id;

    @Schema(description = "店铺名称")
    @Length(max = 100, message = "店铺名称最多100字符")
    private String name;

    @Schema(description = "店主ID")
    @NotNull(message = "店主ID不能为空")
    private Long ownerId;

    @Schema(description = "店铺Logo URL")
    @Length(max = 500, message = "Logo URL最多500字符")
    private String logoUrl;

    @Schema(description = "店铺描述")
    @Length(max = 1000, message = "店铺描述最多1000字符")
    private String description;

    @SchemaEnum(value = ShopStatusEnum.class, desc = "状态")
    @CheckEnum(value = ShopStatusEnum.class, message = "状态错误")
    private Integer status;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "是否删除")
    private Boolean isDeleted;
}
