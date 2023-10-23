package com.ukrainians.validation.impl;

import com.ukrainians.validation.NickNameValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NickNameValidator implements ConstraintValidator<NickNameValid, String> {

    public static final Pattern VALID_NICKNAME_REGEX =
            Pattern.compile("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", Pattern.CASE_INSENSITIVE);


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher matcher = VALID_NICKNAME_REGEX.matcher(value);
        return matcher.matches();
    }
}
