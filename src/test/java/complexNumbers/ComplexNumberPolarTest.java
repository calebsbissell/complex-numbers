package complexNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexNumberPolarTest {





	@Test
	public void testGetHumanReadableValue() {
		ComplexNumberStandard numberStandardChangeable = new ComplexNumberStandard(1, 1);
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		assertEquals("1 * e^(0i)", numberPolarChangeable.getHumanReadableValue());
		assertEquals("1 + 1i", numberStandardChangeable.getHumanReadableValue());
	}

	@Test
	public void shouldSetAPolarNumberToAnotherPolarNumber() {


		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		numberPolarChangeable.setComplexNumber(numberPolarUnchangeable);
		assertEquals(numberPolarUnchangeable.getHumanReadableValue(), numberPolarChangeable.getHumanReadableValue());
	}

	@Test
	public void shouldAddAPolarNumberToAPolarNumberCorrectly() {

		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);

		numberPolarChangeable.addExact(numberPolarUnchangeable);
		assertEquals(new ComplexNumberPolar(2, 0), numberPolarChangeable);
	}

	@Test
	public void shouldAddAPolarNumberToAStandardNumberCorrectly() {
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		numberPolarChangeable.addExact(numberStandardUnchangeable);
		assertEquals(Math.sqrt(2), numberPolarChangeable.getRadius(),0.000001);
		assertEquals(Math.PI/4, numberPolarChangeable.getTheta(), 0.000001);

	}

	@Test
	public void shouldSubtractAPolarNumberFromAPolarNumberCorrectly() {

		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);

		numberPolarChangeable.subtractExact(numberPolarUnchangeable);
		assertEquals(new ComplexNumberPolar(0, 0).getHumanReadableValue(),
				numberPolarChangeable.getHumanReadableValue());
	}
		@Test
		public void shouldSubtractAStandardNumberFromAPolarNumberCorrectly() {
			ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
			ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);

		numberPolarChangeable.subtractExact(numberStandardUnchangeable);
		assertEquals(new ComplexNumberPolar(Math.sqrt(2), 7 * Math.PI / 4).getHumanReadableValue(),
				numberPolarChangeable.getHumanReadableValue());

	}

	@Test
	public void shouldMultiplyAPolarNumberWithAPolarNumberCorrectly() {

		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		numberPolarChangeable.multiplyExact(numberPolarUnchangeable);
		assertEquals(new ComplexNumberPolar(1, 0).getHumanReadableValue(),
				numberPolarChangeable.getHumanReadableValue());

	}
	
		@Test
		public void shouldMultiplyAPolarNumberWithAStandardNumberCorrectly() {
			ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
			ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		numberPolarChangeable.multiplyExact(numberStandardUnchangeable);
		assertEquals(1, numberPolarChangeable.getRadius(), 0.000001);
		assertEquals(Math.PI / 2, numberPolarChangeable.getTheta(), 0.000001);

	}

	@Test
	public void shouldDivideAPolarNumberByAPolarNumberCorrectly() {

		ComplexNumberPolar numberPolarUnchangeable = new ComplexNumberPolar(1, 0);
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		numberPolarChangeable.divideExact(numberPolarUnchangeable);
		assertEquals(new ComplexNumberPolar(1, 0).getHumanReadableValue(),
				numberPolarChangeable.getHumanReadableValue());

	}

	@Test
	public void shouldDivideAPolarNumberByAStandardNumberCorrectly() {
		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		ComplexNumberStandard numberStandardUnchangeable = new ComplexNumberStandard(0, 1);
		numberPolarChangeable.divideExact(numberStandardUnchangeable);
		assertEquals(1, numberPolarChangeable.getRadius(), 0.000001);
		assertEquals(-Math.PI / 2, numberPolarChangeable.getTheta(), 0.000001);

	}

	@Test
	public void shouldTakeAPolarNumberToAPowerCorrectly() {

		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		numberPolarChangeable.pow(2);
		assertEquals(new ComplexNumberPolar(1, 0).getHumanReadableValue(),
				numberPolarChangeable.getHumanReadableValue());
	}

	@Test
	public void shouldTakeTheNaturalLogarithmOfAPolarNumberCorrectly() {

		ComplexNumberPolar numberPolarChangeable = new ComplexNumberPolar(1, 0);
		 numberPolarChangeable.log();
		 assertEquals(new
		 ComplexNumberPolar(0,0).getHumanReadableValue(),numberPolarChangeable.getHumanReadableValue());
	}
	

}
