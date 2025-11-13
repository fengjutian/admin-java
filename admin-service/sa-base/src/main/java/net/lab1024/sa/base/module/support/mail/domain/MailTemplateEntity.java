package net.lab1024.sa.base.module.support.mail.domain;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 *
 * 邮件模板
 *
 */
@Data
@TableName("t_mail_template")
public class MailTemplateEntity {

    @TableId(type = IdType.NONE)
    private String templateCode;

    /**
     * 主题
     */
    private String templateSubject;

    /**
     * 模板类型
     */
    private String templateType;

    /**
     * 模板内容
     */
    private String templateContent;

    /**
     * 禁用标识
     */
    private Boolean disableFlag;


    private LocalDateTime updateTime;

    private LocalDateTime createTime;
}
