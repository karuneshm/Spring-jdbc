package com.karunesh.database.databasedemo.RestController;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OutputResponse {
	
	public List<FileValidResponse> reponse;
	
	public OutputResponse() {
		
	}

	public List<FileValidResponse> getReponse() {
		return reponse;
	}

	public void setReponse(List<FileValidResponse> reponse) {
		this.reponse = reponse;
	}
	
	
	
	

}
