package org.atulyadav.restful.messenger.model;

import java.util.List;

import org.atulyadav.restful.messenger.Message;
import org.bson.conversions.Bson;

public interface MessageService {

	String createMessage(Message message);
	Message getMessage(Bson filter);
	List<Message> getAllMessages();
	boolean deleteMessage(String messageId);
	String updateMessage(String messageId);
	
}
