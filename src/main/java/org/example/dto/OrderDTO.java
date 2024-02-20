package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Order;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @NotBlank(message = "Can't be empty")
    private String item;

    private int customerId;

    @NotBlank(message = "Can't be empty")
    private String status;

    @DateTimeFormat
    private Date orderDate;

    private Date deliverDate;
}
