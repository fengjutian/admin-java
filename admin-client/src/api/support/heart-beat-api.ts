/*
 * 心跳
 */
import { postRequest } from '/@/lib/axios';

export const heartBeatApi = {
  // 分页查询  卓大
  queryList: (param) => {
    return postRequest('/support/heartBeat/query', param);
  },
};
