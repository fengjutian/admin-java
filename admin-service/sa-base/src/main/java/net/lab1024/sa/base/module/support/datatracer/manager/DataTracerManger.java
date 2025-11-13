package net.lab1024.sa.base.module.support.datatracer.manager;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.lab1024.sa.base.module.support.datatracer.dao.DataTracerDao;
import net.lab1024.sa.base.module.support.datatracer.domain.entity.DataTracerEntity;
import org.springframework.stereotype.Service;

/**
 * manager层
 *
 */
@Service
public class DataTracerManger extends ServiceImpl<DataTracerDao, DataTracerEntity> {
}
