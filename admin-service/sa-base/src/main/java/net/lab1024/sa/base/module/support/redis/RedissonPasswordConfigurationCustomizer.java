package net.lab1024.sa.base.module.support.redis;

import org.redisson.config.Config;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.stereotype.Component;

import net.lab1024.sa.base.common.util.SmartStringUtil;

/**
 *
 * redission对于password 为空处理有问题，重新设置下
 
 */

@Component
public class RedissonPasswordConfigurationCustomizer implements RedissonAutoConfigurationCustomizer {
    @Override
    public void customize(Config configuration) {
        if (configuration.isSingleConfig() && SmartStringUtil.isEmpty(configuration.useSingleServer().getPassword())) {
            configuration.useSingleServer().setPassword(null);
        }

        if (configuration.isClusterConfig() && SmartStringUtil.isEmpty(configuration.useClusterServers().getPassword())) {
            configuration.useClusterServers().setPassword(null);
        }
        if (configuration.isSentinelConfig() && SmartStringUtil.isEmpty(configuration.useSentinelServers().getPassword())) {
            configuration.useSentinelServers().setPassword(null);
        }
    }
}
