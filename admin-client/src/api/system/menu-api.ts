import { getRequest, postRequest } from '/@/lib/axios';

export const menuApi = {

  addMenu: (param) => {
    return postRequest('/menu/add', param);
  },

  updateMenu: (param) => {
    return postRequest('/menu/update', param);
  },

  batchDeleteMenu: (menuIdList) => {
    return getRequest(`/menu/batchDelete?menuIdList=${menuIdList}`);
  },

  queryMenu: () => {
    return getRequest('/menu/query');
  },

  queryMenuTree: (onlyMenu) => {
    return getRequest(`/menu/tree?onlyMenu=${onlyMenu}`);
  },

  getAuthUrl: () => {
    return getRequest('/menu/auth/url');
  },
};

