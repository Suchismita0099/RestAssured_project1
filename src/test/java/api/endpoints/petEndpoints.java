package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class petEndpoints {

	// contains pet CRUD operations

	public static Response createPet(String json_payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(json_payload)
				.when().post(routes.Pet_post_url);

		return response;

	}
	
	public static Response getPet(long petid) {
		
		Response response = given()
				.pathParam("petId", petid)
				.when().get(routes.Pet_get_url);
		
		return response;
	}
	
	public static Response UpdatePet(String json_payload1) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(json_payload1)

				.when().put(routes.Pet_put_url);
		return response;
		
	}
	
	public static Response DeletePet(long petid) {
		
		Response response = given()
				.pathParam("petId", petid)
				.when().delete(routes.Pet_delete_url);
		return response;
		
		
	}

}
