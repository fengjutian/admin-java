package net.lab1024.sa.base.module.support.dict.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.lab1024.sa.base.module.support.dict.domain.entity.DictDataEntity;
import net.lab1024.sa.base.module.support.dict.domain.vo.DictDataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * 字典数据表 Dao
 *
 */

@Mapper
@Component
public interface DictDataDao extends BaseMapper<DictDataEntity> {

    List<DictDataVO> queryByDictId(@Param("dictId") Long dictId);

    List<DictDataVO> selectByDictDataIds(@Param("dictDataIdList") Collection<Long> dictDataIds);

    DictDataEntity selectByDictIdAndValue(@Param("dictId") Long dictId, @Param("dataValue") String dataValue);

    List<DictDataVO> getAll();
}
