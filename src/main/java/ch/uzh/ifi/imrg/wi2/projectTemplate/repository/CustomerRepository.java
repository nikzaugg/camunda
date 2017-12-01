package ch.uzh.ifi.imrg.wi2.projectTemplate.repository;
import ch.uzh.ifi.imrg.wi2.projectTemplate.persistence.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String>{
}
