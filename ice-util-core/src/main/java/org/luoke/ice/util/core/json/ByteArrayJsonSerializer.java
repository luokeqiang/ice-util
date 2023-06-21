package org.luoke.ice.util.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.luoke.ice.util.core.JsonUtil;

import java.io.IOException;

/**
 * <p>jackson 字节数组序列化器，将字节数组序列化为 {@link Object} 对象.</p>
 * @author luoke 2023/6/21 13:41
 * @see ByteJsonAnnotationIntrospector
 */
public class ByteArrayJsonSerializer extends StdSerializer<byte[]> {
    protected ByteArrayJsonSerializer() {
        super(byte[].class);
    }

    @Override
    public void serialize(byte[] value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(JsonUtil.parseBytes(value, Object.class));
    }
}
