
public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	public Contact(String firstName, String lastName, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public Contact() {
		firstName = "";
		lastName = "";
		email = "";
		phone = "";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public String displayContact() {
		String s = "\n";
		s += ("----------------------------------------------------" + "\n");
		s += ("---- Current Contact -------------------------------" + "\n");
		s += ("----------------------------------------------------" + "\n");
		s += ("Name:           " + firstName + " " + lastName + "\n");
		s += ("Email Address:  " + email + "\n");
		s += ("Phone Number:   " + phone + "\n");
		s += ("----------------------------------------------------" + "\n");
		System.out.println();
		return s;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}

}
