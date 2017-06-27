package complexNumbers;

public class Application {

	public static void main(String[] args) {

		ComplexNumberPolar numberPolar1 = new ComplexNumberPolar(1, Math.PI / 2);
		ComplexNumberPolar numberPolar2 = new ComplexNumberPolar(1, 0);

		ComplexNumberStandard numberStandard1 = new ComplexNumberStandard(0, 1);
		ComplexNumberStandard numberStandard2 = new ComplexNumberStandard(1, 1);
		//numberStandard1.divideExact(numberStandard2);
		numberPolar1.pow(2);
		System.out.println(numberStandard2.getHumanReadableValue());
		System.out.println(numberPolar1.equals(numberStandard1));
	}

}