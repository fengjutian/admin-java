/*
 * 登录页面
 *
 */

import { RouteRecordRaw } from 'vue-router';
export const loginRouters: Array<RouteRecordRaw> = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('/@/views/system/login3/login.vue'),
    meta: {
      title: '登录',
      hideInMenu: true,
    },
  },
];

