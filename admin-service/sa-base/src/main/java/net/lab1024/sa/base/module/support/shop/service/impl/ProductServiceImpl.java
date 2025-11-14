package net.lab1024.sa.base.module.support.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.lab1024.sa.base.module.support.shop.entity.Product;
import net.lab1024.sa.base.module.support.shop.mapper.ProductMapper;
import net.lab1024.sa.base.module.support.shop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
