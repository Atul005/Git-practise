package org.atulyadav.restful.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.atulyadav.restful.messenger.Message;
import org.atulyadav.restful.messenger.model.MessageService;
import org.atulyadav.restful.messenger.model.MessageServiceImpl;
import com.mongodb.MongoClient;

import Utils.MessangerUtility;
import mongoConnection.ConnectionMongo;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageServiceImpl();
	MongoClient mongoInstance = ConnectionMongo.getMongoClient();

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam(value = "messageId") String messageId) throws Exception {
		Message message = null;
		message = messageService.getMessage(MessangerUtility.createFilter(messageId));
		if(message != null) {
			return message;
		}
		else {
			throw new RuntimeException("Message with " + messageId + " does not exist." );
		}
	}
	
	@GET
	@Path("/allMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(){
		return messageService.getAllMessages();
	}
	
	
	/*
	------------------------------------------------------------------------------------------------------------------------------------------------------------
	@GET
	@Path("/allMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public long getAllMessages(){
		return messageService.getAllMessages();
	}
	-------------------------------------------------------------------------------------------------------------------------------------------------------------
	*/
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createMessage(Message message) {
		return messageService.createMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public boolean deleteMessage(@PathParam(value = "messageId") String messageId) throws Exception {
		return messageService.deleteMessage(messageId);
	}
	
	@PUT
	@Path("/update")
	@Consumes()
	@Produces()
	public String updateMessage() {
		return messageService.updateMessage("");
	}
	
}
