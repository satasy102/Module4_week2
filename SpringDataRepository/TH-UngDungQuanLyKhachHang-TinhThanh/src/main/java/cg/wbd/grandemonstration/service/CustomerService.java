package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
