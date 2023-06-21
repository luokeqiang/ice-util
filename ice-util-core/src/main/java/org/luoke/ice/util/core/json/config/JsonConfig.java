package org.luoke.ice.util.core.json.config;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import org.luoke.ice.util.core.json.ByteJsonAnnotationIntrospector;

/**
 * @author luoke 2023/6/21 15:34
 */
@Configuration
public class JsonConfig {
    @Bean
    @Primary
    ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder.createXmlMapper(false).build();
        // 添加自定义的 NopAnnotationIntrospector 用于匹配自定义的序列化器
        AnnotationIntrospector sis = mapper.getSerializationConfig().getAnnotationIntrospector();
        AnnotationIntrospector is1 = AnnotationIntrospectorPair.pair(sis, new ByteJsonAnnotationIntrospector());
        mapper.setAnnotationIntrospector(is1);
        return mapper;
    }
}
