
public class ProductDemoApp {

	public static void main(String[] args) {
		System.out.println("hello");
		/*Product product1 = new Product ("java","Murach's Java Programming", 57.50);
		Product product2 = new Product ("mySQL", "Murach's MySQL", 54.50);
		
		System.out.println(product1.getCode()+" "+product1.getDescription()+" "+product1.getPrice());
		System.out.println(product2.toString());
		System.out.println("goodbye");*/

		Book erinsBook = new Book("java","Murach's Java Programming", 57.50,
									"Joel Murach");
		System.out.println(erinsBook);
	}

}
