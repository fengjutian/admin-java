package net.lab1024.sa.base.module.support.shop.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.module.support.shop.entity.Product;
import net.lab1024.sa.base.module.support.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /** 新增商品 */
    @PostMapping
    public ResponseDTO<?> addProduct(@RequestBody Product product) {
        productService.save(product);
        return ResponseDTO.ok();
    }

    /** 修改商品 */
    @PutMapping
    public ResponseDTO<?> updateProduct(@RequestBody Product product) {
        productService.updateById(product);
        return ResponseDTO.ok();
    }

    /** 删除商品（逻辑删除） */
    @DeleteMapping("/{id}")
    public ResponseDTO<?> deleteProduct(@PathVariable Long id) {
        productService.removeById(id);
        return ResponseDTO.ok();
    }

    /** 查询详情 */
    @GetMapping("/{id}")
    public ResponseDTO<?> getProduct(@PathVariable Long id) {
        return ResponseDTO.ok();
    }

    /** 分页查询 */
    @GetMapping("/page")
    public ResponseDTO<?> page(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Product> page = productService.page(new Page<>(pageNum, pageSize));
        return ResponseDTO.ok();
    }

    /** 查询某个店铺下的商品（最常用） */
    @GetMapping("/shop/{shopId}")
    public ResponseDTO<?> findByShop(@PathVariable Long shopId,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Product> page = productService.lambdaQuery()
                .eq(Product::getShopId, shopId)
                .page(new Page<>(pageNum, pageSize));
        return ResponseDTO.ok();
    }
}

