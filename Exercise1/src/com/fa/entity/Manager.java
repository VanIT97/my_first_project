package com.fa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Manager implements Serializable{
	private String account;
	private String name;
	private String gender;
	private List<Computer> listComputer=new ArrayList<>();
	
	
	
	@Override
	public String toString() {
		return "Manager [account=" + account + ", name=" + name + ", gender=" + gender + ", listComputer="
				+ listComputer + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Computer> getListComputer() {
		return listComputer;
	}
	public void setListComputer(List<Computer> listComputer) {
		this.listComputer = listComputer;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		return true;
	}
	
	
}
