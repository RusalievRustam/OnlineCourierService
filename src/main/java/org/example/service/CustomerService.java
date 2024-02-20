package org.example.service;

import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    public Customer convertToCustomer(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }

    public CustomerDTO convertToCustomerDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setAddress(customer.getAddress());
        customer.setEmail(customer.getEmail());
        customerRepository.save(customer);
        return convertToCustomerDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> listCustomers = customerRepository.findAll();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        listCustomers.forEach(c -> customersDTO.add(convertToCustomerDTO(c)));
        return customersDTO;
    }


    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = convertToCustomer(customerDTO);
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.getCustomersByEmail(email);
    }
}
