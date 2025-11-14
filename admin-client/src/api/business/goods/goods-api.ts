
import {postRequest, getRequest, getDownload} from '/@/lib/axios';

export const goodsApi = {
  // 添加商品  zhuoda
  addGoods: (param) => {
    return postRequest('/goods/add', param);
  },
  // 删除  zhuoda
  deleteGoods: (goodsId) => {
    return getRequest(`/goods/delete/${goodsId}`);
  },
  // 批量  zhuoda
  batchDelete: (goodsIdList) => {
    return postRequest('/goods/batchDelete', goodsIdList);
  },
  // 分页查询  zhuoda
  queryGoodsList: (param) => {
    return postRequest('/goods/query', param);
  },
  // 更新商品  zhuoda
  updateGoods: (param) => {
    return postRequest('/goods/update', param);
  },

  // 导入  卓大
  importGoods : (file) =>{
    return postRequest('/goods/importGoods',file);
  },

  // 导出  卓大
  exportGoods : () =>{
    return getDownload('/goods/exportGoods');
  }
};
