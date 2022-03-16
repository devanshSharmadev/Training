package com.phoneapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.phoneapp.exceptions.IdNotFoundException;
import com.phoneapp.exceptions.PhoneNotFoundException;
import com.phoneapp.model.Phone;

public class PhoneRepositoryImpl implements IPhoneRepository{


	DbManager dbmanager=new DbManager();
	
	public void addPhone(Phone phone) {
		
		MongoCollection<Phone> collection=dbmanager.findCollection();
		collection.insertOne(phone);
		
	}
	

	public void updatePhone(int phoneId, double price) {
		
		MongoCollection<Phone> collection=dbmanager.findCollection();
		Bson filter=Filters.eq("_id",phoneId);
		Bson update=Updates.set("Price",price);
		UpdateResult result=collection.updateOne(filter, update);
		System.out.println(result);
		
	}

	public void deletePhone(int phoneId) {
		
		MongoCollection<Phone> collection=dbmanager.findCollection();
		DeleteResult result=collection.deleteOne(Filters.eq("_id",phoneId));
		System.out.println(result);
		
	}

	public List<Phone> findAll() {
		
		MongoCollection<Phone> collection=dbmanager.findCollection();
		return collection.find().into(new ArrayList<Phone>());
		
	}

	public List<Phone> getByBrand(String brand) throws PhoneNotFoundException {
		
		MongoCollection<Phone> collection=dbmanager.findCollection();
		
		Document document=new Document("brand",brand);
		List<Phone> phones=collection.find(Filters.eq("brand",brand)).into(new ArrayList<Phone>());
		
		if(phones.isEmpty())
			throw new PhoneNotFoundException("brand not found");
		
		
		
		return phones;
		
	}

	public List<Phone> getByModel(String model) throws PhoneNotFoundException {
		MongoCollection<Phone> collection=dbmanager.findCollection();
		
		Document document=new Document("model",model);
		List<Phone> phones=collection.find(Filters.eq("model",model)).into(new ArrayList<Phone>());
		if(phones.isEmpty())
			throw new PhoneNotFoundException("model not found");
		
		
		
		return phones;
	}

	public Phone getById(int phoneId) throws IdNotFoundException {
		
		MongoCollection<Phone> collection=dbmanager.findCollection();
		Document document=new Document("_id",phoneId);
		Phone phone=collection.find(document).first();
		if(phone==null) {
			throw new IdNotFoundException("invalid id");
		}
		return phone;
		
		
		
	}

	public List<Phone> getByLesserPrice(double price) throws PhoneNotFoundException {
		
		List<Phone> phoneByPrice=new ArrayList<>();
		for(Phone nphone:findAll()) {
			if(nphone.getPrice()<price) {
				phoneByPrice.add(nphone);
			}
			
		}
		if(phoneByPrice.isEmpty())
			throw new PhoneNotFoundException("Phone lesser than this price not found");
		return null;
		
	}

}
