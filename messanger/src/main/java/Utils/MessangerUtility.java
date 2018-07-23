package Utils;

import java.util.Date;

import org.atulyadav.restful.messenger.Message;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Filters;

public class MessangerUtility {
	
	public static String messageIdGenerator(Message message) {
		String id = null;
		long timestamp = new Date().getTime();
		switch(message.getMessageType().name()) {
			case "POST" : 
				id = message.getMessageType().name() + "_" + timestamp;
				break;
		}
		return id;
	}
	
	
	public static Bson createFilter(String filter) {
		return Filters.eq(filter);
	}
	

}
