package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.userEndpoints;
import api.payload.User;
import io.restassured.response.Response;


public class UserTest {
	
	User userPayload;
	
	@BeforeClass
	public void SetUpData() {
		
		userPayload = new User();
		
		userPayload.setUsername("kiara");
		userPayload.setLastName("advani");
		userPayload.setEmail("kiara@example.com");
		userPayload.setPassword("kiara@123");
		userPayload.setPhone("897984794");
		
	}
	
	@Test(priority=1)
	public void postUser() {
		
		Response response = userEndpoints.PostUser(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void getUser() {
		
		Response response = userEndpoints.getUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=3)
	public void UpdateUser() {
		userPayload.setFirstName("Seema");
		userPayload.setLastName("Saha");
		userPayload.setEmail("seema@example.com");
		
		Response response = userEndpoints.putUser(userPayload, this.userPayload.getUsername());
		response.then().log().all();
		
		
		
		
		
		
	}
	@Test(priority=4)
	public void DeleteUser() {
		Response response = userEndpoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	
	

}
