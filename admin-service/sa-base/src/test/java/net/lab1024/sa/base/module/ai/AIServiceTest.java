package net.lab1024.sa.base.module.ai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

/**
 * AI服务测试类
 * 
 * @author Spring Boot AI Integration
 * @date 2024-01-01
 */
@SpringBootTest
@TestPropertySource(properties = {
    "spring.ai.openai.api-key=test-key",
    "spring.ai.openai.chat.model=gpt-3.5-turbo",
    "spring.ai.openai.embedding.model=text-embedding-ada-002"
})
public class AIServiceTest {

    @Autowired
    private AIService aiService;

    @Test
    public void testChatService() {
        // 测试聊天功能
        String response = aiService.chat("你好，请介绍一下你自己");
        assertNotNull(response);
        assertFalse(response.contains("AI服务暂时不可用"));
    }

    @Test
    public void testGenerateCode() {
        // 测试代码生成功能
        String code = aiService.generateCode("Java", "创建一个简单的Hello World程序");
        assertNotNull(code);
        assertTrue(code.contains("public") || code.contains("class") || code.contains("main"));
    }

    @Test
    public void testSummarize() {
        // 测试文本摘要功能
        String text = "人工智能（Artificial Intelligence，简称AI）是计算机科学的一个分支，" +
                     "它企图了解智能的实质，并生产出一种新的能以人类智能相似的方式做出反应的智能机器。";
        String summary = aiService.summarize(text);
        assertNotNull(summary);
        assertTrue(summary.length() <= 200); // 摘要应该比较简洁
    }
}