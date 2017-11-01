package com.maintacloud.config.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by issam on 05/12/2016.
 */
public class CustomJsonDateSerializer extends StdSerializer<Date> {
//    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    public CustomJsonDateSerializer() {
        this(null);
    }

    public CustomJsonDateSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2)  throws IOException {
        gen.writeNumber(value.getTime());
    }
}
