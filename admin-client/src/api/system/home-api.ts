/*
 * 首页api
 *
 */
import { getRequest } from '/@/lib/axios';

export const homeApi = {
  /**
   * @description: 首页-金额统计（业绩、收款、订单数等） @author 卓大
   */
  homeAmountStatistics: () => {
    return getRequest('/home/amount/statistics');
  },
  /**
   * @description: 首页-待办信息 @author 卓大
   */
  homeWaitHandle: () => {
    return getRequest('home/wait/handle');
  },
};

