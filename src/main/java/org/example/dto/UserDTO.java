package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Can't be empty")
    private String userName;

    @NotBlank(message = "Can't be empty")
    private String password;

    @NotBlank(message = "Can't be empty")
    private String role;
}
