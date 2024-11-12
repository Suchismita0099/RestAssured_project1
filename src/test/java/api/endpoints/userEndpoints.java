package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;

public class userEndpoints {
	
	public static Response PostUser(User userpayload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userpayload)
				.when().post(routes.user_post_url);
		return response;
	}
	
	public static Response getUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
				.when().get(routes.user_get_url);
		       
		return response;
		
	}
	
	public static Response putUser(User userpayload, String userName) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userpayload)
				.pathParam("username", userName)
				.when().put(routes.user_put_url);
		return response;
	}
	
	public static Response  deleteUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)
				.when().delete(routes.user_delete_url);
		return response;
		
		
	}

}
