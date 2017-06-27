package complexNumbers;

public interface ComplexNumber {

	/**
	 * Adds the amount from the complex number.
	 *
	 * @param number
	 *            The number to add to the complex number.
	 */
	void addExact(ComplexNumber number);

	/**
	 * Subtracts the amount from the complex number.
	 *
	 * @param number
	 *            The number to subtract from the complex number.
	 */
	void subtractExact(ComplexNumber number);

	/**
	 * Multiplies the complex number by the input parameter.
	 *
	 * @param number
	 *            The number to multiple the complex number by.
	 */
	void multiplyExact(ComplexNumber number);

	/**
	 * Divides the complex number by the divisor
	 *
	 * @param divisor
	 *            The amount to divide the complex number by.
	 */
	void divideExact(ComplexNumber divisor);

	/**
	 * Takes the complex number and raises it to the power of the input
	 * parameter.
	 *
	 * @param power
	 *            The amount to raise the complex number
	 */
	void pow(int power);

	/**
	 * Gets the logarithm of the complex number
	 */
	void log();

	/**
	 * Returns a human readable String representing the number
	 *
	 * @return A human readable string
	 */
	String toString();
}
