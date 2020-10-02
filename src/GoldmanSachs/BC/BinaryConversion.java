package GoldmanSachs.BC;

import java.util.Scanner;

public class BinaryConversion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		if (str > 0) {
			System.out.println(getBinaryReversal(str));
		} else {
			System.out.println("Please enter positive Integer which is greater than 0");
		}

	}

	private static int getBinaryReversal(int str) {
		String binaryRepresentation = getBinaryNumber(str);
		String paddedBinaryString = padZeros(binaryRepresentation);
		// Above two methods can be replaced by the following built in method & regex
		// System.out.println("formatted string "+String.format("%8s",
		// Integer.toBinaryString(str)).replace(' ', '0'));
		int result = getReversedDecimalNumber(paddedBinaryString);
		return result;

	}

	private static String getBinaryNumber(int str) {
		String binaryString = "";
		while (str > 0) {
			if (str % 2 == 0)
				binaryString = "0" + binaryString;
			else
				binaryString = "1" + binaryString;

			str = str / 2;
		}
		return binaryString;
	}

	private static String padZeros(String binaryRepresentation) {
		// Reason for using Stringbuffer : Concatenation is expensive for strings(Common
		// mistake which many developers do).
		/*
		 * String concatenation creates a new string i.e, a new string will be created
		 * each time and characters will be copied over.
		 */

		int diff = 8 - binaryRepresentation.length();
		StringBuffer leftPadding = new StringBuffer();
		while (diff > 0) {
			leftPadding.append("0");
			diff--;
		}
		return leftPadding.toString() + binaryRepresentation;
	}

	private static int getReversedDecimalNumber(String paddedBinaryString) {

		// reverse the padded binary string using two pointer approach - in place
		// reversal

		char[] characters = paddedBinaryString.toCharArray();
		int i = 0, j = characters.length - 1;
		while (i < j) {
			char temp = characters[i];
			characters[i++] = characters[j];
			characters[j--] = temp;
		}
		String reversedBinary = new String(characters);

		// get decimal number from the binary
		int paddedBinaryNumber = Integer.parseInt(reversedBinary);
		int decimal = 0, n = 0;
		while (1 == 1) {
			if (paddedBinaryNumber == 0) {
				break;
			} else {
				int temp = paddedBinaryNumber % 10;
				decimal += temp * Math.pow(2, n);
				paddedBinaryNumber = paddedBinaryNumber / 10;
				n++;
			}
		}

		return decimal;
	}
}
