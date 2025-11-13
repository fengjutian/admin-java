/*
 *  权限插件
 *
 */
import { useUserStore } from '/@/store/modules/system/user';
import { App } from 'vue';
import _ from 'lodash';

const privilege = (value: string) => {
  // 超级管理员
  if (useUserStore().administratorFlag) {
    return true;
  }
  // 获取功能点权限
  let userPointsList = useUserStore().getPointList;
  if (!userPointsList) {
    return false;
  }
  return _.some(userPointsList, ['webPerms', value]);
};

export default {
  install: (app: App): void => {
    app.config.globalProperties.$privilege = privilege;
  },
};

