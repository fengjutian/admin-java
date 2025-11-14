package net.lab1024.sa.base.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import net.lab1024.sa.base.common.json.serializer.LongJsonSerializer;

/**
 * json 序列化配置
 *
 */
@Configuration
public class JsonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            builder.deserializers(new LocalDateDeserializer(DatePattern.NORM_DATE_FORMAT.getDateTimeFormatter()));
            builder.deserializers(new LocalDateTimeDeserializer(DatePattern.NORM_DATETIME_FORMAT.getDateTimeFormatter()));
            builder.serializers(new LocalDateSerializer(DatePattern.NORM_DATE_FORMAT.getDateTimeFormatter()));
            builder.serializers(new LocalDateTimeSerializer(DatePattern.NORM_DATETIME_FORMAT.getDateTimeFormatter()));
            builder.serializerByType(Long.class, LongJsonSerializer.INSTANCE);
        };
    }


    /**
     * string 转为 LocalDateTime 配置类
     *
     *' 
     */
    @Configuration
    public static class StringToLocalDateTime implements Converter<String, LocalDateTime> {

        @Override
        public LocalDateTime convert(String str) {
            if (StringUtils.isBlank(str)) {
                return null;
            }
            LocalDateTime localDateTime;
            try {
                localDateTime = LocalDateTimeUtil.parse(str, DatePattern.NORM_DATETIME_FORMAT.getDateTimeFormatter());
            } catch (DateTimeParseException e) {
                throw new RuntimeException("请输入正确的日期格式：yyyy-MM-dd HH:mm:ss");
            }
            return localDateTime;
        }
    }


    /**
     * string 转为 LocalDate 配置类
     *
     *' 
     */
    @Configuration
    public static class StringToLocalDate implements Converter<String, LocalDate> {

        @Override
        public LocalDate convert(String str) {
            if (StringUtils.isBlank(str)) {
                return null;
            }
            LocalDate localDate;
            try {
                localDate = LocalDateTimeUtil.parseDate(str, DatePattern.NORM_DATE_FORMAT.getDateTimeFormatter());
            } catch (DateTimeParseException e) {
                throw new RuntimeException("请输入正确的日期格式：yyyy-MM-dd");
            }
            return localDate;
        }
    }
}