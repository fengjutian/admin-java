/**
 * 系统更新日志 api 封装
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const changeLogApi = {
  queryPage: (param) => {
    return postRequest('/support/changeLog/queryPage', param);
  },

  add: (param) => {
    return postRequest('/support/changeLog/add', param);
  },

  update: (param) => {
    return postRequest('/support/changeLog/update', param);
  },


  delete: (id) => {
    return getRequest(`/support/changeLog/delete/${id}`);
  },

  batchDelete: (idList) => {
    return postRequest('/support/changeLog/batchDelete', idList);
  },
};
