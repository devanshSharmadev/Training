package com.phoneapp.main;



import java.util.List;
import com.phoneapp.exceptions.IdNotFoundException;
import com.phoneapp.exceptions.PhoneNotFoundException;
import com.phoneapp.model.Phone;
import com.phoneapp.repository.DbManager;
import com.phoneapp.repository.PhoneRepositoryImpl;
import com.phoneapp.service.IPhoneService;
import com.phoneapp.service.PhoneServiceImpl;

public class Client {
	
	public static void main(String[] args) {
		
		DbManager.openConnection();
		
		//Adding a New Phone
		
		IPhoneService phoneService=new PhoneServiceImpl();
		//Phone phone=new Phone("Apple",1,"iphone13",1000,128);
		//phoneService.addPhone(phone);
		
		// Printing All Phones
		
		System.out.println("All phones");
		List<Phone> allPhones=phoneService.findAll();
		for(Phone ophone:allPhones) {
			System.out.println("Phone -->"+ophone);
		}
		
		System.out.println();
		
		// Printing Phone by Brand
		
		System.out.println("Phone by Brand");
		
		try {
			List<Phone> phoneByBrandList=phoneService.getByBrand("Apple");
			for(Phone ophone:phoneByBrandList) {
				System.out.println("Phone -->"+ophone);
			}
			
		} catch (PhoneNotFoundException e) {
			System.out.println(e.getMessage());		
			
		}
		
		// Phone By Model
		
		System.out.println();
		System.out.println("Phone by model");
		
		try {
			List<Phone> phoneByModelList=phoneService.getByModel("iphone13");
			for(Phone ophone:phoneByModelList) {
				System.out.println("Phone -->"+ophone);
			}
			
		} catch (PhoneNotFoundException e) {
			System.out.println(e.getMessage());		
			
		}
		
		// Phone By ID
		
		System.out.println("Phone By Id");
		try {
			Phone nphone=phoneService.getById(1);
			System.out.println("Phone -->"+nphone);
		}catch(IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		DbManager.closeConnection();
	}

}
