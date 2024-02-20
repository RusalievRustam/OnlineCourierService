package org.example.validation;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class EmailValidator implements Validator {
    private final CustomerService customerService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customer = (CustomerDTO) target;


        if (customerService.getCustomerByEmail(customer.getEmail()).isPresent()) {
            errors.rejectValue("email", "duplicate", "This email already exists");

        }
    }

}

