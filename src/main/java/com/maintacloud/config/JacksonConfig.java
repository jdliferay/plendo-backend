package com.maintacloud.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.maintacloud.config.jackson.CustomJsonDateSerializer;
import com.maintacloud.config.jackson.LocalDateDeserializer;
import com.maintacloud.config.jackson.LocalDateSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by issam on 25/11/2016.
 */
@Configuration
public class JacksonConfig {

//    @Inject
//    private JacksonProperties jacksonProperties;
//
//    @Bean
//    @Primary
//    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, jacksonProperties.getSerialization().get(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS));
//        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, jacksonProperties.getSerialization().get(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS));
//        return objectMapper;
//    }

//    @Bean
//    @Primary
//    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
////        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
//        return objectMapper;
//    }

    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        final SimpleModule dateModule = new SimpleModule();
//        dateModule.addDeserializer(Date.class, new CustomJsonDateDeserializer());
        dateModule.addSerializer(Date.class, new CustomJsonDateSerializer());
        objectMapper.registerModule(dateModule);


        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }
}
