package com.maintacloud.config.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * Created by issam on 05/12/2016.
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    public static final DateTimeFormatter FORMATTER = ofPattern("dd/MM/yyyy");


    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.format(FORMATTER));
    }


}
