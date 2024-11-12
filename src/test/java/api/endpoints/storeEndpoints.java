package api.endpoints;


import static io.restassured.RestAssured.given;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class storeEndpoints {
	
	// contains CRUD operations
	
	
	public static Response postStore(Store storePayload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(storePayload)
				.when().post(routes.store_post_url);
		return response;
	}
	
	public static Response getStore(int orderid) {
		
		Response response = given()
				.pathParam("orderId", orderid)
				.when().get(routes.Store_get_url);
		return response;
	}
	
	public static Response deleteStore(int orderid) {
		
		Response response = given()
				.pathParam("orderId", orderid)
				.when().delete(routes.Store_delete_url);
		return response;
	}
	
	
	

	

}
