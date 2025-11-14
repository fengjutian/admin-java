package net.lab1024.sa.base.module.ai;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * AI服务单元测试类
 */
public class AIServiceUnitTest {

    @Mock
    private OpenAiChatModel chatModel;

    private AIService aiService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        aiService = new AIService(chatModel);
    }

    @Test
    public void testChatServiceException() {
        // 模拟异常
        when(chatModel.call(any(Prompt.class))).thenThrow(new RuntimeException("API Error"));

        // 测试异常处理
        String response = aiService.chat("测试消息");
        assertNotNull(response);
        assertTrue(response.contains("AI服务暂时不可用"));
    }

    @Test
    public void testGenerateCode() {
        // 模拟异常情况下的代码生成
        when(chatModel.call(any(Prompt.class))).thenThrow(new RuntimeException("API Error"));

        // 测试代码生成功能（异常情况）
        String code = aiService.generateCode("Java", "创建一个简单的Hello World程序");
        assertNotNull(code);
        assertTrue(code.contains("AI服务暂时不可用"));
    }

    @Test
    public void testSummarize() {
        // 模拟异常情况下的摘要
        when(chatModel.call(any(Prompt.class))).thenThrow(new RuntimeException("API Error"));

        // 测试文本摘要功能（异常情况）
        String text = "人工智能（Artificial Intelligence，简称AI）是计算机科学的一个分支。";
        String summary = aiService.summarize(text);
        assertNotNull(summary);
        assertTrue(summary.contains("AI服务暂时不可用"));
    }

    @Test
    public void testAIServiceCreation() {
        // 测试AI服务创建
        assertNotNull(aiService);
        assertNotNull(chatModel);
    }
}