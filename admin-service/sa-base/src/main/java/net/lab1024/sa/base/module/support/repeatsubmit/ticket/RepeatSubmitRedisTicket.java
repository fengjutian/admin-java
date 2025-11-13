package net.lab1024.sa.base.module.support.repeatsubmit.ticket;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 凭证（redis实现）
 *
 */
public class RepeatSubmitRedisTicket extends AbstractRepeatSubmitTicket {

    private final RedisTemplate<String, Object> redisTemplate;

    public RepeatSubmitRedisTicket(RedisTemplate<String, Object> redisTemplate,
                                   Function<HttpServletRequest, String> ticketFunction) {
        super(ticketFunction);
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean tryLock(String ticket, Long currentTimestamp, Long intervalMilliSecond) {
        if (intervalMilliSecond > 0) {
            return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(ticket, String.valueOf(currentTimestamp), intervalMilliSecond, TimeUnit.MILLISECONDS));
        } else {
            return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(ticket, String.valueOf(currentTimestamp)));
        }
    }

    @Override
    public void unLock(String ticket, Long intervalMilliSecond) {
        if (intervalMilliSecond > 0) {
            return;
        }

        redisTemplate.delete(ticket);
    }


}
