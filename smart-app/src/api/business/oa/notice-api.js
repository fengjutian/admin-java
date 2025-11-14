
import { postRequest, getRequest } from '@/lib/smart-request';

export const noticeApi = {
  // ---------------- 通知公告类型 -----------------------

  // 通知公告类型-获取全部  zhuoda
  getAllNoticeTypeList() {
    return getRequest('/oa/noticeType/getAll');
  },

  // --------------------- 【员工】查看 通知公告 -------------------------

  // 通知公告-员工-查看详情  zhuoda
  view(noticeId) {
    return getRequest(`/oa/notice/employee/view/${noticeId}`);
  },

  // 通知公告-员工-查询  zhuoda
  queryEmployeeNotice(param) {
    return postRequest('/oa/notice/employee/query', param);
  },

  // 【员工】通知公告-查询 查看记录  zhuoda
  queryViewRecord(param) {
    return postRequest('/oa/notice/employee/queryViewRecord', param);
  },
};
