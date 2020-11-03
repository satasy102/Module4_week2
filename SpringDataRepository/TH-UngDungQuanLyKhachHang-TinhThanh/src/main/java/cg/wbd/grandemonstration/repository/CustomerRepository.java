package cg.wbd.grandemonstration.repository;

import cg.wbd.grandemonstration.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
