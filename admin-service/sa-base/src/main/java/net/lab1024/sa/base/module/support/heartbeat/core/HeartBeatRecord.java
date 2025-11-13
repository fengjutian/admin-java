package net.lab1024.sa.base.module.support.heartbeat.core;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 心跳记录日志
 *
 */
@Data
public class HeartBeatRecord {

    /**
     * 项目名字
     */
    private String projectPath;
    /**
     * 服务器ip
     */
    private String serverIp;
    /**
     * 进程号
     */
    private Integer processNo;
    /**
     * 进程开启时间
     */
    private LocalDateTime processStartTime;
    /**
     * 心跳当前时间
     */
    private LocalDateTime heartBeatTime;


}
