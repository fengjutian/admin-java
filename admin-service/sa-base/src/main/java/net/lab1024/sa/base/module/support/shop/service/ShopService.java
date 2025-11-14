package net.lab1024.sa.base.module.support.shop.service;

import net.lab1024.sa.base.common.domain.PageResult;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.module.support.shop.domain.ShopQueryForm;
import net.lab1024.sa.base.module.support.shop.entity.Shop;

/**
 * Shop Service
 *
 */
public interface ShopService {

    /**
     * 新增
     */
    ResponseDTO<String> add(Shop shop);

    /**
     * 更新
     */
    ResponseDTO<String> update(Shop shop);

    /**
     * 删除（逻辑删除）
     */
    ResponseDTO<String> delete(Long id);

    /**
     * 查询详情
     */
    ResponseDTO<Shop> getDetail(Long id);

    /**
     * 分页查询
     */
    ResponseDTO<PageResult<Shop>> queryPage(ShopQueryForm queryForm);
}
