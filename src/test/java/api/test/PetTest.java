package api.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.endpoints.petEndpoints;
import api.payload.*;
import io.restassured.response.Response;



public class PetTest {
	
	
	Pet payload;
	petCategory cate;
	ObjectMapper objectMapper;
	String json_payload;
	String json_payload1;
	long Petid;
	PetTags tag;
	
	
	
	
	@BeforeClass
	public void setupData() throws JsonProcessingException {
		
		payload = new Pet();
		cate = new petCategory();
		objectMapper = new ObjectMapper();
		tag = new PetTags();
		
		
		
		
	
		
		cate.setName("Golden retreiver");
		payload.setCategory(cate);
		payload.setName("kaira");
		
		String photourl[] = {"https://tse2.mm.bing.net/th?id=OIP.q7hrrlJmYEnTavqubhP6fwHaE8&pid=Api&P=0&h=180"};
		payload.setPhotoUrls(photourl);
		
		tag.setName("dog");
		
		List <PetTags> tags = new ArrayList<>();
		tags.add(tag);
		payload.setTags(tags);
		
		
		payload.setStatus("available");
		
		json_payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
		
		
		
		}
	
	@Test(priority=1)
	public void testPostPet() {
		
		
		Response response = petEndpoints.createPet(json_payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Petid = response.path("id");

	}
	
	@Test(priority=2)
	public void testGetPet() {
		
		Response response = petEndpoints.getPet(Petid);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	
	public void testUpdatePet() throws JsonProcessingException {
		
		payload.setName("diana");
		payload.setStatus("Not Available");
	
		json_payload1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		
		
		Response response = petEndpoints.UpdatePet(json_payload1);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
	
	}
	
	public void testDeletePet() {
		
		Response response = petEndpoints.DeletePet(Petid);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	

}
