package org.luoke.ice.util.core.json;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;

import java.util.Optional;

/**
 * {@link  ByteArrayJsonSerializer}序列化器查找器
 * @author luoke 2023/6/21 13:46
 */
public class ByteJsonAnnotationIntrospector extends NopAnnotationIntrospector {
    @Override
    public Object findSerializer(Annotated am) {
        final Optional<ByteJson> annotation = Optional.ofNullable(am.getAnnotation(ByteJson.class));
        return annotation.isPresent() ? ByteArrayJsonSerializer.class : null;
    }
}
