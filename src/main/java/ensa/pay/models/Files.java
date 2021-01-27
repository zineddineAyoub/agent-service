package ensa.pay.models;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;


@Document(collection="files")
public class Files {
	@Id
	private String id;
	
	private String description;
	
	private Binary file;
	
	private String id_agent;
	

	public Files() {
		
	}

	public Files(String description, Binary file) {
		super();
		this.description = description;
		this.file = file;
	}
	
	

	public String getId_agent() {
		return id_agent;
	}

	public void setId_agent(String id_agent) {
		this.id_agent = id_agent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Binary getFile() {
		return file;
	}

	public void setFile(MultipartFile file) throws IOException {
		
		this.file = new Binary(BsonBinarySubType.BINARY, file.getBytes());
	}

	@Override
	public String toString() {
		return "Files [id=" + id + ", description=" + description + ", file=" + file + ", id_agent=" + id_agent + "]";
	}
	

	
}
