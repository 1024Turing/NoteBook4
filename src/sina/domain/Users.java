package sina.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Set<Message> messagesForGetter = new HashSet(0);
	private Set<Message> messagesForSender = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Users(String username, String password, Set messagesForGetter,
			Set messagesForSender) {
		this.username = username;
		this.password = password;
		this.messagesForGetter = messagesForGetter;
		this.messagesForSender = messagesForSender;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getMessagesForGetter() {
		return this.messagesForGetter;
	}

	public void setMessagesForGetter(Set messagesForGetter) {
		this.messagesForGetter = messagesForGetter;
	}

	public Set getMessagesForSender() {
		return this.messagesForSender;
	}

	public void setMessagesForSender(Set messagesForSender) {
		this.messagesForSender = messagesForSender;
	}

}