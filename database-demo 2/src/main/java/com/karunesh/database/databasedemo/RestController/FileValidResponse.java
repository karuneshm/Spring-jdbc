package com.karunesh.database.databasedemo.RestController;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileValidResponse {
	
	public String fileName ;
	public String valid;
	
	public FileValidResponse() {
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
	
	

}
