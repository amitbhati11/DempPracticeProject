package Restassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class putpatchndeletelocal {
	@DataProvider(name="dataput")
	
	public Object [][] dataforput(){
		
		return new Object [][] {
			{"Deep","tiwari","1"},{"pankaj","saxena","2"}	
			
		};
	}
	@Test(dataProvider="dataput")
	
	public void testputmethod(String F_name,String L_name,String subid) {
		baseURI="http://localhost:3000";
		JSONObject rt=new JSONObject();
		rt.put("F_name", F_name);
		rt.put("L_name",L_name);
		rt.put("SubID", subid);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(rt.toJSONString()).when()
		.put("/users").then().statusCode(200).log().all();
	}
	
@DataProvider(name="datapatch")
	
	public Object [][] dataforpatch(){
		
		return new Object [][] {
			{"Dd","tiwa","2"}
			
		};
	}
	@Test(dataProvider="datapatch")
	
	public void testpatchmethod(String F_name,String L_name,String subid) {
		baseURI="http://localhost:3000";
		JSONObject rt=new JSONObject();
		rt.put("F_name", F_name);
		rt.put("L_name",L_name);
		rt.put("SubID", subid);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(rt.toJSONString()).when()
		.patch("/users").then().statusCode(200).log().all();
	}
	
	@Test
	public void deletemethod() {
		baseURI="http://localhost:3000";
		given().when().delete("/users/28").then().statusCode(204).log().all();
		
		
	}

}
