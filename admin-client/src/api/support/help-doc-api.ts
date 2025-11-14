/*
 * 帮助文档
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const helpDocApi = {
  // 【管理】帮助文档-分页查询  zhuoda
  query: (param) => {
    return postRequest('/support/helpDoc/query', param);
  },

  //【管理】帮助文档-更新  zhuoda
  update: (param) => {
    return postRequest('/support/helpDoc/update', param);
  },

  // 【管理】帮助文档-添加  zhuoda
  add: (param) => {
    return postRequest('/support/helpDoc/add', param);
  },

  //【管理】帮助文档-删除  zhuoda
  delete: (helpDocId) => {
    return getRequest(`/support/helpDoc/delete/${helpDocId}`);
  },

  //【管理】帮助文档-获取详情  zhuoda
  getDetail: (helpDocId) => {
    return getRequest(`/support/helpDoc/getDetail/${helpDocId}`);
  },

  //【管理】帮助文档-根据关联id查询  zhuoda
  queryHelpDocByRelationId: (relationId) => {
    return getRequest(`/support/helpDoc/queryHelpDocByRelationId/${relationId}`);
  },

  //----------------------- 用户相关 --------------------------------

  //【用户】帮助文档-查询全部  zhuoda
  getAllHelpDocList() {
    return getRequest('/support/helpDoc/user/queryAllHelpDocList');
  },

  //【用户】帮助文档-查询全部  zhuoda
  view(helpDocId) {
    return getRequest(`/support/helpDoc/user/view/${helpDocId}`);
  },

  //【用户】帮助文档-查询 查看记录  zhuoda
  queryViewRecord(param) {
    return postRequest('/support/helpDoc/user/queryViewRecord', param);
  },
};
