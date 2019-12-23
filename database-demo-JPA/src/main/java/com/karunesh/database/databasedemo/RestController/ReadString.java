package com.karunesh.database.databasedemo.RestController;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ReadString {
	
	@PostMapping("validate")
	public ResponseEntity<OutputResponse> readString(@RequestBody InputData data) throws ParseException {
		OutputResponse response = new OutputResponse();
		response = validateJson(data);
		return new ResponseEntity<OutputResponse>(response, HttpStatus.OK);
		
	}

	private OutputResponse validateJson(InputData data) throws ParseException {
		Object obj = new JSONParser().parse(data.getRequest()); 
        JSONObject jo = (JSONObject) obj;
        System.out.println(jo);
		return null;
	}

}
