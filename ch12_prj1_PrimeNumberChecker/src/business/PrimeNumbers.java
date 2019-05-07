package business;


import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	private List<Integer> factors;


	public PrimeNumbers() {
		super();
	}

	public PrimeNumbers(List<Integer> factors) {
		super();
		this.factors = factors;
	}

	public List<Integer> getFactors() {
		return factors;
	}

	public void setFactors(ArrayList<Integer> factors) {
		this.factors = factors;
	}

	public void addFactor(Integer factor) {
		factors.add(factor);
	}

	public void checkPrimeAddFactor(int numberChoice) {
		boolean isPrime = true;
		addFactor(1);
		for (int i = 2; i < numberChoice; i++) {
			if (numberChoice % i == 0) {
				addFactor(i);
				isPrime = false;
			} 
		}
		if (isPrime) {
			System.out.println(numberChoice + " is a prime number.");
		} else {
			addFactor(numberChoice);
			int numberOfFactors = factors.size();
			System.out.println(numberChoice + " is NOT a prime number.");
			System.out.print("It has " + numberOfFactors + " factors: ");
			for (Integer factor : factors) {
				System.out.print(factor + " ");
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "PrimeNumbers [factors=" + factors + "]";
	}
}
