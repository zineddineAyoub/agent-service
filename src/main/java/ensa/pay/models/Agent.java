package ensa.pay.models;


import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection ="Agent")
public class Agent {
	
	@Id
	private String id;
	
	private String first_name;
	
	private String last_name;
	
	private String identity_document;
	
	private String birth_day;
	
	private String phone_number;
	
	private String patente_number;
	
	private String identity_number;
	
	private String address;
	
	private String email;
	
	private String commerce_registration;
	
	private String password;

	private String id_agence;
	
	//private Binary image;
	@Transient
	private List<Files> files ;

	@Transient
	private Agency agency;


	/*
	public Agent() {
		
	}

	
	public List<Files> getFiles() {
		return files;
	}


	public void setFiles(List<Files> files) {
		this.files = files;
	}


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getIdentity_document() {
		return identity_document;
	}

	public void setIdentity_document(String identity_document) {
		this.identity_document = identity_document;
	}

	public Date getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(Date birth_day) {
		this.birth_day = birth_day;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public long getPatente_number() {
		return patente_number;
	}

	public void setPatente_number(long patente_number) {
		this.patente_number = patente_number;
	}

	public int getIdentity_number() {
		return identity_number;
	}

	public void setIdentity_number(int identity_number) {
		this.identity_number = identity_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCommerce_registration() {
		return commerce_registration;
	}

	public void setCommerce_registration(long commerce_registration) {
		this.commerce_registration = commerce_registration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Agent [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", identity_document="
				+ identity_document + ", birth_day=" + birth_day + ", phone_number=" + phone_number
				+ ", patente_number=" + patente_number + ", identity_number=" + identity_number + ", address=" + address
				+ ", email=" + email + ", commerce_registration=" + commerce_registration + ", password=" + password
				+ ", files=" + files + "]";
	}
	
	*/
	
	
}
