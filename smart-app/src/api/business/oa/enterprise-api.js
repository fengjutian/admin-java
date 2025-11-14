/*
 * 企业信息
 *
 */
import { postRequest, getRequest } from '@/lib/smart-request';

export const enterpriseApi = {
  // 新建企业  开云
  create: (param) => {
    return postRequest('/oa/enterprise/create', param);
  },

  // 查询企业详情  开云
  detail: (enterpriseId) => {
    return getRequest(`/oa/enterprise/get/${enterpriseId}`);
  },

  // 分页查询企业模块  开云
  pageQuery: (param) => {
    return postRequest('/oa/enterprise/page/query', param);
  },

  // 编辑企业  开云
  update: (param) => {
    return postRequest('/oa/enterprise/update', param);
  },

  // 删除企业  开云
  delete: (enterpriseId) => {
    return getRequest(`/oa/enterprise/delete/${enterpriseId}`);
  },
};

