package net.lab1024.sa.base.module.support.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.lab1024.sa.base.common.domain.PageResult;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.module.support.shop.domain.ShopQueryForm;
import net.lab1024.sa.base.module.support.shop.entity.Shop;
import net.lab1024.sa.base.module.support.shop.service.ShopService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Shop Controller
 */
@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
@Tag(name = "店铺管理", description = "店铺相关接口")
public class ShopController {

    private final ShopService shopService;

    @Operation(summary = "新增店铺")
    @PostMapping("/add")
    public ResponseDTO<String> add(@RequestBody @Validated Shop shop) {
        return shopService.add(shop);
    }

    @Operation(summary = "修改店铺")
    @PostMapping("/update")
    public ResponseDTO<String> update(@RequestBody @Validated Shop shop) {
        if (shop.getId() == null) {
            return ResponseDTO.userErrorParam("ID不能为空");
        }
        return shopService.update(shop);
    }

    @Operation(summary = "删除店铺")
    @GetMapping("/delete/{id}")
    public ResponseDTO<String> delete(@PathVariable Long id) {
        if (id == null) {
            return ResponseDTO.userErrorParam("ID不能为空");
        }
        return shopService.delete(id);
    }

    @Operation(summary = "查询店铺详情")
    @GetMapping("/detail/{id}")
    public ResponseDTO<Shop> getDetail(@PathVariable Long id) {
        if (id == null) {
            return ResponseDTO.userErrorParam("ID不能为空");
        }
        return shopService.getDetail(id);
    }

    @Operation(summary = "分页查询店铺")
    @PostMapping("/queryPage")
    public ResponseDTO<PageResult<Shop>> queryPage(@RequestBody @Validated ShopQueryForm queryForm) {
        return shopService.queryPage(queryForm);
    }
}
