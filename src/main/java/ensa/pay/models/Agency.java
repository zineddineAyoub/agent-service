package ensa.pay.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection ="Agency")
public class Agency {
	
	@Id
	private String id;

	//@NotNull(message = "Agency name must not be null")
	private String name;

	//@NotNull(message = "Agency address must not be null")
	private String address;

	/*
	public Agence() { }

	public Agence(String name_agence, String address) {
		super();
		this.name_agence = name_agence;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName_agence() {
		return name_agence;
	}

	public void setName_agence(String name_agence) {
		this.name_agence = name_agence;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Agence [id=" + id + ", name_agence=" + name_agence + ", address=" + address + "]";
	}
	*/
}
