
import { postRequest, getRequest } from '@/lib/smart-request';

export const dictApi = {
  // 分页查询数据字典KEY -  
  keyQuery: (param) => {
    return postRequest('/support/dict/key/query', param);
  },
  // 查询全部字典key -  
  queryAllKey: () => {
    return getRequest('/support/dict/key/queryAll');
  },
  /**
   * 分页查询数据字典value -  
   */
  valueQuery: (param) => {
    return postRequest('/support/dict/value/query', param);
  },
  // 数据字典KEY-添加-  
  keyAdd: (param) => {
    return postRequest('/support/dict/key/add', param);
  },
  // 分页查询数据字典value -  
  valueAdd: (param) => {
    return postRequest('/support/dict/value/add', param);
  },
  // 数据字典key-更新-  
  keyEdit: (param) => {
    return postRequest('/support/dict/key/edit', param);
  },
  // 数据字典Value-更新-  
  valueEdit: (param) => {
    return postRequest('/support/dict/value/edit', param);
  },
  // 数据字典key-删除-  
  keyDelete: (keyIdList) => {
    return postRequest('/support/dict/key/delete', keyIdList);
  },
  // 数据字典Value-删除-  
  valueDelete: (valueIdList) => {
    return postRequest('/support/dict/value/delete', valueIdList);
  },
  // 缓存刷新-  
  cacheRefresh: () => {
    return getRequest('/support/dict/cache/refresh');
  },
  // 数据字典-值列表-  
  valueList: (keyCode) => {
    return getRequest(`/support/dict/value/list/${keyCode}`);
  },
};

