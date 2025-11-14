package net.lab1024.sa.base.module.ai;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * AI服务类
 * 
 * @author Spring Boot AI Integration
 * @date 2024-01-01
 */
@Slf4j
@Service
public class AIService {

    private final OpenAiChatModel chatModel;

    @Value("${spring.ai.openai.api-key:your-openai-api-key}")
    private String apiKey;

    @Autowired
    public AIService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * 简单聊天对话
     * 
     * @param message 用户消息
     * @return AI回复
     */
    public String chat(String message) {
        try {
            ChatResponse response = chatModel.call(new Prompt(message));
            return response.getResult().getOutput().getText();
        } catch (Exception e) {
            log.error("AI聊天服务异常", e);
            return "抱歉，AI服务暂时不可用，请稍后再试。";
        }
    }

    /**
     * 代码生成助手
     * 
     * @param language 编程语言
     * @param description 功能描述
     * @return 生成的代码
     */
    public String generateCode(String language, String description) {
        String template = "请为以下功能生成" + language + "代码：\n" +
                "功能描述：" + description + "\n" +
                "要求：\n" +
                "1. 代码要简洁、高效\n" +
                "2. 包含必要的注释\n" +
                "3. 遵循最佳实践\n" +
                "4. 只返回代码，不要其他说明";
        
        return chat(template);
    }

    /**
     * 文本摘要
     * 
     * @param text 原始文本
     * @return 摘要内容
     */
    public String summarize(String text) {
        String template = "请为以下文本生成简洁的摘要（不超过100字）：\n\n" + text;
        return chat(template);
    }
}