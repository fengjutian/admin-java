/*
 * 登录日志
 *
 */

import { SmartEnum } from '/@/types/smart-enum';

export const LOGIN_RESULT_ENUM: SmartEnum<number> = {
  LOGIN_SUCCESS: {
    value: 0,
    desc: '登录成功',
  },
  LOGIN_FAIL: {
    value: 1,
    desc: '登录失败',
  },
  LOGIN_OUT: {
    value: 2,
    desc: '退出登录',
  },
};

export default {
  LOGIN_RESULT_ENUM,
};

