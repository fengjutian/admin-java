import { getRequest, postRequest } from '/@/lib/axios';

export const roleApi = {
  queryAll: () => {
    return getRequest('/role/getAll');
  },

  addRole: (data) => {
    return postRequest('/role/add', data);
  },

  updateRole: (data) => {
    return postRequest('/role/update', data);
  },

  deleteRole: (roleId) => {
    return getRequest(`/role/delete/${roleId}`);
  },

  updateDataScope: (data) => {
    return postRequest('/role/dataScope/updateRoleDataScopeList', data);
  },
  /**
   * @description: 获取当前系统所配置的所有数据范围
   */
  getDataScopeList: () => {
    return getRequest('/dataScope/list');
  },
  /**
   * @description: 获取某角色所设置的数据范围
   */
  getDataScopeByRoleId: (roleId) => {
    return getRequest(`/role/dataScope/getRoleDataScopeList/${roleId}`);
  },
  /**
   * @description: 获取角色成员-员工列表
   */
  queryRoleEmployee: (params) => {
    return postRequest('/role/employee/queryEmployee', params);
  },
  /**
   * @description: 从角色成员列表中移除员工
   */
  deleteEmployeeRole: (employeeId, roleId) => {
    return getRequest('/role/employee/removeEmployee?employeeId=' + employeeId + '&roleId=' + roleId);
  },
  /**
   * @description: 从角色成员列表中批量移除员工
   */
  batchRemoveRoleEmployee: (data) => {
    return postRequest('/role/employee/batchRemoveRoleEmployee', data);
  },
  /**
   * @description: 根据角色id获取角色员工列表(无分页)
   */
  getRoleAllEmployee: (roleId) => {
    return getRequest(`/role/employee/getAllEmployeeByRoleId/${roleId}`);
  },
  /**
   * @description: 角色成员列表中批量添加员工
   */
  batchAddRoleEmployee: (data) => {
    return postRequest('/role/employee/batchAddRoleEmployee', data);
  },
};

