package com.cg.paytm.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import com.cg.paytm.bean.Customer;
import com.cg.paytm.bean.Trans;
import com.cg.paytm.db.Database;
import com.cg.paytm.exception.PaytmException;

public class PaytmDaoImpl implements IPaytmDao {

	static ArrayList<Trans> transList = new ArrayList<>();
	static Customer customer = new Customer();

	public boolean createAccount(Customer customer1) {

		return Database.addAccount(customer1);
	}

	@Override
	public boolean deposit(double amount) {
		customer.setBalance(customer.getBalance() + amount);
		Trans trans = new Trans();
		trans.setAmount(amount);
		trans.setTransType("Deposit");
		trans.setDate(LocalDate.now());
		trans.setTime(LocalTime.now());
		trans.setTo("self");
		transList.add(trans);
		return true;
	}

	@Override
	public boolean withDraw(double amount) {
		if (amount < customer.getBalance() - amount) {
			customer.setBalance(customer.getBalance() - amount);
			Trans trans = new Trans();
			trans.setAmount(amount);
			trans.setTransType("Withdraw");
			trans.setDate(LocalDate.now());
			trans.setTime(LocalTime.now());
			trans.setTo("self");
			transList.add(trans);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean fundTransfer(double amount, Long transPhnNo) throws PaytmException {
		Boolean isValid = Database.validate(transPhnNo);
		if (isValid) {
			if (amount < customer.getBalance() - amount) {
				customer.setBalance(customer.getBalance() - amount);
				Trans trans = new Trans();
				trans.setAmount(amount);
				trans.setTransType("Funds transfer");
				trans.setDate(LocalDate.now());
				trans.setTime(LocalTime.now());
				trans.setTo(transPhnNo.toString());
				transList.add(trans);
				return true;
			}
		}else {
			throw new PaytmException("invalid phn number");
		}
		return false;
	}

	@Override
	public double showBalance() {

		return customer.getBalance();
	}

	@Override
	public ArrayList<Trans> printTransactions() {

		return transList;
	}

}
