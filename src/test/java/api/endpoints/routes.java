package api.endpoints;

public class routes {
	
	// base url 
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	
	// REST urls (pet)
	public static String Pet_post_url = "https://petstore.swagger.io/v2/pet";
	
	public static String Pet_put_url = "https://petstore.swagger.io/v2/pet";
	
	public static String Pet_get_url = "https://petstore.swagger.io/v2/pet/{petId}";
	
	public static String Pet_delete_url = "https://petstore.swagger.io/v2/pet/{petId}";
	
	//REST urls (store)
	
	public static String store_post_url = "https://petstore.swagger.io/v2/store/order";
	public static String Store_get_url = "https://petstore.swagger.io/v2/store/order/{orderId}";
	public static String Store_delete_url = "https://petstore.swagger.io/v2/store/order/{orderId}";
	
	
	//REST urls (user)
	
	public static String user_post_url = "https://petstore.swagger.io/v2/user";
	public static String user_put_url = "https://petstore.swagger.io/v2/user/{username}";
	public static String user_get_url = "https://petstore.swagger.io/v2/user/{username}";
	public static String user_delete_url = "https://petstore.swagger.io/v2/user/{username}";
	
	
	

}
