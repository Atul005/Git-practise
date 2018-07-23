package mongoConnection;

import java.util.Map;
import java.util.Map.Entry;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class ConnectionMongo {

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<?> collection;

	public static MongoClient getMongoClient()  {
		if(mongoClient == null) {
			synchronized(ConnectionMongo.class) {
				if(mongoClient == null) {
					mongoClient = new MongoClient("localhost",27017);
					return mongoClient;
				}
			}
		}	
		return mongoClient;
	}
	
	public static MongoClient getMongoConnection() {
		MongoClient client = ConnectionMongo.getMongoClient();
		if(client != null) {
			System.out.println("Server is connected to " + client.getAddress());
			System.out.println("YOU'RE GOOD TO GO!!! :)");
			return client;
		}
		else {
			throw new RuntimeException("Server not up.");
		}
	}

	
	public static MongoDatabase getDatabase(String databaseName) {
		 database = getMongoClient().getDatabase(databaseName);
		 if(database != null) {
			 return database;
		 }
		 else {
			 throw new RuntimeException("Database with given name not found.");
		 }
	}
	
	public static MongoCollection<?> getCollection(String database, String collectionName) {
		collection = getDatabase(database).getCollection(collectionName);
		return collection;
	}
	
	public static ListCollectionsIterable<?> getAllCollections(String databaseName){
		return getDatabase(databaseName).listCollections();
	}
	
	public static String getAllDatabaseNames() {
		MongoIterable<String> iterable = ConnectionMongo.getMongoClient().listDatabaseNames();
		MongoCursor<String> mongoCursor = iterable.iterator();
		String databaseList = "";
		while(mongoCursor.hasNext()) {
			databaseList = databaseList + mongoCursor.next() +"\n";
		}
		return databaseList;
	}
	
	
	public static ListDatabasesIterable<?> getAllDatabases(){
		ListDatabasesIterable<Document> iterableList = ConnectionMongo.getMongoClient().listDatabases();
		MongoCursor<Document> mongoIterable = iterableList.iterator();
		String listDatabases = "";
		while(mongoIterable.hasNext()) {
			Map<?,?> docMap= mongoIterable.next();
			for(Entry<?, ?> entry : docMap.entrySet()) {
				listDatabases = listDatabases + "DB name -> "+ entry.getValue() + "\n";
			}
		}
		return iterableList;
	}
	
	public static void deleteDatabase(String databaseName) {
		database = ConnectionMongo.getDatabase(databaseName);
		if(database != null) {
			mongoClient.dropDatabase(databaseName);
		}
		else {
			throw new MongoException("No database found to delete");
		}
	}
	
	public static void deleteCollection(String databaseName, String collectionName){
		database = ConnectionMongo.getDatabase(databaseName);
		if(database != null) {
			database.getCollection(collectionName).drop();
		}
		else {
			throw new MongoException("No database/collection found to delete");
		}
	}
	
	public static void closeMongoClient() {
		getMongoClient().close();
	}

}
