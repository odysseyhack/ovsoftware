package com.ovsoftware.reti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Responsible for MongoDB configuration.
 */

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	
	@Value("${mongo.db.name}")
	private String dbName;

	@Value("${mongo.db.port}")
	private String dbPort;

	@Override
	public String getDatabaseName() {
		return dbName;
	}

	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(dbPort);
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient();
	}
}