package com.fa.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Computer implements Serializable{
	private int id;
	private String caseCdn;
	private String screen;
	private String location;
	private String note;
	
	
	public Computer() {
		super();
	}
	public Computer(int id, String caseCdn, String screen, String location, String note) {
		super();
		this.id = id;
		this.caseCdn = caseCdn;
		this.screen = screen;
		this.location = location;
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaseCdn() {
		return caseCdn;
	}
	public void setCaseCdn(String caseCdn) {
		this.caseCdn = caseCdn;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", caseCdn=" + caseCdn + ", screen=" + screen + ", location=" + location
				+ ", note=" + note + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Computer other = (Computer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
