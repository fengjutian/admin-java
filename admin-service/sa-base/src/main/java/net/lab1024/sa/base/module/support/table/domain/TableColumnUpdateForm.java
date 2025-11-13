package net.lab1024.sa.base.module.support.table.domain;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 自定义表格列
 *
 */
@Data
public class TableColumnUpdateForm {

    @NotNull(message = "表id不能为空")
    private Integer tableId;

    @NotEmpty(message = "请上传列")
    private List<TableColumnItemForm> columnList;

}
