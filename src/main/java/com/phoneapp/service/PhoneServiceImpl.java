package com.phoneapp.service;

import java.util.Collections;
import java.util.List;

import com.phoneapp.exceptions.IdNotFoundException;
import com.phoneapp.exceptions.PhoneNotFoundException;
import com.phoneapp.model.Phone;
import com.phoneapp.repository.IPhoneRepository;
import com.phoneapp.repository.PhoneRepositoryImpl;

public class PhoneServiceImpl implements IPhoneService {
	
	IPhoneRepository phoneRepository=new PhoneRepositoryImpl();

	public void addPhone(Phone phone) {
		
		phoneRepository.addPhone(phone);
		
	}

	public void updatePhone(int phoneId, double price) {
		
		phoneRepository.updatePhone(phoneId, price);
		
	}

	public void deletePhone(int phoneId) {
		
		phoneRepository.deletePhone(phoneId);
		
	}

	public List<Phone> findAll() {
		
		return phoneRepository.findAll();
		
	}

	public List<Phone> getByBrand(String brand) throws PhoneNotFoundException {
		
		List<Phone> phoneByBrand=phoneRepository.getByBrand(brand);
		if(phoneByBrand!=null)
			Collections.sort(phoneByBrand,(p1,p2)->p1.getBrand().compareTo(p2.getBrand()));
		return phoneByBrand;
		
	
		
	}

	public List<Phone> getByModel(String model) throws PhoneNotFoundException {
		
		List<Phone> phoneModel=phoneRepository.getByModel(model);
		if(phoneModel!=null)
			Collections.sort(phoneModel,(p1,p2)->p1.getBrand().compareTo(p2.getBrand()));
		return phoneModel;
	}

	public Phone getById(int phoneId) throws IdNotFoundException {
		
		return phoneRepository.getById(phoneId);
	}

	public List<Phone> getByLesserPrice(double price) throws PhoneNotFoundException {
		
		List<Phone> phonelesserPrice=phoneRepository.getByLesserPrice(price);
		if(phonelesserPrice!=null)
			Collections.sort(phonelesserPrice,(p1,p2)->p1.getBrand().compareTo(p2.getBrand()));
		return phonelesserPrice;
	}

}
