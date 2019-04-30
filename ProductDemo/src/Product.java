
public class Product {
	
//instance variables
	private String code;
	private String description;
	private double price;

//empty constructor
	public Product () {
		code = "";
		description = "";
		price = 0.0;
	}
//IDE generated constructor	
	public Product(String code, String description, double price) {
		this.code = code;
		this.description = description;
		this.price = price;
		
	}
	
//getters and setters (written in class)
	/*public String getCode() {
		return code;
	}
	
	public void setCode(String code) { //or you could do String c
		this.code = code; //or you could do code = c; 
	}*/
	
//IDE generated getters and setters
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + "]";
	}
	
	

	
	
}
