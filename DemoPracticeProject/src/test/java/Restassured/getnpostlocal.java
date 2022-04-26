package Restassured;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getnpostlocal {
	
	@DataProvider(name="dataforpost")
	
	public Object [][] datapost(){
		
		return new Object [][] {
			{"Vinay","gupta","2"},{"bhanu","samat","1"}
			
			
		};
	}
	@Test(dataProvider="dataforpost")
	
	public void testpost(String F_name,String L_name,String subID) {
		baseURI="http://localhost:3000";
		JSONObject rwt=new JSONObject();
		rwt.put("F_name", F_name);
		rwt.put("L_name",L_name);
		rwt.put("SubID", subID);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rwt.toJSONString())
		.when().post("/users")
		.then().statusCode(201).log().all();
		
	}
	
	@Test
	
	public void getmethod() {
		
		baseURI="http://localhost:3000";
		given().when().get("/users").then().statusCode(200).log().all();
	}
	

}
