package com.cg.paytm.service;

import java.util.ArrayList;

import com.cg.paytm.bean.Customer;
import com.cg.paytm.bean.Trans;
import com.cg.paytm.dao.IPaytmDao;
import com.cg.paytm.dao.PaytmDaoImpl;
import com.cg.paytm.exception.PaytmException;

public class PaytmServiceImpl implements IPaytmService {

	IPaytmDao dao = new PaytmDaoImpl();

	@Override
	public boolean createAccount(Customer customer) throws PaytmException {
		validate(customer);
		return dao.createAccount(customer);
	}

	@Override
	public boolean deposit(double amount) {

		return dao.deposit(amount);
	}

	@Override
	public boolean withDraw(double amount) {

		return dao.withDraw(amount);
	}

	@Override
	public boolean fundTransfer(double amount, Long transPhnNo) throws PaytmException {

		return dao.fundTransfer(amount, transPhnNo);
	}

	@Override
	public double showBalance() {

		return dao.showBalance();
	}

	@Override
	public ArrayList<Trans> printTransactions() {

		return dao.printTransactions();
	}
	
	public void validate(Customer customer) throws PaytmException {
		
		if(!(customer.getFirstName().matches("[A-Za-z]{3,15}"))) {
			throw new PaytmException("First name should have atleast 3 characters");
		}
		if(!(customer.getLastName().matches("[A-Za-z]{3,15}"))) {
			throw new PaytmException("Last name should have atleast 3 characters");
		}
		if(!(customer.getMail().matches("[a-z0-9]*[@][a-z]{4,10}[.][c][o][m]"))) {
			throw new PaytmException("Enter valid mail");
		}
		if(!(customer.getPhnNo().toString().matches("[6-9][0-9]{9}"))) {
			throw new PaytmException("phone number should have 10 digits");
		}
		if(!(customer.getAdharNo().toString().matches("[0-9]{12}"))) {
			throw new PaytmException("Adhar number should have 12 digits");
		}
		
	}

	@Override
	public boolean validatePin(int pin) {
		// TODO Auto-generated method stub
		return dao.validatePin(pin);
	}

}
