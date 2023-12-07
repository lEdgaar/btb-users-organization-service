package com.btb.usersorganizationservice.common.validation.annotations;

import com.btb.usersorganizationservice.common.validation.validators.NotNullOrEmptyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullOrEmptyValidator.class)
public @interface NotNullOrEmpty {

    String message() default "Value cannot be null or empty.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
