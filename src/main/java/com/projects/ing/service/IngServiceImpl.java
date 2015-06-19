package com.projects.ing.service;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.projects.ing.domain.User;


@Component
public class IngServiceImpl implements IngService{

	public String fetchMe() {
		
		String output=null;

		  try {
	 
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(
				"http://ingcommonapi-test.apigee.net/commonapi/v0/NL/server/status?apikey=KmYRKpiqjSrSt7kCDEbl9JGH1cGSAqg4");
			getRequest.addHeader("accept", "application/json");
			
			
			String headerName = "Authorization";    
			String headerValue = "Bearer "+"eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzUwMjYsIm5vbmNlIjoiMzVhODA0YjctMTczZS00YjYxLWJiMDEtMGVjOTU5NmRhMTY2IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNjEwMSIsImp0aSI6IjNkOGU2OTJhLWQzN2QtNGUyMS05YzU4LTg0MjVmODhkZDgzYSIsImlhdCI6MTQxNTgxMjI3OX0.cFGcJv0IG2zy1v5ABa4-CWkQc3Ot_LAzTcwjR-TOA40";
			getRequest.addHeader(headerName, headerValue);
			
	 
			HttpResponse response = httpClient.execute(getRequest);
			
	 
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
	 
			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));
	 
			
			   Gson gson = new Gson();  
			   User user = gson.fromJson(br, User.class);  
			
			/*System.out.println("Output from Server .... \n");
			output = br.readLine();*/
			/*while ((output = br.readLine()) != null) {
				System.out.println(output);
			}*/
	 
			httpClient.getConnectionManager().shutdown();
	 
		  } catch (ClientProtocolException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
		  }
	 
		return output;
		
		
		/*RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String headerName = "Authorization";    
		String headerValue = "Bearer "+"eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzUwMjYsIm5vbmNlIjoiMzVhODA0YjctMTczZS00YjYxLWJiMDEtMGVjOTU5NmRhMTY2IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNjEwMSIsImp0aSI6IjNkOGU2OTJhLWQzN2QtNGUyMS05YzU4LTg0MjVmODhkZDgzYSIsImlhdCI6MTQxNTgxMjI3OX0.cFGcJv0IG2zy1v5ABa4-CWkQc3Ot_LAzTcwjR-TOA40";
		headers.add(headerName, headerValue);
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String url = "http://ingcommonapi-test.apigee.net/commonapi/v0/NL/server/status?apikey=KmYRKpiqjSrSt7kCDEbl9JGH1cGSAqg4";
		
		
		ResponseEntity<User> result = restTemplate.exchange(url, HttpMethod.GET, entity, User.class);
		return null;*/
	}

	
}
