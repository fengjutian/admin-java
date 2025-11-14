package net.lab1024.sa.admin.module.system.role.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import net.lab1024.sa.admin.constant.AdminSwaggerTagConst;
import net.lab1024.sa.admin.module.system.role.domain.form.RoleAddForm;
import net.lab1024.sa.admin.module.system.role.domain.form.RoleUpdateForm;
import net.lab1024.sa.admin.module.system.role.domain.vo.RoleVO;
import net.lab1024.sa.admin.module.system.role.service.RoleService;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色
 *
 */
@RestController
@Tag(name = AdminSwaggerTagConst.System.SYSTEM_ROLE)
public class RoleController {

    @Resource
    private RoleService roleService;

    @Operation(summary = "添加角色' ")
    @PostMapping("/role/add")
    @SaCheckPermission("system:role:add")
    public ResponseDTO<String> addRole(@Valid @RequestBody RoleAddForm roleAddForm) {
        return roleService.addRole(roleAddForm);
    }

    @Operation(summary = "删除角色' ")
    @GetMapping("/role/delete/{roleId}")
    @SaCheckPermission("system:role:delete")
    public ResponseDTO<String> deleteRole(@PathVariable Long roleId) {
        return roleService.deleteRole(roleId);
    }

    @Operation(summary = "更新角色' ")
    @PostMapping("/role/update")
    @SaCheckPermission("system:role:update")
    public ResponseDTO<String> updateRole(@Valid @RequestBody RoleUpdateForm roleUpdateDTO) {
        return roleService.updateRole(roleUpdateDTO);
    }

    @Operation(summary = "获取角色数据' ")
    @GetMapping("/role/get/{roleId}")
    public ResponseDTO<RoleVO> getRole(@PathVariable("roleId") Long roleId) {
        return roleService.getRoleById(roleId);
    }

    @Operation(summary = "获取所有角色' ")
    @GetMapping("/role/getAll")
    public ResponseDTO<List<RoleVO>> getAllRole() {
        return roleService.getAllRole();
    }

}
