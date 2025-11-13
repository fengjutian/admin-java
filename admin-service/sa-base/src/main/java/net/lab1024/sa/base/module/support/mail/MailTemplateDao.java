package net.lab1024.sa.base.module.support.mail;


import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import net.lab1024.sa.base.module.support.mail.domain.MailTemplateEntity;

/**
 * 邮件模板
 */
@Mapper
public interface MailTemplateDao extends BaseMapper<MailTemplateEntity> {

}
