package com.ukrainians.validation;

import com.ukrainians.validation.impl.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordValid {

    String message() default "Password must contain 8 characters! Uppercase letters, lowercase letters, numbers, special characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
