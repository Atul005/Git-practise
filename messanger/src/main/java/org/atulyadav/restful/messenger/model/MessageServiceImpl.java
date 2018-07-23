package org.atulyadav.restful.messenger.model;

import java.util.ArrayList;
import java.util.List;

import org.atulyadav.restful.messenger.Message;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import Utils.MessangerUtility;
import mongoConnection.ConnectionMongo;

public class MessageServiceImpl implements MessageService {

	MongoClient mongoInstance = ConnectionMongo.getMongoConnection();
	
	@SuppressWarnings("unchecked")
	@Override
	public String createMessage(Message message) {
		message.setMessageId(MessangerUtility.messageIdGenerator(message));
		MongoCollection<Document> coll = (MongoCollection<Document>) ConnectionMongo.getCollection("Messenger", "messageCollection");
		System.out.print(new Gson().toJson(message).toString());
		coll.insertOne(Document.parse(new Gson().toJson(message).toString()));
		System.out.println("Message is saved in mongo!!!");
		return message.getMessageId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Message getMessage(Bson filter) {
		MongoCollection<Message> coll = (MongoCollection<Message>) ConnectionMongo.getCollection("Messenger", "messageCollection");
		System.out.println(coll.getNamespace());
		FindIterable<Message> findIterable = coll.find(filter);
		return findIterable.first();
	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getAllMessages() {
		List<Message> messages = new ArrayList<Message>();
		MongoCollection<Message> coll = (MongoCollection<Message>) ConnectionMongo.getCollection("Messenger", "messageCollection");
		FindIterable<Message>  findIterable = coll.find();
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




//	@SuppressWarnings("unlikely-arg-type")
//	@Override
//	public boolean deleteMessage(String messageToDelete) {
//		createMessageStore();
//		boolean isDeleted = false;
//		Iterator<Message> iterator = messageStore.iterator();
//		while(iterator.hasNext()) {
//			String idToMatch = iterator.next().getMessageId(); 
//			if(idToMatch.equals(messageToDelete)) {
//				messageStore.remove(messageStore.indexOf(messageToDelete));
//				isDeleted = true;
//				return isDeleted;
//			}
//		}	
//		return isDeleted;
//	}


	@Override
	public boolean deleteMessage(String messageId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateMessage(String messageId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String updateMessage(String messageId) {
//		return null;
//	}
//	
//	
//	void createMessageStore(){
//		for(int i=1;i<6;i++) {
//			Message message = new Message("Message_"+ ++messId,"This is the " +messId+" message",MessageTypeEnum.POST,new Date(),new Profile("User_"+messId,"Profile_"+messId,ProfileType.USER),new Profile("User_"+messId,"Profile_"+messId,ProfileType.USER));
//			messageStore.add(message);
//		}
//	}
	
}
