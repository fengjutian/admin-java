/*
 * 类目api
 */
import { getRequest, postRequest } from '/@/lib/axios';

export const categoryApi = {
  // 添加类目  
  addCategory: (param) => {
    return postRequest('/category/add', param);
  },
  // GET
  // 删除类目  
  deleteCategoryById: (categoryId) => {
    return getRequest(`/category/delete/${categoryId}`);
  },
  // 查询类目层级树  
  queryCategoryTree: (param) => {
    return postRequest('/category/tree', param);
  },
  // 更新类目  
  updateCategory: (param) => {
    return postRequest('/category/update', param);
  },
};
