package net.lab1024.sa.base.module.support.datatracer.annoation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DataTracerFieldSql {

    /**
     * 关联字段名称
     * @return
     */
    String relateColumn() default "id";

    /**
     * 关联显示的字段
     * @return
     */
    String relateDisplayColumn() default "";
    /**
     * 是否关联字段查询Mapper
     * @return
     */
    Class<? extends BaseMapper> relateMapper() default BaseMapper.class;

}
