package net.lab1024.sa.admin.module.business.goods.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import net.lab1024.sa.admin.constant.AdminSwaggerTagConst;
import net.lab1024.sa.admin.module.business.goods.domain.form.GoodsAddForm;
import net.lab1024.sa.admin.module.business.goods.domain.form.GoodsQueryForm;
import net.lab1024.sa.admin.module.business.goods.domain.form.GoodsUpdateForm;
import net.lab1024.sa.admin.module.business.goods.domain.vo.GoodsExcelVO;
import net.lab1024.sa.admin.module.business.goods.domain.vo.GoodsVO;
import net.lab1024.sa.admin.module.business.goods.service.GoodsService;
import net.lab1024.sa.base.common.domain.PageResult;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.common.domain.ValidateList;
import net.lab1024.sa.base.common.util.SmartExcelUtil;

/**
 * 商品业务
 *
 */
@RestController
@Tag(name = AdminSwaggerTagConst.Business.MANAGER_GOODS)
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Operation(summary = "分页查询")
    @PostMapping("/goods/query")
    @SaCheckPermission("goods:query")
    public ResponseDTO<PageResult<GoodsVO>> query(@RequestBody @Valid GoodsQueryForm queryForm) {
        return goodsService.query(queryForm);
    }

    @Operation(summary = "添加商品")
    @PostMapping("/goods/add")
    @SaCheckPermission("goods:add")
    public ResponseDTO<String> add(@RequestBody @Valid GoodsAddForm addForm) {
        return goodsService.add(addForm);
    }

    @Operation(summary = "更新商品")
    @PostMapping("/goods/update")
    @SaCheckPermission("goods:update")
    public ResponseDTO<String> update(@RequestBody @Valid GoodsUpdateForm updateForm) {
        return goodsService.update(updateForm);
    }

    @Operation(summary = "删除")
    @GetMapping("/goods/delete/{goodsId}")
    @SaCheckPermission("goods:delete")
    public ResponseDTO<String> delete(@PathVariable Long goodsId) {
        return goodsService.delete(goodsId);
    }

    @Operation(summary = "批量' ")
    @PostMapping("/goods/batchDelete")
    @SaCheckPermission("goods:batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody @Valid ValidateList<Long> idList) {
        return goodsService.batchDelete(idList);
    }

    // --------------- 导出和导入 -------------------

    @Operation(summary = "导入' ")
    @PostMapping("/goods/importGoods")
    @SaCheckPermission("goods:importGoods")
    public ResponseDTO<String> importGoods(@RequestParam MultipartFile file) {
        return goodsService.importGoods(file);
    }

    @Operation(summary = "导出' ")
    @GetMapping("/goods/exportGoods")
    @SaCheckPermission("goods:exportGoods")
    public void exportGoods(HttpServletResponse response) throws IOException {
        List<GoodsExcelVO> goodsList = goodsService.getAllGoods();
        SmartExcelUtil.exportExcel(response,"商品列表.xlsx","商品",GoodsExcelVO.class, goodsList);
    }

}
