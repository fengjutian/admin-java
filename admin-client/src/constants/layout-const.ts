/*
 * 布局格式
 *
 */

import { SmartEnum } from '/@/types/smart-enum';

export const LAYOUT_ENUM: SmartEnum<string> = {
  SIDE: {
    value: 'side',
    desc: '传统',
  },
  SIDE_EXPAND: {
    value: 'side-expand',
    desc: '展开',
  },
  TOP: {
    value: 'top',
    desc: '顶部',
  },
  TOP_EXPAND: {
    value: 'top-expand',
    desc: '分组',
  },
};

export const PAGE_TAG_ENUM: SmartEnum<string> = {
  DEFAULT: {
    value: 'default',
    desc: '默认',
  },
  ANTD: {
    value: 'antd',
    desc: 'Ant Design',
  },
  CHROME: {
    value: 'chrome',
    desc: 'Chrome',
  },
};

