/*
 * 意见反馈
 *
 */
import { postRequest } from '/src/lib/smart-request';

export const feedbackApi = {
  // 意见反馈-新增
  addFeedback: (params) => {
    return postRequest('/support/feedback/add', params);
  },
};

