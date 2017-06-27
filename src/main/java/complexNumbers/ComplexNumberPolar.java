package complexNumbers;

import java.math.BigDecimal;

public class ComplexNumberPolar extends ComplexNumberBase implements ComplexNumber {

	protected BigDecimal radius, theta;

	public ComplexNumberPolar(double radius, double theta) {
		this.radius = new BigDecimal (radius, accurate);
		this.theta = new BigDecimal (theta, accurate);
	}

	public ComplexNumberPolar(BigDecimal newRadius, BigDecimal newTheta) {
		this.radius = newRadius;
		this.theta = newTheta;
	}

	@Override
	public String getHumanReadableValue() {
		return this.radius + " * e^(" + this.theta + "i)";
	}

	protected double getRadius() {
		return radius.doubleValue();
	}

	protected double getTheta() {
		return theta.doubleValue();
	}

	@Override
	public void setComplexNumber(ComplexNumberPolar polar) {
		radius = polar.radius;
		theta = polar.theta;
		// TODO Auto-generated method stub
	}

	@Override
	public void setComplexNumber(ComplexNumberStandard standard) {
		radius = toPolar(standard).radius;
		theta = toPolar(standard).theta;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ComplexNumberStandard) {
			obj = ComplexNumberBase.toPolar((ComplexNumberStandard)obj);
		} else obj = (ComplexNumberPolar) obj;
//		return this.getHumanReadableValue().equals(obj.getHumanReadableValue());

		
		return this.radius.abs(lessAccurate).doubleValue()
				== ((ComplexNumberPolar) obj).radius.abs(lessAccurate).doubleValue()
				&& this.theta.abs(lessAccurate).doubleValue()
						== ((ComplexNumberPolar) obj).theta.abs(lessAccurate).doubleValue();
	}	

	

}
