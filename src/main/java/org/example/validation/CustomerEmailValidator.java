package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerEmailValidator implements ConstraintValidator<EmailConstraint, String> {
    @Override
    public void initialize(EmailConstraint emailConstraint) {
    }

    @Override
    public boolean isValid(String emailField, ConstraintValidatorContext cxt) {
        return emailField != null && emailField.matches("^(.+)@(\\S+)$");
    }
}

