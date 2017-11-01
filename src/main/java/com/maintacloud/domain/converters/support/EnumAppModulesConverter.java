package com.maintacloud.domain.converters.support;


import com.maintacloud.domain.enumeration.support.EnumAppModules;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by issam on 16/11/2016.
 */
@Converter(autoApply = true)
public class EnumAppModulesConverter implements AttributeConverter<EnumAppModules, String> {

    @Override
    public String convertToDatabaseColumn(EnumAppModules attribute) {
        if (attribute == null)
            return null;
        else
            return attribute.getValue();
    }

    @Override
    public EnumAppModules convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;
        else
            return EnumAppModules.valueOf(dbData);
    }
}
