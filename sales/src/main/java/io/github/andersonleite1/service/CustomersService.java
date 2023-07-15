package io.github.andersonleite1.service;

import io.github.andersonleite1.model.Customer;
import io.github.andersonleite1.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {
// another way to inject
//    @Autowired
    private CustomersRepository repository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        repository = customersRepository;
    }

// another way to inject
//    @Autowired
    public void setRepository(CustomersRepository repository) {
        this.repository = repository;
    }

    public void saveCustomer(Customer customer) {
        validateCustomer(customer);
        repository.save(customer);
    }

    public void validateCustomer(Customer customer) {
//      apply validations
    }
}
