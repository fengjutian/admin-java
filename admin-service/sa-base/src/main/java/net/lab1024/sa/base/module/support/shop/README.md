# 店铺管理模块 (Shop Module)

## 模块概述

店铺管理模块是一个完整的CRUD业务模块，提供了店铺的增删改查、分页查询等功能，并集成了数据追踪、参数校验、状态管理等企业级特性。

## 文件结构

```
net.lab1024.sa.base.module.support.shop/
├── constant/
│   └── ShopStatusEnum.java              # 店铺状态枚举
├── controller/
│   └── ShopController.java              # 店铺控制器
├── domain/
│   └── ShopQueryForm.java               # 店铺查询表单
├── entity/
│   └── Shop.java                         # 店铺实体类
├── mapper/
│   └── ShopMapper.java                   # 店铺数据访问层
└── service/
    ├── ShopService.java                  # 店铺服务接口
    └── impl/
        └── ShopServiceImpl.java          # 店铺服务实现类
```

## 核心功能

### 1. 店铺管理 (ShopController)

| 接口 | 方法 | 路径 | 描述 |
|------|------|------|------|
| POST | add | /shop/add | 新增店铺 |
| PUT | update | /shop/update | 更新店铺 |
| DELETE | delete | /shop/delete | 删除店铺 |
| GET | getDetail | /shop/detail | 获取店铺详情 |
| POST | queryPage | /shop/queryPage | 分页查询店铺 |

### 2. 数据模型

#### Shop 实体类
- **基础字段**: id, name, logoUrl, description, ownerId
- **状态字段**: status (启用/禁用)
- **审计字段**: createTime, updateTime, isDeleted
- **验证注解**: @Length, @NotNull, @SchemaEnum, @CheckEnum

#### ShopQueryForm 查询表单
- **继承**: PageParam (提供分页参数)
- **查询字段**: name, ownerId, status, deletedFlag
- **验证注解**: @Length, @SchemaEnum, @CheckEnum

#### ShopStatusEnum 状态枚举
- **ENABLE(1, "启用")**: 店铺正常营业状态
- **DISABLE(0, "禁用")**: 店铺暂停营业状态

### 3. 业务特性

#### 参数校验
- 实体类字段级别的验证注解
- Controller层 @Validated 参数校验
- Service层业务逻辑校验

#### 状态管理
- 使用枚举类型管理店铺状态
- 支持状态枚举验证
- 默认新增店铺为启用状态

#### 数据追踪
- 集成 DataTracerService 记录数据变更
- 支持新增、更新、删除操作的追踪
- 使用专用的 SHOP 追踪类型

#### 逻辑删除
- 使用 isDeleted 字段实现软删除
- 查询时自动过滤已删除数据
- 支持数据恢复

#### 分页查询
- 支持多条件组合查询
- 按创建时间倒序排列
- 返回 PageResult 标准分页结果

## 技术栈

- **框架**: Spring Boot + MyBatis Plus
- **验证**: Hibernate Validator + 自定义验证注解
- **文档**: Swagger/OpenAPI 3
- **追踪**: 自定义 DataTracer 数据追踪系统
- **工具**: SmartPageUtil, StringUtils 等

## 使用示例

### 1. 新增店铺
```json
POST /shop/add
{
  "name": "测试店铺",
  "logoUrl": "https://example.com/logo.png",
  "description": "这是一个测试店铺",
  "ownerId": 1,
  "status": 1
}
```

### 2. 分页查询
```json
POST /shop/queryPage
{
  "pageNum": 1,
  "pageSize": 10,
  "name": "测试",
  "status": 1
}
```

### 3. 更新店铺
```json
PUT /shop/update
{
  "id": 1,
  "name": "更新后的店铺名称",
  "description": "更新后的描述"
}
```

## 扩展性

### 1. 可扩展字段
- 联系方式 (phone, email)
- 营业时间 (businessHours)
- 地址信息 (address, province, city)
- 营业执照 (businessLicense)

### 2. 可扩展功能
- 店铺分类管理
- 店铺评分系统
- 店铺统计分析
- 店铺权限管理

### 3. 可扩展接口
- 店铺审核流程
- 店铺批量操作
- 店铺导入导出
- 店铺数据统计

## 最佳实践

1. **参数校验**: 使用多层校验确保数据完整性
2. **异常处理**: 统一的异常处理和错误返回
3. **数据追踪**: 记录关键业务操作的数据变更
4. **状态管理**: 使用枚举管理业务状态
5. **文档规范**: 完善的API文档和注释

## 注意事项

1. 所有接口都需要进行权限验证
2. 删除操作为逻辑删除，数据仍保留在数据库中
3. 店铺名称在同一时间内不能重复
4. 数据追踪功能需要配置相应的数据库表
5. 分页查询建议设置合理的默认页大小