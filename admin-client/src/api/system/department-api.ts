/*
 * 部门
 */
import { getRequest, postRequest } from '/@/lib/axios';

export const departmentApi = {
  /**
   * 查询部门列表
   */
  queryAllDepartment: () => {
    return getRequest('/department/listAll');
  },

  /**
   * 查询部门树形列表
   */
  queryDepartmentTree: () => {
    return getRequest('/department/treeList');
  },

  /**
   * 添加部门
   */
  addDepartment: (param) => {
    return postRequest('/department/add', param);
  },
  /**
   * 更新部门信息
   */
  updateDepartment: (param) => {
    return postRequest('/department/update', param);
  },
  /**
   * 删除
   */
  deleteDepartment: (departmentId) => {
    return getRequest(`/department/delete/${departmentId}`);
  },
};

