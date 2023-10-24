package com.ukrainians.validation.impl;

import com.ukrainians.validation.PasswordValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordValid, String> {

    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*])(?=\\S+$).{8,}", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(value);
        return matcher.matches();
    }
}
