package com.fa.entity;

public class HourlyEmployee extends Employee{
	private double wage;
	private double workingHours;

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	
	@Override
	public String toString() {
		return "HourlyEmployee ["+super.toString()+",wage=" + wage + ", workingHours=" + workingHours + "]";
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
