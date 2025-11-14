/*
 * 企业信息
 */
import {postRequest, getRequest, postDownload} from '/@/lib/axios';

export const enterpriseApi = {
    // 新建企业  开云
    create: (param) => {
        return postRequest('/oa/enterprise/create', param);
    },

    // 删除企业  开云
    delete: (enterpriseId) => {
        return getRequest(`/oa/enterprise/delete/${enterpriseId}`);
    },

    // 查询企业详情  开云
    detail: (enterpriseId) => {
        return getRequest(`/oa/enterprise/get/${enterpriseId}`);
    },

    // 分页查询企业模块  开云
    pageQuery: (param) => {
        return postRequest('/oa/enterprise/page/query', param);
    },

    // 导出企业数据excel  
    exportExcel: (param) => {
        return postDownload('/oa/enterprise/exportExcel', param);
    },

    //企业列表查询 含数据范围  开云
    queryList: (type) => {
        let query = '';
        if (type) {
            query = `?type=${type}`;
        }
        return getRequest(`/oa/enterprise/query/list${query}`);
    },

    // 编辑企业  开云
    update: (param) => {
        return postRequest('/oa/enterprise/update', param);
    },
    // 企业全部员工List  yandy
    employeeList: (param) => {
        return postRequest('/oa/enterprise/employee/list', param);
    },
    // 分页查询企业员工List  
    queryPageEmployeeList: (param) => {
        return postRequest('/oa/enterprise/employee/queryPage', param);
    },
    // 添加员工  yandy
    addEmployee: (param) => {
        return postRequest('/oa/enterprise/employee/add', param);
    },

    // 删除员工  yandy
    deleteEmployee: (param) => {
        return postRequest('/oa/enterprise/employee/delete', param);
    },

};
