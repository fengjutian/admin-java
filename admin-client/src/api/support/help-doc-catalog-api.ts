/*
 * 帮助文档 目录
 */
import { postRequest, getRequest } from '/@/lib/axios';

export const helpDocCatalogApi = {
  //帮助文档目录-获取全部  zhuoda
  getAll: () => {
    return getRequest('/support/helpDoc/helpDocCatalog/getAll');
  },

  //帮助文档目录-添加  zhuoda
  add: (param) => {
    return postRequest('/support/helpDoc/helpDocCatalog/add', param);
  },

  //帮助文档目录-更新  zhuoda
  update: (param) => {
    return postRequest('/support/helpDoc/helpDocCatalog/update', param);
  },

  //帮助文档目录-删除  zhuoda
  delete: (helpDocCatalogId) => {
    return getRequest(`/support/helpDoc/helpDocCatalog/delete/${helpDocCatalogId}`);
  },
};
