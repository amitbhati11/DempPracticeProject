package Restassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class Getnpost {
	
	@DataProvider(name="testpostdata")
	public Object [][] datapost() {
		
		return new  Object   [][] {
			
			{"Ankit","Arct"},{"Sourav","Tech"},{"Raquesh","Test13"}
			
		};
		
		
	}
	
	@Test(dataProvider="testpostdata")
	
	public void postmethod(String name,String job) {
		baseURI="https://reqres.in";
		JSONObject req=new JSONObject();
		req.put("name", name);
		req.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(req.toJSONString()).when()
		.post("/api/users").then()
		.statusCode(201).log().all();
		
	}
	
	@Test
	
	public void getmethod() {
		
		baseURI="https://reqres.in";
		
		given().
		when()
		.get("/api/users?page=2").
		then().
		statusCode(200)
		.log()
		.all();
		
		
		
		
	}

}
