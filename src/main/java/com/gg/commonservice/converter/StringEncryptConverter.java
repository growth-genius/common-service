package com.gg.commonservice.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.StringEncryptor;

@Converter
@RequiredArgsConstructor
public class StringEncryptConverter implements AttributeConverter<String, String> {

    private final StringEncryptor jasyptStringEncryptor;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return Optional.ofNullable(attribute).filter(s -> !s.isEmpty()).map(this.jasyptStringEncryptor::encrypt).orElse("");
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).filter(s -> !s.isEmpty()).map(this.jasyptStringEncryptor::decrypt).orElse("");
    }

}
