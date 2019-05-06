package business;

public class Calculation {

	private int sum;
	private int difference;
	private int product;
	private int quotient;
	private int remainder;

	public Calculation() {
		super();
	}

	public Calculation(int sum, int difference, int product, int quotient, int remainder) {
		super();
		this.sum = sum;
		this.difference = difference;
		this.product = product;
		this.quotient = quotient;
		this.remainder = remainder;
	}

	public int getSum(int firstNum, int secondNum) {
		sum = firstNum + secondNum;
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getDifference(int firstNum, int secondNum) {
		difference = firstNum - secondNum;
		return difference;
	}

	public void setDifference(int difference) {
		this.difference = difference;
	}

	public int getProduct(int firstNum, int secondNum) {
		product = firstNum * secondNum;
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public int getQuotient(int firstNum, int secondNum) {
		quotient = firstNum / secondNum;
		return quotient;
	}

	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	public int getRemainder(int firstNum, int secondNum) {
		remainder = firstNum % secondNum;
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public String toString() {
		return "Calculations [sum=" + sum + ", difference=" + difference + ", product=" + product + ", quotient="
				+ quotient + ", remainder=" + remainder + "]";
	}

}
