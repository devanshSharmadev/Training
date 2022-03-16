package com.phoneapp.repository;

import java.util.List;

import com.phoneapp.exceptions.IdNotFoundException;
import com.phoneapp.exceptions.PhoneNotFoundException;
import com.phoneapp.model.Phone;

public interface IPhoneRepository {

	void addPhone(Phone phone);
	void updatePhone(int phoneId,double price);
	void deletePhone(int phoneId);
	
	List<Phone> findAll();
	List<Phone> getByBrand(String brand) throws PhoneNotFoundException;
	List<Phone> getByModel(String model) throws PhoneNotFoundException;
	Phone getById(int phoneId) throws IdNotFoundException;
	List<Phone> getByLesserPrice(double price) throws PhoneNotFoundException;
	
}
