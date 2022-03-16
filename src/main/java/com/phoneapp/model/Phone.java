package com.phoneapp.model;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Phone {
	
	private String brand;
	@BsonProperty(value="_id")
	private Integer phoneId;
	private String model;
	private double price;
	private Integer memory;
	
	
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Phone(String brand, Integer phoneId, String model, double price, Integer memory) {
		super();
		this.brand = brand;
		this.phoneId = phoneId;
		this.model = model;
		this.price = price;
		this.memory = memory;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Integer getPhoneId() {
		return phoneId;
	}


	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Integer getMemory() {
		return memory;
	}


	public void setMemory(Integer memory) {
		this.memory = memory;
	}


	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", phoneId=" + phoneId + ", model=" + model + ", price=" + price + ", memory="
				+ memory + "]";
	}
	
	
	
	
	
	

}
