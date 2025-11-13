package net.lab1024.sa.base.module.support.codegenerator.constant;

import net.lab1024.sa.base.common.enumeration.BaseEnum;

/**
 * 查询条件类型
 *
 */
public enum CodeQueryFieldQueryTypeEnum implements BaseEnum {

    LIKE("Like", "模糊查询"),
    EQUAL("Equal", "等于"),
    DATE_RANGE("DateRange", "日期范围"),
    DATE("Date", "指定日期"),
    ENUM("Enum", "枚举"),

    DICT("Dict", "字典"),
    ;

    private String value;

    private String desc;

    CodeQueryFieldQueryTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
