package net.lab1024.sa.base.module.support.shop.constant;

import lombok.Getter;
import net.lab1024.sa.base.common.enumeration.BaseEnum;

/**
 * 店铺状态常量
 */
@Getter
public enum ShopStatusEnum implements BaseEnum {

    DISABLE(0, "禁用"),
    ENABLE(1, "启用");

    private final Integer value;
    private final String desc;

    ShopStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ShopStatusEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (ShopStatusEnum status : values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        return null;
    }
}