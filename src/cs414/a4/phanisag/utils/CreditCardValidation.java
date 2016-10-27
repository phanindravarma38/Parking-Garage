package cs414.a4.phanisag.utils;

public class CreditCardValidation {

	// Return true if the card number is valid, otherwise returns false, this
	// method is already implemented
	public boolean aValidNumber(String n) {
	//	System.out.println("in validating class");

		long number = Long.parseLong(n);
		return (numLength(number) >= 13)
				&& (numLength(number) <= 16) && (prefixCheck(number, 4) || prefixCheck(number, 5)
						|| prefixCheck(number, 6) || prefixCheck(number, 37))
				&& (totalEevenNumbers(number) + totalOddNumbers(number)) % 10 == 0;
	}// end of aValidNumber method

	// get the sum of even places numbers, Starting from the second digit from
	// right
	private int totalEevenNumbers(long number) {
		//System.out.println("number here" + number);

		number = number / 10;
		long one = number % 10;
		int digit = (int) one;
		//System.out.println("number is" + number);
		//System.out.println("digit is" + digit);

		int double_digit = digit * 2;
		int final_digit = singleDigit(double_digit);
		//System.out.println("first event " + final_digit);

		int total_even = final_digit;
		//System.out.println("total before" + total_even);

		while (number > 0) {
			number = number / 100;
			one = number % 10;
			digit = (int) one;
			double_digit = digit * 2;
			final_digit = singleDigit(double_digit);
			//System.out.println("event digit: " + final_digit);
			//System.out.println("total before" + total_even);
			total_even += final_digit;

		}

		//System.out.print(total_even);

		return total_even;
	}// end of totalEevenNumbers method

	// Return the same number if it is a single digit, otherwise, return the sum
	// of
	// the two digits in this number
	private int singleDigit(int number) {
		if (number >= 10) {
			number = number - 9;
		}
		return number;

	} // end of singleDigit method

	// Return the sum of odd place digits in number
	private int totalOddNumbers(long number) {
		// number = number / 10;
		long one = number % 10;
		int digit = (int) one;

		int total_odd = digit;
		while (number > 0) {
			number = number / 100;
			one = number % 10;
			digit = (int) one;

			total_odd += digit;

		}

		//System.out.println(total_odd);

		return total_odd;

	}// end of totalOddNumbers method

	// Return true if the digit d is a prefix for number
	private boolean prefixCheck(long number, int d) {
		boolean flag = true;
		if (numPrefix(number, d) == d) {
			flag = true;

		} else {
			flag = false;
		}
		return flag;
	}// end of prefixCheck method

	// Return the number of digits in this number parameter
	private int numLength(long number) {
		int count = 0;
		while (number > 0) {
			number = number / 10;
			count++;
		}

		return count;
	}// end of numLength method

	// Return the first k number of digits from number, which is either a first
	// digit or first two digits
	// Depending on the card type
	private long numPrefix(long number, int k) {
		int len = (int) numLength(number);

		if (k / 10 == 0) {
			//System.out.println("int length" + len);
			for (int i = 0; i < len - 1; i++) {
				number = number / 10;
				//System.out.println("number = " + number);

			}

		} else if (k / 10 > 0) {
			//System.out.println("int length" + len);
			for (int i = 0; i < len - 2; i++) {
				number = number / 10;
				//System.out.println("number = " + number);
			}

		}

		return number;
	}// end of numPrefix method

}// end of the class