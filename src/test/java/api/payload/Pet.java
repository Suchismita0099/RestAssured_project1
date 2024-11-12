package api.payload;

import java.util.List;

public class Pet {
	
	private long id;
	private petCategory category;
	private String name;
	private String photoUrls[];
	private List<PetTags> tags;
	private String status;
	
	
	
	
	
	
	
	public List<PetTags> getTags() {
		return tags;
	}
	public void setTags(List<PetTags> tags) {
		this.tags = tags;
	}
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public petCategory getCategory() {
		return category;
	}
	public void setCategory(petCategory category) {
		this.category = category;
	}
	public long getId() {
		return id;
	}
	
	
	
	
}
