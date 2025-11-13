/**
 * 系统更新日志 api 封装
 *
 */
import { postRequest, getRequest } from '@/lib/smart-request';

export const changeLogApi = {
  /**
   * 分页查询  @author  卓大
   */
  queryPage: (param) => {
    return postRequest('/support/changeLog/queryPage', param);
  },

  /**
   * 详情  @author  卓大
   */
  getDetail: (changeLogId) => {
    return getRequest(`/support/changeLog/getDetail/${changeLogId}`);
  },
};

