package complexNumbers;

import java.math.MathContext;
import java.math.RoundingMode;

import java.math.BigDecimal;

public abstract class ComplexNumberBase {
	MathContext accurate = new MathContext(20, RoundingMode.HALF_EVEN);
	MathContext lessAccurate = new MathContext(10, RoundingMode.HALF_EVEN);
	public void addExact(ComplexNumber number) {
		BigDecimal realComponentSum, imaginaryComponentSum;
		if (this instanceof ComplexNumberStandard && number instanceof ComplexNumberStandard) {
			ComplexNumberStandard numberStandard = (ComplexNumberStandard) number;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			realComponentSum = numberStandard.realComponent.add(thisNumberStandard.realComponent);
			imaginaryComponentSum = numberStandard.imaginaryComponent.add(thisNumberStandard.imaginaryComponent);
			this.setComplexNumber(
					new ComplexNumberStandard(realComponentSum.doubleValue(), imaginaryComponentSum.doubleValue()));
		} else if ((this instanceof ComplexNumberStandard) && (number instanceof ComplexNumberPolar)) {
			ComplexNumberPolar numberPolar = (ComplexNumberPolar) number;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			realComponentSum = toStandard(numberPolar).realComponent.add(thisNumberStandard.realComponent);
			imaginaryComponentSum = toStandard(numberPolar).imaginaryComponent
					.add(thisNumberStandard.imaginaryComponent);
			this.setComplexNumber(
					new ComplexNumberStandard(realComponentSum.doubleValue(), imaginaryComponentSum.doubleValue()));
		} else if ((this instanceof ComplexNumberPolar) && (number instanceof ComplexNumberPolar)) {
			ComplexNumberPolar numberPolar = (ComplexNumberPolar) number;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			realComponentSum = toStandard(numberPolar).realComponent.add(toStandard(thisNumberPolar).realComponent);
			imaginaryComponentSum = toStandard(numberPolar).imaginaryComponent
					.add(toStandard(thisNumberPolar).imaginaryComponent);
			this.setComplexNumber(toPolar(
					new ComplexNumberStandard(realComponentSum.doubleValue(), imaginaryComponentSum.doubleValue())));
		} else if ((this instanceof ComplexNumberPolar) && (number instanceof ComplexNumberStandard)) {
			ComplexNumberStandard numberStandard = (ComplexNumberStandard) number;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			realComponentSum = numberStandard.realComponent.add(toStandard(thisNumberPolar).realComponent);
			imaginaryComponentSum = numberStandard.imaginaryComponent
					.add(toStandard(thisNumberPolar).imaginaryComponent);
			this.setComplexNumber(toPolar(
					new ComplexNumberStandard(realComponentSum.doubleValue(), imaginaryComponentSum.doubleValue())));
		}

	}

	public void subtractExact(ComplexNumber number) {
		BigDecimal realComponentDifference = new BigDecimal(0);
		BigDecimal imaginaryComponentDifference = new BigDecimal(0);
		if (this instanceof ComplexNumberStandard && number instanceof ComplexNumberStandard) {
			ComplexNumberStandard numberStandard = (ComplexNumberStandard) number;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			realComponentDifference = thisNumberStandard.realComponent.subtract(numberStandard.realComponent);
			imaginaryComponentDifference = thisNumberStandard.imaginaryComponent
					.subtract(numberStandard.imaginaryComponent);
			this.setComplexNumber(new ComplexNumberStandard(realComponentDifference.doubleValue(),
					imaginaryComponentDifference.doubleValue()));
		} else if ((this instanceof ComplexNumberStandard) && (number instanceof ComplexNumberPolar)) {
			ComplexNumberPolar numberPolar = (ComplexNumberPolar) number;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			realComponentDifference = thisNumberStandard.realComponent.subtract(toStandard(numberPolar).realComponent);
			imaginaryComponentDifference = thisNumberStandard.imaginaryComponent
					.subtract(toStandard(numberPolar).imaginaryComponent);
			this.setComplexNumber(new ComplexNumberStandard(realComponentDifference.doubleValue(),
					imaginaryComponentDifference.doubleValue()));
		} else if ((this instanceof ComplexNumberPolar) && (number instanceof ComplexNumberPolar)) {
			ComplexNumberPolar numberPolar = (ComplexNumberPolar) number;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			realComponentDifference = toStandard(thisNumberPolar).realComponent
					.subtract(toStandard(numberPolar).realComponent);
			imaginaryComponentDifference = toStandard(thisNumberPolar).imaginaryComponent
					.subtract(toStandard(numberPolar).imaginaryComponent);
			this.setComplexNumber(toPolar(new ComplexNumberStandard(realComponentDifference.doubleValue(),
					imaginaryComponentDifference.doubleValue())));
		} else if ((this instanceof ComplexNumberPolar) && (number instanceof ComplexNumberStandard)) {
			ComplexNumberStandard numberStandard = (ComplexNumberStandard) number;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			realComponentDifference = toStandard(thisNumberPolar).realComponent.subtract(numberStandard.realComponent);
			imaginaryComponentDifference = toStandard(thisNumberPolar).imaginaryComponent
					.subtract(numberStandard.imaginaryComponent);
			this.setComplexNumber(toPolar(new ComplexNumberStandard(realComponentDifference.doubleValue(),
					imaginaryComponentDifference.doubleValue())));
		}
	}

	public void multiplyExact(ComplexNumber number) {
		BigDecimal radiusProduct, thetaSum;
		if (this instanceof ComplexNumberStandard && number instanceof ComplexNumberStandard) {
			ComplexNumberStandard numberStandard = (ComplexNumberStandard) number;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			radiusProduct = toPolar(numberStandard).radius.multiply(toPolar(thisNumberStandard).radius);
			thetaSum = toPolar(numberStandard).theta.add(toPolar(thisNumberStandard).theta);
			this.setComplexNumber(toStandard(new ComplexNumberPolar(radiusProduct, thetaSum)));
		} else if ((this instanceof ComplexNumberStandard) && (number instanceof ComplexNumberPolar)) {
			ComplexNumberPolar numberPolar = (ComplexNumberPolar) number;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			radiusProduct = numberPolar.radius.multiply(toPolar(thisNumberStandard).radius);
			thetaSum = numberPolar.theta.add(toPolar(thisNumberStandard).theta);
			this.setComplexNumber(toStandard(new ComplexNumberPolar(radiusProduct, thetaSum)));
		} else if ((this instanceof ComplexNumberPolar) && (number instanceof ComplexNumberPolar)) {
			ComplexNumberPolar numberPolar = (ComplexNumberPolar) number;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			radiusProduct = numberPolar.radius.multiply(thisNumberPolar.radius);
			thetaSum = numberPolar.theta.add(thisNumberPolar.theta);
			this.setComplexNumber(new ComplexNumberPolar(radiusProduct, thetaSum));
		} else if ((this instanceof ComplexNumberPolar) && (number instanceof ComplexNumberStandard)) {
			ComplexNumberStandard numberStandard = (ComplexNumberStandard) number;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			radiusProduct = toPolar(numberStandard).radius.multiply(thisNumberPolar.radius);
			thetaSum = toPolar(numberStandard).theta.add(thisNumberPolar.theta);
			this.setComplexNumber(new ComplexNumberPolar(radiusProduct, thetaSum));
		}

	}

	public void divideExact(ComplexNumber divisor) throws ArithmeticException {
		BigDecimal radiusQuotient, thetaDifference;
		if (this instanceof ComplexNumberStandard && divisor instanceof ComplexNumberStandard) {
			ComplexNumberStandard divisorStandard = (ComplexNumberStandard) divisor;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			radiusQuotient = toPolar(thisNumberStandard).radius.divide(toPolar(divisorStandard).radius);
			thetaDifference = toPolar(thisNumberStandard).theta.subtract(toPolar(divisorStandard).theta);
			this.setComplexNumber(toStandard(new ComplexNumberPolar(radiusQuotient, thetaDifference)));
		} else if ((this instanceof ComplexNumberStandard) && (divisor instanceof ComplexNumberPolar)) {
			ComplexNumberPolar divisorPolar = (ComplexNumberPolar) divisor;
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			radiusQuotient = toPolar(thisNumberStandard).radius.divide(divisorPolar.radius);
			thetaDifference = toPolar(thisNumberStandard).theta.subtract(divisorPolar.theta);
			this.setComplexNumber(toStandard(new ComplexNumberPolar(radiusQuotient, thetaDifference)));
		} else if ((this instanceof ComplexNumberPolar) && (divisor instanceof ComplexNumberPolar)) {
			ComplexNumberPolar divisorPolar = (ComplexNumberPolar) divisor;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			radiusQuotient = thisNumberPolar.radius.divide(divisorPolar.radius);
			thetaDifference = thisNumberPolar.theta.subtract(divisorPolar.theta);
			this.setComplexNumber(new ComplexNumberPolar(radiusQuotient, thetaDifference));
		} else if ((this instanceof ComplexNumberPolar) && (divisor instanceof ComplexNumberStandard)) {
			ComplexNumberStandard divisorStandard = (ComplexNumberStandard) divisor;
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			radiusQuotient = thisNumberPolar.radius.divide(toPolar(divisorStandard).radius);
			thetaDifference = thisNumberPolar.theta.subtract(toPolar(divisorStandard).theta);
			this.setComplexNumber(new ComplexNumberPolar(radiusQuotient, thetaDifference));
		}

	}

	public void pow(int power) {
		BigDecimal newRadius, newTheta;
		BigDecimal bigDecimalPower = new BigDecimal(power);
		if (this instanceof ComplexNumberStandard) {
			ComplexNumberStandard beforeRaisedToAPower = (ComplexNumberStandard) this;
			newRadius = (toPolar(beforeRaisedToAPower).radius).pow(power);
			newTheta = (toPolar(beforeRaisedToAPower).theta).multiply(bigDecimalPower);
			this.setComplexNumber(toStandard(new ComplexNumberPolar(newRadius, newTheta)));
		} else if (this instanceof ComplexNumberPolar) {
			ComplexNumberPolar beforeRaisedToAPower = (ComplexNumberPolar) this;
			newRadius = beforeRaisedToAPower.radius.pow(power);
			newTheta = beforeRaisedToAPower.theta.multiply(bigDecimalPower);
			this.setComplexNumber(new ComplexNumberPolar(newRadius, newTheta));
		}

	}

	public void log() {
		BigDecimal newRealComponent, newImaginaryComponent;
		if (this instanceof ComplexNumberPolar) {
			ComplexNumberPolar thisNumberPolar = (ComplexNumberPolar) this;
			newRealComponent = BigDecimal.valueOf(Math.log(thisNumberPolar.getRadius()));
			newImaginaryComponent = thisNumberPolar.theta;
			this.setComplexNumber(toPolar(
					new ComplexNumberStandard(newRealComponent, newImaginaryComponent)));
		} else if (this instanceof ComplexNumberStandard) {
			ComplexNumberStandard thisNumberStandard = (ComplexNumberStandard) this;
			newRealComponent = BigDecimal.valueOf(Math.log(toPolar(thisNumberStandard).getRadius()));
			newImaginaryComponent = toPolar(thisNumberStandard).theta;
			this.setComplexNumber(
					new ComplexNumberStandard(newRealComponent.doubleValue(), newImaginaryComponent.doubleValue()));
		}
	}

	/**
	 * Shows the human readable version of the complex number.
	 * 
	 * @return a string representing the complex number
	 */
	abstract String getHumanReadableValue();

	/**
	 * Sets the current value to the value of the input standard.
	 */
	abstract void setComplexNumber(ComplexNumberStandard standard);

	/**
	 * Sets the current value to the value of the input polar number.
	 */
	abstract void setComplexNumber(ComplexNumberPolar polar);

	static ComplexNumberStandard toStandard(ComplexNumberPolar numberPolar) {
		return new ComplexNumberStandard(numberPolar.getRadius() * Math.cos(numberPolar.getTheta()),
				numberPolar.getRadius() * Math.sin(numberPolar.getTheta()));
	}

	static ComplexNumberPolar toPolar(ComplexNumberStandard number) {
		double radius, theta;
		radius = Math.sqrt(Math.pow(number.realComponent.doubleValue(), 2)
				+ Math.pow(number.imaginaryComponent.doubleValue(), 2));
		if (number.imaginaryComponent.doubleValue() >= 0 & radius!=0) {
			theta = Math.acos(number.realComponent.doubleValue() / radius);
		} else if (radius!=0) {
			theta = 2 * Math.PI - Math.acos(number.realComponent.doubleValue() / radius);
		} else
			theta=0;
		return new ComplexNumberPolar(radius, theta);
	}

}
