package com.example.demo.converter;

import com.example.demo.enums.UserType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserType userType) {
        return userType != null ? userType.getCode() : null;
    }

    @Override
    public UserType convertToEntityAttribute(Integer code) {
        return code != null ? UserType.fromCode(code) : null;
    }
}