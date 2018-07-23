package org.atulyadav.restful.messenger.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mongoConnection.ConnectionMongo;

@Path("/mongo")
public class MongoResource {
	
	MongoClient mongoInstance = ConnectionMongo.getMongoConnection();
	
	
	@GET
	@Path("/getDatabases")
	@Produces(MediaType.TEXT_PLAIN)
	public String ServerStatus() {
		return ConnectionMongo.getAllDatabaseNames();
	}
	
	@GET
	@Path("/createDatabase/{databaseName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createDatabase(@PathParam(value="databaseName") String databaseName) {
		MongoDatabase database = ConnectionMongo.getDatabase(databaseName);
		if(database!=null) {
			return database.getName();
		}
		else {
			throw new RuntimeException("failed to create database of name "+databaseName);
		}
	}
	
	@GET
	@Path("/createCollection/{databaseName}/{collectionName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createDatabase(@PathParam(value="collectionName") String collectionName, @PathParam(value="databaseName") String databaseName) {
		 MongoCollection<?> collection = ConnectionMongo.getCollection(databaseName, collectionName);
		if(collection!=null) {
			return collection.getNamespace().getCollectionName();
		}
		else {
			throw new RuntimeException("failed to create collection of name "+collection + " in "+databaseName);
		}
	}
	
	@DELETE
	@Path("/db/{databaseName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDatabase(@PathParam(value="databaseName") String databaseName) {
		try {
			ConnectionMongo.deleteDatabase(databaseName);
			return "database deleted.";
		}
		catch(RuntimeException ex ) {
			ex.printStackTrace();;
			return "something went wrong ";
		}
	}
	
	@DELETE
	@Path("/coll/{databaseName}/{collectionName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCollection(@PathParam(value="databaseName") String databaseName,@PathParam(value="collectionName") String collectionName) {
		try {
			ConnectionMongo.deleteCollection(databaseName, collectionName);
			return "collection deleted.";
		}
		catch(RuntimeException ex ) {
			ex.printStackTrace();;
			return "something went wrong ";
		}
	}
	
	
}
