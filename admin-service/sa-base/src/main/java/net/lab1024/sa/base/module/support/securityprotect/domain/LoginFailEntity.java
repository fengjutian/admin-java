package net.lab1024.sa.base.module.support.securityprotect.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 登录失败记录
 *
 */

@Data
@Builder
@TableName("t_login_fail")
public class LoginFailEntity {


    @TableId(type = IdType.AUTO)
    private Long loginFailId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 锁定状态
     */
    private Boolean lockFlag;

    /**
     * 登录失败次数
     */
    private Integer loginFailCount;

    /**
     * 连续登录失败锁定开始时间
     */
    private LocalDateTime loginLockBeginTime;


    private LocalDateTime updateTime;

    private LocalDateTime createTime;


}
