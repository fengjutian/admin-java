package net.lab1024.sa.admin.module.system.support;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import net.lab1024.sa.base.common.controller.SupportBaseController;
import net.lab1024.sa.base.common.domain.PageResult;
import net.lab1024.sa.base.common.domain.ResponseDTO;
import net.lab1024.sa.base.constant.SwaggerTagConst;
import net.lab1024.sa.base.module.support.helpdoc.domain.form.HelpDocAddForm;
import net.lab1024.sa.base.module.support.helpdoc.domain.form.HelpDocCatalogAddForm;
import net.lab1024.sa.base.module.support.helpdoc.domain.form.HelpDocCatalogUpdateForm;
import net.lab1024.sa.base.module.support.helpdoc.domain.form.HelpDocQueryForm;
import net.lab1024.sa.base.module.support.helpdoc.domain.form.HelpDocUpdateForm;
import net.lab1024.sa.base.module.support.helpdoc.domain.vo.HelpDocDetailVO;
import net.lab1024.sa.base.module.support.helpdoc.domain.vo.HelpDocVO;
import net.lab1024.sa.base.module.support.helpdoc.service.HelpDocCatalogService;
import net.lab1024.sa.base.module.support.helpdoc.service.HelpDocService;
import net.lab1024.sa.base.module.support.repeatsubmit.annoation.RepeatSubmit;

/**
 * 帮助文档
 *
 */
@Tag(name = SwaggerTagConst.Support.HELP_DOC)
@RestController
public class AdminHelpDocController extends SupportBaseController {

    @Resource
    private HelpDocService helpDocService;

    @Resource
    private HelpDocCatalogService helpDocCatalogService;

    // --------------------- 帮助文档 【目录管理】 -------------------------


    @Operation(summary = "帮助文档目录-添加' ")
    @PostMapping("/helpDoc/helpDocCatalog/add")
    public ResponseDTO<String> addHelpDocCatalog(@RequestBody @Valid HelpDocCatalogAddForm helpDocCatalogAddForm) {
        return helpDocCatalogService.add(helpDocCatalogAddForm);
    }

    @Operation(summary = "帮助文档目录-更新' ")
    @PostMapping("/helpDoc/helpDocCatalog/update")
    public ResponseDTO<String> updateHelpDocCatalog(@RequestBody @Valid HelpDocCatalogUpdateForm helpDocCatalogUpdateForm) {
        return helpDocCatalogService.update(helpDocCatalogUpdateForm);
    }

    @Operation(summary = "帮助文档目录-删除' ")
    @GetMapping("/helpDoc/helpDocCatalog/delete/{helpDocCatalogId}")
    public ResponseDTO<String> deleteHelpDocCatalog(@PathVariable Long helpDocCatalogId) {
        return helpDocCatalogService.delete(helpDocCatalogId);
    }

    // --------------------- 帮助文档 【管理:增、删、查、改】-------------------------

    @Operation(summary = "【管理】帮助文档-分页查询' ")
    @PostMapping("/helpDoc/query")
    @SaCheckPermission("support:helpDoc:query")
    public ResponseDTO<PageResult<HelpDocVO>> query(@RequestBody @Valid HelpDocQueryForm queryForm) {
        return ResponseDTO.ok(helpDocService.query(queryForm));
    }

    @Operation(summary = "【管理】帮助文档-获取详情' ")
    @GetMapping("/helpDoc/getDetail/{helpDocId}")
    @SaCheckPermission("support:helpDoc:add")
    public ResponseDTO<HelpDocDetailVO> getDetail(@PathVariable Long helpDocId) {
        return ResponseDTO.ok(helpDocService.getDetail(helpDocId));
    }

    @Operation(summary = "【管理】帮助文档-添加' ")
    @PostMapping("/helpDoc/add")
    @RepeatSubmit
    public ResponseDTO<String> add(@RequestBody @Valid HelpDocAddForm addForm) {
        return helpDocService.add(addForm);
    }

    @Operation(summary = "【管理】帮助文档-更新' ")
    @PostMapping("/helpDoc/update")
    @RepeatSubmit
    public ResponseDTO<String> update(@RequestBody @Valid HelpDocUpdateForm updateForm) {
        return helpDocService.update(updateForm);
    }

    @Operation(summary = "【管理】帮助文档-删除' ")
    @GetMapping("/helpDoc/delete/{helpDocId}")
    public ResponseDTO<String> delete(@PathVariable Long helpDocId) {
        return helpDocService.delete(helpDocId);
    }

    @Operation(summary = "【管理】帮助文档-根据关联id查询' ")
    @GetMapping("/helpDoc/queryHelpDocByRelationId/{relationId}")
    public ResponseDTO<List<HelpDocVO>> queryHelpDocByRelationId(@PathVariable Long relationId) {
        return ResponseDTO.ok(helpDocService.queryHelpDocByRelationId(relationId));
    }

}