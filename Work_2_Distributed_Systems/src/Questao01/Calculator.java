package Questao01;

public class Calculator {
	String[] vector;
	String result;

	public Calculator() {
	}

	public double calculator(String operator, double fastValue, double lastValue) {
		if (operator.equals("+")) {
			double result = fastValue + lastValue;
			return result;
		} else if (operator.equals("*")) {
			double result = fastValue * lastValue;
			return result;
		} else if (operator.equals("-")) {
			double result = fastValue - lastValue;
			return result;
		} else if (operator.equals("/")) {
			if (lastValue != 0) {
				double result = fastValue / lastValue;
				return result;
			}
		}
		return 0;
	}
}