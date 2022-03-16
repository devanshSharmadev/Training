package com.phoneapp.repository;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.phoneapp.model.Phone;

public class DbManager {
	
	static MongoClient mongoInstance;
	
	public static void openConnection() {
		
		String connectionString="mongodb://localhost:27017";
		ConnectionString connection=new ConnectionString(connectionString);
		
		CodecRegistry pojoCodecRegistry=fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry=fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),pojoCodecRegistry);
		MongoClientSettings clientSettings=MongoClientSettings.builder().applyConnectionString(connection).codecRegistry(codecRegistry).build();
		mongoInstance=MongoClients.create(clientSettings);
		
	}
	
	public static void closeConnection() {
		mongoInstance.close();
	}
	
	public MongoDatabase findDatabase() {
		MongoDatabase database=mongoInstance.getDatabase("klouddb");
		return database;
	}
	
	public MongoCollection<Phone> findCollection(){
		MongoDatabase database=findDatabase();
		MongoCollection<Phone> collection=database.getCollection("phone",Phone.class);
		return collection;
	}

}
