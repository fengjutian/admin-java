package net.lab1024.sa.base.module.support.ai;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.base.common.code.UserErrorCode;
import net.lab1024.sa.base.common.controller.SupportBaseController;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.constant.SwaggerTagConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * AI服务控制器
 */
@Slf4j
@RestController
@Tag(name = SwaggerTagConst.Support.AI)
public class AIController extends SupportBaseController {

    @Autowired
    private AIService aiService;

    @Operation(summary = "AI聊天对话")
    @PostMapping("/ai/chat")
    public ResponseDTO<String> chat(@Valid @RequestBody ChatRequest request) {
      try {
        String response = aiService.chat(request.getMessage());
        return ResponseDTO.ok(response);
      } catch (Exception e) {
        log.error("AI聊天接口异常", e);
        return ResponseDTO.error(UserErrorCode.PARAM_ERROR, "AI服务暂时不可用");
      }
    }

    @Operation(summary = "代码生成")
    @PostMapping("/ai/generate-code")
    public ResponseDTO<String> generateCode(@Valid @RequestBody CodeGenerateRequest request) {
        try {
            String code = aiService.generateCode(request.getLanguage(), request.getDescription());
            return ResponseDTO.ok(code);
        } catch (Exception e) {
            log.error("代码生成接口异常", e);
            return ResponseDTO.error(UserErrorCode.PARAM_ERROR, "代码生成服务暂时不可用");
        }
    }

    @Operation(summary = "文本摘要")
    @PostMapping("/ai/summarize")
    public ResponseDTO<String> summarize(@Valid @RequestBody SummarizeRequest request) {
        try {
            String summary = aiService.summarize(request.getText());
            return ResponseDTO.ok(summary);
        } catch (Exception e) {
            log.error("文本摘要接口异常", e);
            return ResponseDTO.error(UserErrorCode.PARAM_ERROR, "文本摘要服务暂时不可用");
        }
    }

    /**
     * 聊天请求DTO
     */
    public static class ChatRequest {
        @NotBlank(message = "消息内容不能为空")
        @Size(max = 1000, message = "消息内容不能超过1000字符")
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 代码生成请求DTO
     */
    public static class CodeGenerateRequest {
        @NotBlank(message = "编程语言不能为空")
        private String language;

        @NotBlank(message = "功能描述不能为空")
        @Size(max = 500, message = "功能描述不能超过500字符")
        private String description;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    /**
     * 文本摘要请求DTO
     */
    public static class SummarizeRequest {
        @NotBlank(message = "文本内容不能为空")
        @Size(max = 2000, message = "文本内容不能超过2000字符")
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}