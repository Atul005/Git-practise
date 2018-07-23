package org.atulyadav.restful.messenger;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.atulyadav.restful.messenger.Profile.Profile;
import org.atulyadav.restful.messenger.model.MessageTypeEnum;


@XmlRootElement
public class Message {
	private String messageId;
	private String messageContent;
	private MessageTypeEnum messageTypeEnum;
	private Date messageTimestamp;
	private Profile messageFrom;
	private Profile messageTo;
	
	public Message() {
		
	}

	
	@XmlElement
	public Profile getMessageFrom() {
		return messageFrom;
	}

	public void setMessageFrom(Profile messageFrom) {
		this.messageFrom = messageFrom;
	}
	
	@XmlElement
	public Profile getMessageTo() {
		return messageTo;
	}

	public void setMessageTo(Profile messageTo) {
		this.messageTo = messageTo;
	}

	public Message(String messageId, String messageContent, MessageTypeEnum messageTypeEnum, Date messageTimestamp,
			Profile messageFrom, Profile messageTo) {
		super();
		this.messageId = messageId;
		this.messageContent = messageContent;
		this.messageTypeEnum = messageTypeEnum;
		this.messageTimestamp = messageTimestamp;
		this.messageFrom = messageFrom;
		this.messageTo = messageTo;
	}


	@XmlAttribute
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@XmlElement
	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@XmlElement
	public Date getMessageTimestamp() {
		return messageTimestamp;
	}

	public void setMessageTimestamp(Date messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	@XmlElement
	public MessageTypeEnum getMessageType() {
		return messageTypeEnum;
	}

	public void setMessageType(MessageTypeEnum messageTypeEnum) {
		this.messageTypeEnum = messageTypeEnum;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageContent=" + messageContent + ", messageTypeEnum="
				+ messageTypeEnum + ", messageTimestamp=" + messageTimestamp + ", messageFrom=" + messageFrom
				+ ", messageTo=" + messageTo + "]";
	}

}
