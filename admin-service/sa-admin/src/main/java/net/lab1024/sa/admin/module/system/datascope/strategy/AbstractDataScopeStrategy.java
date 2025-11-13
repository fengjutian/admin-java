package net.lab1024.sa.admin.module.system.datascope.strategy;

import net.lab1024.sa.admin.module.system.datascope.constant.DataScopeViewTypeEnum;
import net.lab1024.sa.admin.module.system.datascope.domain.DataScopeSqlConfig;

import java.util.Map;

/**
 * 数据范围策略 ,使用DataScopeWhereInTypeEnum.CUSTOM_STRATEGY类型，DataScope注解的joinSql属性无用
 *
 */
public abstract class AbstractDataScopeStrategy {

    /**
     * 获取joinsql 字符串
     */
    public abstract String getCondition(DataScopeViewTypeEnum viewTypeEnum, Map<String, Object> paramMap, DataScopeSqlConfig sqlConfigDTO);
}
