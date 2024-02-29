package com.cbh.ojbackendcommon.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Spring MVC Json 配置
 *
 * @author 小皮卡
 * @from cbh
 */
@JsonComponent
public class JsonConfig {

    /**
     * 添加 Long 转 json 精度丢失的配置
     */
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 创建一个简单的 Jackson 模块，用于配置序列化和反序列化的规则
        SimpleModule module = new SimpleModule();
        // 将 Long 类型的字段在序列化时转换为字符串形式。这是为了解决长整型在 JavaScript 中的精度问题，通过将其转为字符串，可以保留长整型的精度
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        // 将上述创建的模块注册到 Jackson 对象映射器中，以应用配置的规则
        objectMapper.registerModule(module);
        return objectMapper;
    }
}