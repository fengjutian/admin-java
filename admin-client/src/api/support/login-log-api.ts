/*
 * 登录日志
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const loginLogApi = {
  // 分页查询
  queryList: (param) => {
    return postRequest('/support/loginLog/page/query', param);
  },
  // 分页查询当前登录人信息
  queryListLogin: (param) => {
    return postRequest('/support/loginLog/page/query/login', param);
  },
};
