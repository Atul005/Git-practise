package org.atulyadav.restful.messenger.Profile;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private String userName;
	private String profileId;
	private ProfileType profileType;
	
	
	public Profile() {
		
	}

	public Profile(String userName, String profileId, ProfileType profileType) {
		super();
		this.userName = userName;
		this.profileId = profileId;
		this.profileType = profileType;
	}

	@XmlElement
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement
	public ProfileType getProfileType() {
		return profileType;
	}

	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}

	@XmlAttribute
	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	@Override
	public String toString() {
		return "Profile [userName=" + userName + ", profileId=" + profileId + ", profileType=" + profileType + "]";
	}
	

}
