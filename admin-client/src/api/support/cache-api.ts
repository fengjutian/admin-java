/*
 * 缓存
 */
import {getRequest} from '/@/lib/axios';

export const cacheApi = {
  // 获取某个缓存的所有key  
  getKeys: (cacheName) => {
    return getRequest(`/support/cache/keys/${cacheName}`);
  },
  // 移除某个缓存  
  remove: (cacheName) => {
    return getRequest(`/support/cache/remove/${cacheName}`);
  },
  // 获取所有缓存  
  getAllCacheNames: () => {
    return getRequest('/support/cache/names');
  },
};
