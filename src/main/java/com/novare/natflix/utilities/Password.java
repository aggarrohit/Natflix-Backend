package com.novare.natflix.utilities;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "Password must contain at least one lower case alphabet,  one upper case alphabet, one special character and one numeric!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

