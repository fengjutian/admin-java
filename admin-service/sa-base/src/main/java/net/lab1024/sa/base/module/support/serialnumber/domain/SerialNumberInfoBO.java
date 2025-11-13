package net.lab1024.sa.base.module.support.serialnumber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.lab1024.sa.base.module.support.serialnumber.constant.SerialNumberIdEnum;
import net.lab1024.sa.base.module.support.serialnumber.constant.SerialNumberRuleTypeEnum;

/**
 * 单据序列号 信息
 *
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerialNumberInfoBO {

    /**
     * 主键id
     *
     * @see SerialNumberIdEnum
     */
    private Integer serialNumberId;

    /**
     * 业务
     */
    private String businessName;

    /**
     * 格式
     */
    private String format;

    /**
     * 生成规则
     *
     * @see SerialNumberRuleTypeEnum
     */
    private String ruleType;


    /**
     * 初始值
     */
    private Long initNumber;

    /**
     * 步长随机数范围
     */
    private Integer stepRandomRange;

    /**
     * 备注
     */
    private String remark;

    /**
     * 规则枚举
     */
    private SerialNumberRuleTypeEnum serialNumberRuleTypeEnum;


    /**
     * 存在[nnnnnn]中 n 的数量
     */
    private Integer numberCount;

    /**
     * [nnnnnn] 的格式（主要用于替换）
     */
    private String numberFormat;

    /**
     * 是否存在年份
     */
    private Boolean haveYearFlag;

    /**
     * 是否存在月份
     */
    private Boolean haveMonthFlag;

    /**
     * 是否存在 月
     */
    private Boolean haveDayFlag;

}
