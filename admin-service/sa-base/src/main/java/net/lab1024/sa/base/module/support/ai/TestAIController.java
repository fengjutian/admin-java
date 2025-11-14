package net.lab1024.sa.base.module.support.ai;

import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.base.common.controller.SupportBaseController;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试AI控制器
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestAIController extends SupportBaseController {

    @GetMapping("/hello")
    public ResponseDTO<String> hello() {
        log.info("测试AI控制器被访问");
        return ResponseDTO.ok("Hello from AI Controller!");
    }
}