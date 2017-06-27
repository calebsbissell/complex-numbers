package complexNumbers;

import java.math.BigDecimal;

public class ComplexNumberStandard extends ComplexNumberBase implements ComplexNumber {
	protected BigDecimal realComponent, imaginaryComponent;

	public ComplexNumberStandard(double realComponent, double imaginaryComponent) {
		this.realComponent = new BigDecimal(realComponent, accurate);
		this.imaginaryComponent = new BigDecimal(imaginaryComponent, accurate);
	}

	public ComplexNumberStandard(float realComponent, float imaginaryComponent) {
		this.realComponent = new BigDecimal(realComponent, accurate);
		this.imaginaryComponent = new BigDecimal(imaginaryComponent, accurate);
	}

	public ComplexNumberStandard(BigDecimal newRealComponent, BigDecimal newImaginaryComponent) {
		this.realComponent = newRealComponent;
		this.imaginaryComponent = newImaginaryComponent;
	}

	@Override
	public String getHumanReadableValue() {
		return realComponent + " + " + imaginaryComponent + "i";
	}

	public double getRealComponent() {
		return realComponent.doubleValue();
	}

	public double getImaginaryComponent() {
		return imaginaryComponent.doubleValue();
	}

	@Override
	public void setComplexNumber(ComplexNumberPolar polar) {
		realComponent = toStandard(polar).realComponent;
		imaginaryComponent = toStandard(polar).imaginaryComponent;
		// TODO Auto-generated method stub
	}

	@Override
	public void setComplexNumber(ComplexNumberStandard standard) {
		realComponent = standard.realComponent;
		imaginaryComponent = standard.imaginaryComponent;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ComplexNumberPolar) {
			obj = ComplexNumberBase.toStandard((ComplexNumberPolar) obj);
		} else
			obj = (ComplexNumberStandard) obj;

		return this.realComponent.abs(lessAccurate).doubleValue()
				== ((ComplexNumberStandard) obj).realComponent.abs(lessAccurate).doubleValue()
				&& this.imaginaryComponent.abs(lessAccurate).doubleValue()
						== ((ComplexNumberStandard) obj).imaginaryComponent.abs(lessAccurate).doubleValue();
	}

}
