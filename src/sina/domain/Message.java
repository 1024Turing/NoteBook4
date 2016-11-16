package sina.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users usersByGetter;
	private Users usersBySender;
	private Date mestime;
	private String content;
	private String getter;
	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Users usersByGetter, Users usersBySender) {
		this.usersByGetter = usersByGetter;
		this.usersBySender = usersBySender;
	}

	/** full constructor */
	public Message(Users usersByGetter, Users usersBySender, Date mestime,
			String content) {
		this.usersByGetter = usersByGetter;
		this.usersBySender = usersBySender;
		this.mestime = mestime;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsersByGetter() {
		return this.usersByGetter;
	}

	public void setUsersByGetter(Users usersByGetter) {
		this.usersByGetter = usersByGetter;
	}

	public Users getUsersBySender() {
		return this.usersBySender;
	}

	public void setUsersBySender(Users usersBySender) {
		this.usersBySender = usersBySender;
	}

	public Date getMestime() {
		return this.mestime;
	}

	public void setMestime(Date mestime) {
		this.mestime = mestime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	

}