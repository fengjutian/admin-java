package net.lab1024.sa.base.common.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Long类型序列化
 *
 */
public class LongJsonSerializer extends JsonSerializer<Long> {

    public static final LongJsonSerializer INSTANCE = new LongJsonSerializer();

    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        if (null == value) {
            gen.writeNull();
            return;
        }
        // js中最大安全整数16位 Number.MAX_SAFE_INTEGER
        String longStr = String.valueOf(value);
        if (longStr.length() > 16) {
            gen.writeString(longStr);
        } else {
            gen.writeNumber(value);
        }
    }
}