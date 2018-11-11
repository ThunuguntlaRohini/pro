package com.cg.paytm.dao;

import java.util.ArrayList;

import com.cg.paytm.bean.Customer;
import com.cg.paytm.bean.Trans;
import com.cg.paytm.exception.PaytmException;

public interface IPaytmDao {

	boolean createAccount(Customer customer);

	boolean deposit(double amount);

	boolean withDraw(double amount);

	double showBalance();

	ArrayList<Trans> printTransactions();

	boolean fundTransfer(double amount, Long transPhnNo) throws PaytmException;

	boolean validatePin(int pin);

}
