package net.lab1024.sa.base.module.support.cache;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 缓存服务
 *
 */
@Service
public interface CacheService {

    /**
     * 获取所有缓存名称
     */
    List<String> cacheNames();

    /**
     * 某个缓存下的所有 key
     */
    List<String> cacheKey(String cacheName);

    /**
     * 移除某个 key
     */
    void removeCache(String cacheName);

}