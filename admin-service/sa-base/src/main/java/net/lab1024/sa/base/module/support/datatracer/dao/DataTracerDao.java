package net.lab1024.sa.base.module.support.datatracer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.sa.base.module.support.datatracer.domain.entity.DataTracerEntity;
import net.lab1024.sa.base.module.support.datatracer.domain.form.DataTracerQueryForm;
import net.lab1024.sa.base.module.support.datatracer.domain.vo.DataTracerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * dao： t_data_tracker
 *
 */
@Mapper
public interface DataTracerDao extends BaseMapper<DataTracerEntity> {

    /**
     * 操作记录查询
     *
     */
    List<DataTracerVO> selectRecord(@Param("dataId") Long dataId, @Param("dataType") Integer dataType);

    /**
     * 分页查询
     *
     */
    List<DataTracerVO> query(Page page, @Param("query") DataTracerQueryForm queryForm);
}
