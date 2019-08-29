package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT u from User u ORDER BY u.email"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT u from User u where u.email=:uEmail")
})
public class User {

	@Id
	private String id;

	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email;
	private String password;
	private String city;
	private String state;
    private String Zip;	
	
	

	public User(){
    	id = UUID.randomUUID().toString();
    }
    
    
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return Zip;
	}


	public void setZip(String zip) {
		Zip = zip;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", city=" + city + ", state=" + state + ", Zip=" + Zip + "]";
	}


    
}
