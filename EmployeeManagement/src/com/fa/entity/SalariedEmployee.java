package com.fa.entity;

public class SalariedEmployee extends Employee{
	private double commisionRate;
	private double grossSale;
	private double basicSalary;
	
	
	public double getCommisionRate() {
		return commisionRate;
	}
	public void setCommisionRate(double commisionRate) {
		this.commisionRate = commisionRate;
	}
	public double getGrossSale() {
		return grossSale;
	}
	public void setGrossSale(double grossSale) {
		this.grossSale = grossSale;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	@Override
	public String toString() {
		return "SalariedEmployee ["+super.toString()+",commisionRate=" + commisionRate + ", grossSale=" + grossSale + ", basicSalary="
				+ basicSalary + "]";
	}
	@Override
	public double getPaymentAmount() {
		return 0;
	}
	@Override
	public void display() {
			System.out.println(this.toString());
	}
	
	
}
