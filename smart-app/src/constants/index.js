/*
 * 所有常量入口
 *
 */
import { FLAG_NUMBER_ENUM, GENDER_ENUM, USER_TYPE_ENUM } from './common-const';
import loginDevice from './system/login-device-const';
import enterpriseConst from './business/oa/enterprise-const';
import goodsConst from './business/erp/goods-const';
import changeLogConst from './support/change-log-const';
import fileConst from './support/file-const';
import messageConst from "./support/message-const";

export default {
  FLAG_NUMBER_ENUM,
  GENDER_ENUM,
  USER_TYPE_ENUM,
  ...loginDevice,
  ...enterpriseConst,
  ...goodsConst,
  ...changeLogConst,
  ...fileConst,
  ...messageConst
};

