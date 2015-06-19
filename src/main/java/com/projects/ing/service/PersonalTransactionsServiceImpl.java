package com.projects.ing.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.projects.ing.domain.Transactions;

@Component
public class PersonalTransactionsServiceImpl implements PersonalTransactionsService{
	
	public Transactions fetchTransactions(long id) {
		
		String token = null;
		if(id == 16101){
			token = "eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMzUwMjYsIm5vbmNlIjoiMzVhODA0YjctMTczZS00YjYxLWJiMDEtMGVjOTU5NmRhMTY2IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNjEwMSIsImp0aSI6IjNkOGU2OTJhLWQzN2QtNGUyMS05YzU4LTg0MjVmODhkZDgzYSIsImlhdCI6MTQxNTgxMjI3OX0.cFGcJv0IG2zy1v5ABa4-CWkQc3Ot_LAzTcwjR-TOA40";
		}else if(id == 16102){
			token = "eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwNjQ5MDIsIm5vbmNlIjoiYjc4MzgxNjgtY2Q1OC00YzkzLWFkZjQtNTllNzY3OWQ2YTQ5IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNjEwMiIsImp0aSI6IjljY2IzMjU5LTczZWEtNDEwNS1iNzMxLTVlNGRhZDIxODBjYyIsImlhdCI6MTQxNTg0MjE1NX0.Jaajg5jbpEzEBdw6JBWRW-rKEJxM8ua4Z5mk4SaUjpw";
		}else if(id == 16103){
			token = "eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwNjUwNDIsIm5vbmNlIjoiYmJkZThhNmUtZDE4OS00NjNjLWI5MWMtNTc5MjE0YWMzOTA2IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNjEwMyIsImp0aSI6IjcwYWJlZWQ2LTU5ZGItNDI0Mi04Yjg1LTQwYWQzZDg0OWExMyIsImlhdCI6MTQxNTg0MjI5NX0.-Lin30ZSf0Tj-RAm46l5zrFxzHjp40HAqxdz7SoOhvE";
		}else if(id == 16104){
			token = "eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwNjUwOTMsIm5vbmNlIjoiMDc0MDdlY2QtZmRiNy00ZTIyLWJmNTItMWVlN2E1MTQwZDRlIiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNjEwNCIsImp0aSI6IjI4N2M1NTUzLTk2OGYtNGU0Yy1hZDk3LTZkMGFlZGUwODdkNSIsImlhdCI6MTQxNTg0MjM0Nn0.WimHNvmIkgSoRhtTpHHpGukAvTpxe0K0FK113nuGTFo";
		}else if(id == 16105){
			token = "eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwODMyMjEsIm5vbmNlIjoiOWY1MWI5MWMtNTdlOC00NDkwLWI1MzMtNWQ1ODIzMDY4YjljIiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNjEwNSIsImp0aSI6IjM5Y2JjMjkzLWE5NzctNDQ4MS1iY2M4LWU4ODEzMGEyOTVhYiIsImlhdCI6MTQxNTg2MDQ3NH0.zR2TTiE2s0bRhwTd_GGvLcJTEOB6xOiObeVVPSRdZm0";
		}
		
		Transactions transactions = null;
		  try {
	 
			DefaultHttpClient httpClient = new DefaultHttpClient();
			//String url = "http://ingcommonapi-test.apigee.net/commonapi/v0/NL/server/status?apikey=KmYRKpiqjSrSt7kCDEbl9JGH1cGSAqg4";
			//String url = "http://ingcommonapi-test.apigee.net/commonapi/v0/nl/me?apikey=KmYRKpiqjSrSt7kCDEbl9JGH1cGSAqg4";
			String url = "http://ingcommonapi-test.apigee.net/commonapi/v0/NL/persons/"+id+"/transactions?apikey=KmYRKpiqjSrSt7kCDEbl9JGH1cGSAqg4";
			HttpGet getRequest = new HttpGet(url);
			getRequest.addHeader("accept", "application/json");
			
			String headerName = "Authorization";    
			String headerValue = "Bearer "+token;
			getRequest.addHeader(headerName, headerValue);
			
	 
			HttpResponse response = httpClient.execute(getRequest);
	 
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
	 
			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));
	 
			/*String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}*/
			Gson gson = new Gson();  
			  
			transactions = gson.fromJson(br, Transactions.class);  
			//Transaction tx = transactions.getList().get(0);
		    
		    //System.out.println(tx.getProductId());
	 
			httpClient.getConnectionManager().shutdown();
	 
		  } catch (ClientProtocolException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
		  }
		  return transactions;
	 
		
	}

}
