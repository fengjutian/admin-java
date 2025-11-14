package net.lab1024.sa.base.module.support.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lab1024.sa.base.common.domain.PageResult;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.common.util.SmartPageUtil;
import net.lab1024.sa.base.module.support.datatracer.constant.DataTracerConst;
import net.lab1024.sa.base.module.support.datatracer.constant.DataTracerTypeEnum;
import net.lab1024.sa.base.module.support.datatracer.service.DataTracerService;
import net.lab1024.sa.base.module.support.shop.constant.ShopStatusEnum;
import net.lab1024.sa.base.module.support.shop.domain.ShopQueryForm;
import net.lab1024.sa.base.module.support.shop.entity.Shop;
import net.lab1024.sa.base.module.support.shop.mapper.ShopMapper;
import net.lab1024.sa.base.module.support.shop.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 店铺服务实现类
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;
    private final DataTracerService dataTracerService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> add(Shop shop) {
        // 参数校验
        if (!StringUtils.hasText(shop.getName())) {
            return ResponseDTO.userErrorParam("店铺名称不能为空");
        }
        if (shop.getOwnerId() == null) {
            return ResponseDTO.userErrorParam("店主ID不能为空");
        }
        
        // 检查店铺名称是否重复
        LambdaQueryWrapper<Shop> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Shop::getName, shop.getName())
                   .eq(Shop::getIsDeleted, false);
        Shop existShop = shopMapper.selectOne(queryWrapper);
        if (existShop != null) {
            return ResponseDTO.userErrorParam("店铺名称已存在");
        }

        // 设置默认状态
        if (shop.getStatus() == null) {
            shop.setStatus(ShopStatusEnum.ENABLE.getValue());
        }

        // 设置创建时间
        shop.setCreateTime(LocalDateTime.now());
        shop.setUpdateTime(LocalDateTime.now());
        shop.setIsDeleted(false);

        int result = shopMapper.insert(shop);
        if (result > 0) {
            // 添加数据追踪
            dataTracerService.addTrace(shop.getId(), DataTracerTypeEnum.SHOP, "新增店铺：" + DataTracerConst.HTML_BR + dataTracerService.getChangeContent(shop));
            return ResponseDTO.ok("新增成功");
        } else {
            return ResponseDTO.userErrorParam("新增失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(Shop shop) {
        // 参数校验
        if (shop.getId() == null) {
            return ResponseDTO.userErrorParam("店铺ID不能为空");
        }
        
        // 检查店铺是否存在
        Shop existShop = shopMapper.selectById(shop.getId());
        if (existShop == null || existShop.getIsDeleted()) {
            return ResponseDTO.userErrorParam("店铺不存在");
        }

        // 检查店铺名称是否重复（排除自己）
        if (StringUtils.hasText(shop.getName()) && !Objects.equals(existShop.getName(), shop.getName())) {
            LambdaQueryWrapper<Shop> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Shop::getName, shop.getName())
                       .eq(Shop::getIsDeleted, false)
                       .ne(Shop::getId, shop.getId());
            Shop nameExistShop = shopMapper.selectOne(queryWrapper);
            if (nameExistShop != null) {
                return ResponseDTO.userErrorParam("店铺名称已存在");
            }
        }

        // 设置更新时间
        shop.setUpdateTime(LocalDateTime.now());

        int result = shopMapper.updateById(shop);
        if (result > 0) {
            // 添加数据追踪
            dataTracerService.addTrace(shop.getId(), DataTracerTypeEnum.SHOP, "更新店铺：" + DataTracerConst.HTML_BR + dataTracerService.getChangeContent(existShop, shop));
            return ResponseDTO.ok("更新成功");
        } else {
            return ResponseDTO.userErrorParam("更新失败");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> delete(Long id) {
        // 参数校验
        if (id == null) {
            return ResponseDTO.userErrorParam("店铺ID不能为空");
        }
        
        // 检查店铺是否存在
        Shop existShop = shopMapper.selectById(id);
        if (existShop == null || existShop.getIsDeleted()) {
            return ResponseDTO.userErrorParam("店铺不存在");
        }

        // 逻辑删除
        Shop updateShop = new Shop();
        updateShop.setId(id);
        updateShop.setIsDeleted(true);
        updateShop.setUpdateTime(LocalDateTime.now());

        int result = shopMapper.updateById(updateShop);
        if (result > 0) {
            // 添加数据追踪
            dataTracerService.addTrace(id, DataTracerTypeEnum.SHOP, "删除店铺：" + DataTracerConst.HTML_BR + dataTracerService.getChangeContent(existShop));
            return ResponseDTO.ok("删除成功");
        } else {
            return ResponseDTO.userErrorParam("删除失败");
        }
    }

    @Override
    public ResponseDTO<Shop> getDetail(Long id) {
        // 参数校验
        if (id == null) {
            return ResponseDTO.userErrorParam("店铺ID不能为空");
        }
        
        Shop shop = shopMapper.selectById(id);
        if (shop == null || shop.getIsDeleted()) {
            return ResponseDTO.userErrorParam("店铺不存在");
        }

        return ResponseDTO.ok(shop);
    }

    @Override
    public ResponseDTO<PageResult<Shop>> queryPage(ShopQueryForm queryForm) {
        // 设置未删除状态
        queryForm.setDeletedFlag(false);
        
        Page<Shop> page = (Page<Shop>) SmartPageUtil.convert2PageQuery(queryForm);
        
        LambdaQueryWrapper<Shop> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Shop::getIsDeleted, false);
        
        // 查询条件
        if (StringUtils.hasText(queryForm.getName())) {
            queryWrapper.like(Shop::getName, queryForm.getName());
        }
        if (queryForm.getOwnerId() != null) {
            queryWrapper.eq(Shop::getOwnerId, queryForm.getOwnerId());
        }
        if (queryForm.getStatus() != null) {
            queryWrapper.eq(Shop::getStatus, queryForm.getStatus());
        }
        
        // 按创建时间倒序
        queryWrapper.orderByDesc(Shop::getCreateTime);
        
        Page<Shop> shopPage = shopMapper.selectPage(page, queryWrapper);
        return ResponseDTO.ok(SmartPageUtil.convert2PageResult(shopPage, shopPage.getRecords()));
    }
}

