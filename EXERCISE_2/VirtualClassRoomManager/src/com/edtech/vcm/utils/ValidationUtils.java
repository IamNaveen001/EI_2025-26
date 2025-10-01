package com.edtech.vcm.utils;

import com.edtech.vcm.exception.ValidationException;

public class ValidationUtils {
    public static void requireNonEmpty(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new ValidationException(fieldName + " cannot be empty");
        }
    }
}
