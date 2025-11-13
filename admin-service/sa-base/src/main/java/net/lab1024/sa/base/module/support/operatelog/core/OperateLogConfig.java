package net.lab1024.sa.base.module.support.operatelog.core;

import java.util.function.Function;

import lombok.Builder;
import lombok.Data;
import net.lab1024.sa.base.module.support.operatelog.domain.OperateLogEntity;

/**
 * 配置
 *
 */
@Data
@Builder
public class OperateLogConfig {

    /**
     * 操作日志存储方法
     */
    private Function<OperateLogEntity, Boolean> saveFunction;

    /**
     * 核心线程数
     */
    private Integer corePoolSize;

    /**
     * 队列大小
     */
    private Integer queueCapacity;


}
