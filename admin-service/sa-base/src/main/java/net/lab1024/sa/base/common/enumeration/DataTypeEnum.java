package net.lab1024.sa.base.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataTypeEnum implements BaseEnum {

    /**
     *普通数据
     */
    NORMAL(1, "普通数据"),

    /**
     * 加密数据
     */
    ENCRYPT(10, "加密数据"),
    ;
    private final Integer value;

    private final String desc;

}
