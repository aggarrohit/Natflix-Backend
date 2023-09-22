package com.novare.natflix.utilities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password constraintAnnotation) {
        // No initialization needed.
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return true; // Null passwords are handled by @NotNull or other annotations.
        }

        // check for password must contain
        return password.matches(".*[a-z].*") // At least one lower case character
                && password.matches(".*[!@#$%^&*()_+={}.<>?].*") // At least one special character
                && password.matches(".*[A-Z].*"); // At least one upper case character
    }
}

