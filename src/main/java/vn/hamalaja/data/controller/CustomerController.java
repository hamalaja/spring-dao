package vn.hamalaja.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hamalaja.data.dao.CustomerRepository;
import vn.hamalaja.data.om.Customer;

/**
 * @author lamhm
 *
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository repository;


	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public @ResponseBody int count() {
		return 1;
	}


	@RequestMapping(value = "/gen", method = RequestMethod.GET)
	public void generateUser() {
		repository.save(new Customer("Lâm", "Hà"));
		repository.save(new Customer("Long", "Hà"));
	}


	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAll() {
		return repository.findAll();
	}


	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public @ResponseBody Customer findUser(@RequestParam(name = "first_name") String firstName) {
		return repository.findByFirstName(firstName);
	}

}
