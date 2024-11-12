package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.storeEndpoints;
import api.payload.Store;
import io.restassured.response.Response;

public class storeTest {
	
	Store storePayload;
	int orderid;
	
	@BeforeClass
	public void setUpdata() {
		
		storePayload = new Store();
		
		storePayload.setPetId(789878969);
		storePayload.setQuantity(5);
		storePayload.setStatus("placed");
		storePayload.setComplete(true);
		
		
		
		
		
	}
	
	@Test(priority=1)
	public void postStore() {
		
		Response response = storeEndpoints.postStore(storePayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		orderid = response.path("id");
		
	}
	
	@Test(priority=2)
	public void getStore() {
		
		Response response = storeEndpoints.getStore(orderid);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	/*@Test(priority=3)
	public void deleteStore() {
		
		Response response = storeEndpoints.deleteStore(orderid);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}*/
	
	
	
}
