package RahulShetty.RestAssuredLinearBDD;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String res = given().header("Content-Type", "application/JSON").queryParam("key", "qaclick123")
		.body(Payload.addPlace()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println("Response String: "+res);
		JsonPath js = new JsonPath(res);
		String placeID = js.getString("place_id");
	}

}
