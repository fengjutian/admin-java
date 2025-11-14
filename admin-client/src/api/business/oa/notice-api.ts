
import { postRequest, getRequest } from '/@/lib/axios';

export const noticeApi = {
  // ---------------- 通知公告类型 -----------------------

  // 通知公告类型-获取全部  zhuoda
  getAllNoticeTypeList() {
    return getRequest('/oa/noticeType/getAll');
  },

  // 通知公告类型-添加  zhuoda
  addNoticeType(name) {
    return getRequest(`/oa/noticeType/add/${name}`);
  },

  // 通知公告类型-修改  zhuoda
  updateNoticeType(noticeTypeId, name) {
    return getRequest(`/oa/noticeType/update/${noticeTypeId}/${name}`);
  },
  // 通知公告类型-删除  zhuoda
  deleteNoticeType(noticeTypeId) {
    return getRequest(`/oa/noticeType/delete/${noticeTypeId}`);
  },

  // ---------------- 通知公告管理 -----------------------

  // 通知公告-分页查询  zhuoda
  queryNotice(param) {
    return postRequest('/oa/notice/query', param);
  },

  // 通知公告-添加  zhuoda
  addNotice(param) {
    return postRequest('/oa/notice/add', param);
  },

  // 通知公告-更新  zhuoda
  updateNotice(param) {
    return postRequest('/oa/notice/update', param);
  },

  // 通知公告-删除  zhuoda
  deleteNotice(noticeId) {
    return getRequest(`/oa/notice/delete/${noticeId}`);
  },

  // 通知公告-更新详情  zhuoda
  getUpdateNoticeInfo(noticeId) {
    return getRequest(`/oa/notice/getUpdateVO/${noticeId}`);
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
