package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();

	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}

	public static CustomerService getInstance() {
		return instance;
	}
	
	public boolean checkCustomer(Customer customer) {
		if(customers.containsKey(customer.getId())) {
			return false;
		}
		else
			return true;
	}

	public void addCustomer(Customer customer) {
		
			customers.put(customer.getId(), customer);
			
//		//customers.put(customer.getId(), customer);                                               
//		if(customers.containsKey(customer.getId())) {
//			return false;
//		}
//		else {
//			customers.put(customer.getId(), customer);
//			return true;
//		}
			
	}
	
	//loginform에서 사용자가 입력한 id에 맞는 customer 정보를 찾는 메소드
	public Customer findCustomer(String id) {
		if(id != null)
				return(customers.get(id.toLowerCase()));
		else
			return null;
	}

	//로그인 시 findCustomer()로 찾은 고객정보를 리턴한다.
	public Customer login(String id, String password) {
		if (findCustomer(id) != null && findCustomer(id).getPassword().equals(password)) {
			return findCustomer(id);
		} 
		else
			return null;
	}
}
