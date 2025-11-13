

import { LocationQueryRaw } from 'vue-router';

/**
 * 用户的tag列表
 */
export interface UserTagNav {
  /**
   * 菜单名称-ID
   */
  menuName: string;
  /**
   * 菜单标题
   */
  menuTitle: string;
  /**
   * 菜单请求参数
   */
  menuQuery?: LocationQueryRaw;
  /**
   * 从哪个菜单过来的
   */
  fromMenuName?: string;
  /**
   * 从哪个菜单过来的 请求参数
   */
  fromMenuQuery?: LocationQueryRaw;
}
