package com.cg.paytm.db;

import java.util.ArrayList;
import java.util.List;

import com.cg.paytm.bean.Customer;

public class Database {

	static List<Customer> customerDetails = new ArrayList<>();

	static List<Long> customers = new ArrayList<>();
	static {
		customers.add(9290872465l);
		customers.add(9247144559l);
		customers.add(9248444559l);
		customers.add(9297307567l);
		customers.add(9966472238l);
	}

	public static boolean addAccount(Customer customer) {

		return customerDetails.add(customer);
	}

	public static boolean validate(Long transphnno) {
		boolean isValid = false;
		for (Long phnno : customers)
			if (phnno.equals(transphnno))
				isValid = true;

		return isValid;

	}

	public static boolean validatePin(int pin) {
		boolean isValid = false;
		for (Customer customer : customerDetails)
			if (pin == customer.getPin())
				isValid = true;

		return isValid;

	}

}
