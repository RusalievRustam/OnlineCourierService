package org.example.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.validation.EmailConstraint;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should contain only letters")
    @NotBlank(message = "Can't be empty")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should contain only letters")
    @NotBlank(message = "Can't be empty")
    private String lastName;

    @NotBlank(message = "Can't be empty")
    private String address;

    @Valid
    @EmailConstraint(message = "Email address will be valid")
    private String email;

}
