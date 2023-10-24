package com.ukrainians.validation;

import com.ukrainians.validation.impl.NickNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = NickNameValidator.class)
public @interface NickNameValid {

    String message() default "Username must contain at least 3 characters, without spaces";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
