package net.lab1024.sa.base.module.support.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
        import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("product")
public class Product {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long shopId;

    private String name;

    private java.math.BigDecimal price;

    private Integer stock;

    private String coverImage;

    private Long categoryId;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @TableLogic
    private Integer isDeleted;
}

