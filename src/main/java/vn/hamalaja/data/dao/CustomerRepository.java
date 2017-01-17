package vn.hamalaja.data.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import vn.hamalaja.data.om.Customer;

/**
 * 
 * @author lamhm
 * @see <a
 *      href="http://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/jdbc.html">Tham
 *      khảo các cách tiếp cận khác jdbc khác</a>
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	public Customer findByFirstName(String firstName);


	public List<Customer> findByLastName(String lastName);
}
