package Questao03;

public class Calculator {
	public String calculator(String operator, double lastValue, double fastValue) {
		if (operator.equals("+")) {
			double result = fastValue + lastValue;
			return String.valueOf(result);
		} else if (operator.equals("*")) {
			double result = fastValue * lastValue;
			return String.valueOf(result);
		} else if (operator.equals("-")) {
			double result = fastValue - fastValue;
			return String.valueOf(result);
		} else if (operator.equals("/")) {
			if (lastValue != 0) {
				double result = fastValue / lastValue;
				return String.valueOf(result);
			}
		}
		return "Erro";
	}
}
