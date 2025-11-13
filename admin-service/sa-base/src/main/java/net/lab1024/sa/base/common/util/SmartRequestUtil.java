package net.lab1024.sa.base.common.util;

import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.base.common.domain.RequestUser;

/**
 * 请求用户  工具类
 *
 */
@Slf4j
public class SmartRequestUtil {

    private static final ThreadLocal<RequestUser> REQUEST_THREAD_LOCAL = new ThreadLocal<>();

    public static void setRequestUser(RequestUser requestUser) {
        if(requestUser == null){
            return;
        }
        REQUEST_THREAD_LOCAL.set(requestUser);
    }

    public static RequestUser getRequestUser() {
        return REQUEST_THREAD_LOCAL.get();
    }

    public static Long getRequestUserId() {
        RequestUser requestUser = getRequestUser();
        return null == requestUser ? null : requestUser.getUserId();
    }


    public static void remove() {
        REQUEST_THREAD_LOCAL.remove();
    }


}
