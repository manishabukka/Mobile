package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {

	Map<String, Account> accountEntry;

	public AccountDaoImpl() {
		accountEntry = new HashMap<>();
		accountEntry.put("7337065675", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9874563210", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9875641230", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9632587410", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9852136470", new Account("Prepaid", "Tushar", 632));

	}

	Account account = null;

	@Override
	public Account getAccountDetails(String mobileNo) {
		int count = 0;
		for (Map.Entry m : accountEntry.entrySet()) {

			if (mobileNo.equals(m.getKey())) {
				account = (Account) m.getValue();
				count++;
				break;

			}
		}
		if (count == 0)
			return null;
		else
			return account;
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		int count = 0,bal=0;
		for (Map.Entry m : accountEntry.entrySet()) {

			if (mobileNo.equals(m.getKey())) {
				account = (Account) m.getValue();
				 bal=(int) (rechargeAmount+account.getAccountBalance());
				account.setAccountBalance(bal);
				count++;
				break;

			}
		}
		if (count == 0)
			return 0;
		else
			return bal;
		
	}

}
