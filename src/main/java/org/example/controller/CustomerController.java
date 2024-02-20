package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.CustomerDTO;
import org.example.repositories.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/clients")
    public List<CustomerDTO> listAll() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/client")
    public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return customerDTO;
    }

    @DeleteMapping("/client")
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @PutMapping("/client/id={id}")
    public CustomerDTO updateCustomerInfo(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerDTO, id);
    }
}
