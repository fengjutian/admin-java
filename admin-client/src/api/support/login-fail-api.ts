/**
 * 登录锁定 api 封装
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const loginFailApi = {

  /**
   * 分页查询
   */
  queryPage : (param) => {
    return postRequest('/support/protect/loginFail/queryPage', param);
  },

  /**
   * 批量删除
   */
  batchDelete: (idList) => {
      return postRequest('/support/protect/loginFail/batchDelete', idList);
  },

};
