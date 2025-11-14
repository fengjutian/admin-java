/**
 * 职务表 api 封装
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const positionApi = {

  queryPage : (param) => {
    return postRequest('/position/queryPage', param);
  },

  add: (param) => {
      return postRequest('/position/add', param);
  },

  update: (param) => {
      return postRequest('/position/update', param);
  },


  delete: (id) => {
      return getRequest(`/position/delete/${id}`);
  },

  batchDelete: (idList) => {
    return postRequest('/position/batchDelete', idList);
  },

  queryList: () => {
    return getRequest('/position/queryList');
  },

};

