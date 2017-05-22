package com.example.electricitybill;

public class Contact {
	int id, previous_unit, current_unit, total_unit;
	String name, phone_number;

	public Contact() {

	}

	public Contact(int id, String name, String phone_number) {
		this.id = id;
		this.name = name;
		this.phone_number = phone_number;
	}

	public Contact(String name, String phone_number) {
		this.name = name;
		this.phone_number = phone_number;
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_Number() {
		return this.phone_number;
	}

	public void setPhone_Number(String phone_number) {
		this.phone_number = phone_number;
	}
	

}
