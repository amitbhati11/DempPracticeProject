package Restassured;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class putpatchndelete {
	
	@DataProvider(name="putdata")
	
	public Object [][] dataforput(){
		
		return new Object [][] {
			{"Rajvir","test1234"},{"singleton","test5678"},{"lovish","test2390"}
			
		};
	}
	
	@Test(dataProvider="putdata")
	
	public void putmethod(String name,String job) {
		
		baseURI="https://reqres.in";
		JSONObject rtp=new JSONObject ();
		rtp.put("name", name);
		rtp.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rtp.toJSONString()).
		when().put("/api/users/2")
		.then().statusCode(200).log().all();
		
		
	}
	
@DataProvider(name="patchdata")
	
	public Object [][] dataforpatch(){
		
		return new Object [][] {
			{"Rajvir","1234"},{"singh","test5678"},{"lov","test2390"}
			
		};
	}
	
	@Test(dataProvider="patchdata")
	
	public void patchmethod(String name,String job) {
		
		baseURI="https://reqres.in";
		JSONObject rtp=new JSONObject ();
		rtp.put("name", name);
		rtp.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rtp.toJSONString()).
		when().patch("/api/users/2")
		.then().statusCode(200).log().all();
		
		
	}
	
	@Test
	
	public void deletemethod() {
		
		baseURI="https://reqres.in";
		
		given().when()
		.delete("/api/users/2")
		.then()
		.statusCode(204).log().all();
	}
	
	

}
