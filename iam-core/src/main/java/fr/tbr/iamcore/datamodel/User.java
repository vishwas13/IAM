/**
 * 
 */
package fr.tbr.iamcore.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tbrou
 *
 */
@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue
	long id;
	
	private String login;
	private String password;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		this.login = username;
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the login
	 */
	public final String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public final void setLogin(String login) {
		this.login = login;
	}

}
