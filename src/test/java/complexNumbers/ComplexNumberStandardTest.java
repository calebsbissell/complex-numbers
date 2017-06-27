package complexNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexNumberStandardTest {

	ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);


	@Test
	public void shouldGiveAHumanReadableValue() {
		assertEquals("1 + 3i", new ComplexNumberStandard(1, 3).getHumanReadableValue());
	}

	@Test
	public void shouldHandleConstruction() {
		assertEquals(0.0f, new ComplexNumberStandard(0.0f, 0.0f).getImaginaryComponent(), 0.001);
		assertEquals(0.0f, new ComplexNumberStandard(0.0f, 0.0f).getRealComponent(), 0.001);
		assertEquals(1.0f, new ComplexNumberStandard(0.0f, 1.0f).getImaginaryComponent(), 0.001);
		assertEquals(2.0f, new ComplexNumberStandard(2.0f, 0.0f).getRealComponent(), 0.001);
	}

	@Test
	public void shouldAddTwoStandardNumbersCorrectly() {
		ComplexNumber first = new ComplexNumberStandard(1, 2);
		ComplexNumber second = new ComplexNumberStandard(3, 4);
		first.addExact(second);
		assertEquals(new ComplexNumberStandard(4, 6), first);
	}

	@Test
	public void shouldCompareTwoNumbersCorrectly() {
		assertNotEquals(new ComplexNumberStandard(1, 4), new ComplexNumberStandard(1, 3));
	}

	@Test
	public void shouldCompareTwoSameValuedNumbersCorrectly() {
		ComplexNumberStandard expected = new ComplexNumberStandard(1, 1);
		ComplexNumberPolar actual = ComplexNumberBase.toPolar(expected);
		ComplexNumberStandard stdActual = ComplexNumberBase.toStandard(actual);
		assertEquals("Didn't match: " + expected.getHumanReadableValue() + " to " + stdActual.getHumanReadableValue(),
				expected, actual);
	}

	@Test
	public void shouldSetAStandardNumberToAnotherStandardNumber() {

		ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		numberStandardChangeable.setComplexNumber(numberStandardUnchangeable);
		assertEquals(numberStandardUnchangeable.getHumanReadableValue(),
				numberStandardChangeable.getHumanReadableValue());
	}

	@Test
	public void shouldAddAStandardNumberToAStandardNumberCorrectly() {

		ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		numberStandardChangeable.addExact(numberStandardUnchangeable);
		assertEquals(new ComplexNumberStandard(1, 2).getHumanReadableValue(),
				numberStandardChangeable.getHumanReadableValue());
	}

	@Test
	public void shouldAddAStandardNumberToAPolarNumberCorrectly() {
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		numberStandardChangeable.addExact(numberPolarUnchangeable);
		assertEquals(new ComplexNumberStandard(2, 1), numberStandardChangeable);
	}

	@Test
	public void shouldSubtractAStandardNumberFromAStandardNumberCorrectly() {

		ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		numberStandardChangeable.subtractExact(numberStandardUnchangeable);
		assertEquals(new ComplexNumberStandard(1, 0).getHumanReadableValue(),
				numberStandardChangeable.getHumanReadableValue());
	}

	@Test
	public void shouldSubtractAPolarNumberFromAStandardNumberCorrectly() {
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		numberStandardChangeable.subtractExact(numberPolarUnchangeable);
		assertEquals(new ComplexNumberStandard(0, 1).getHumanReadableValue(),
				numberStandardChangeable.getHumanReadableValue());
	}

	@Test
	public void shouldMultiplyAStandardNumberWithAStandardNumberCorrectly() {

		ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		numberStandardChangeable.multiplyExact(numberStandardUnchangeable);
		assertEquals(-1, numberStandardChangeable.getRealComponent(), 0.000001);
		assertEquals(1, numberStandardChangeable.getImaginaryComponent(), 0.000001);
	}

	@Test
	public void shouldMultiplyAStandardNumberWithAPolarNumberCorrectly() {
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		numberStandardChangeable.multiplyExact(numberPolarUnchangeable);
		assertEquals(1, numberStandardChangeable.getRealComponent(), 0.000001);
		assertEquals(1, numberStandardChangeable.getImaginaryComponent(), 0.000001);
	}

	@Test
	public void shouldDivideAStandardNumberByAStandardNumberCorrectly() {

		ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		numberStandardChangeable.divideExact(numberStandardUnchangeable);
		assertEquals(1, numberStandardChangeable.getRealComponent(), 0.000001);
		assertEquals(-1, numberStandardChangeable.getImaginaryComponent(), 0.000001);
	}

	@Test
	public void shouldDivideAStandardNumberByAPolarNumberCorrectly() {
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		numberStandardChangeable.divideExact(numberPolarUnchangeable);
		assertEquals(1, numberStandardChangeable.getRealComponent(), 0.000001);
		assertEquals(1, numberStandardChangeable.getImaginaryComponent(), 0.000001);
	}

	@Test
	public void shouldTakeAStandardNumberToAPowerCorrectly() {
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		numberStandardChangeable.pow(2);
		assertEquals(0, numberStandardChangeable.getRealComponent(), 0.000001);
		assertEquals(2, numberStandardChangeable.getImaginaryComponent(), 0.000001);
	}

	@Test
	public void shouldTakeTheNaturalLogarithmOfAStandardNumberCorrectly() {
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		numberStandardChangeable.log();
		assertEquals(Math.log(Math.sqrt(2)), numberStandardChangeable.getRealComponent(), 0.0001);
		assertEquals(Math.PI / 4, numberStandardChangeable.getImaginaryComponent(), 0.0001);
	}
}
