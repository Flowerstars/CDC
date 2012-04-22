package com.discount.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Produces("application/xml")
@Path("customers")
public class CustomersResource {

	private TreeMap<Integer, Customer> customerMap = new TreeMap<Integer, Customer>();
	
	public CustomersResource() {
		// hardcode a single customer into the database for demonstration
		// purposes
		System.out.println("[songhan]: AAAAAAAAAAAAAAAa");
		Customer customer = new Customer();
		customer.setName("Harold Abernathy");
		customer.setAddress("Sheffield, UK");
	    addCustomer(customer);
	    System.out.println("[songhan]: " + customerMap.toString());
	  }
	
	@GET
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
	    customers.addAll(customerMap.values());
	    return customers;
	}

	@GET
	@Path("{id}")
	public Customer getCustomer(@PathParam("id") int cId) {
		System.out.println("[songhan]: PPPPPPPPPPPPPP");
		System.out.println("[songhan]: cId = " + cId);
		return customerMap.get(cId);
	}

	@POST
	@Path("add")
	@Produces("text/html")
	@Consumes("application/xml")
	public String addCustomer(Customer customer) {
		System.out.println("[songhan]: added customer = " + customer.toString());
		int id = customerMap.size();
	    customer.setId(id);
	    customerMap.put(id, customer);
	    return "Customer " + customer.getName() + " added with Id " + id;
	}
}