
import { getRequest, postRequest } from '@/lib/smart-request';

export const loginApi = {
  /**
   * 登录 @author 卓大
   */
  login: (param) => {
    return postRequest('/login', param);
  },

  /**
   * 退出登录 @author 卓大
   */
  logout: () => {
    return getRequest('/login/logout');
  },

  /**
   * 获取验证码 @author 卓大
   */
  getCaptcha: () => {
    return getRequest('/login/getCaptcha');
  },

  /**
   * 获取登录信息 @author 卓大
   */
  getLoginInfo: () => {
    return getRequest('/login/getLoginInfo');
  },
   /**
   * 获取双因子登录标识 @author 卓大
   */
   getTwoFactorLoginFlag: () => {
    return getRequest('/login/getTwoFactorLoginFlag');
  },
    /**
   * 获取邮箱登录验证码 @author 卓大
   */
    sendLoginEmailCode: (loginName) => {
      return getRequest(`/login/sendEmailCode/${loginName}`);
    },
  
};

