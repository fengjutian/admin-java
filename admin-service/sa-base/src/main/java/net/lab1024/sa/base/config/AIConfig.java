package net.lab1024.sa.base.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AI配置类
 */
@Slf4j
@Configuration
public class AIConfig {

    @Value("${ai.api-key:your-ai-api-key}")
    private String apiKey;

    /**
     * 创建ChatModel bean
     */
    @Bean
    public ChatModel chatModel() {
        log.info("创建模拟ChatModel bean");
        return new MockChatModel();
    }

    /**
     * 简单的ChatModel接口
     */
    public interface ChatModel {
        String call(String message);
    }

    /**
     * 模拟的ChatModel实现
     */
    public static class MockChatModel implements ChatModel {
        
        @Override
        public String call(String message) {
            return "您好！这是一个模拟的AI回复。当前AI服务未正确配置。\n" +
                   "收到的消息：" + message + "\n" +
                   "请在配置文件中设置正确的AI API密钥。";
        }
    }
}