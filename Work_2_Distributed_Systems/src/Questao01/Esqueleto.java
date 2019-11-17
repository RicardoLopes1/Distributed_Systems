package Questao01;

import java.io.IOException;

public class Esqueleto {
	Calculator c = new Calculator();

	public String add(String value1, String value2) throws IOException {
		double fastValue = Double.parseDouble(value1);
		double lastValue = Double.parseDouble(value2);
		String operator = "+";
		double result = c.calculator(operator, fastValue, lastValue);
		return String.valueOf(result);
	}

	public String sub(String value1, String value2) throws IOException {
		double fastValue = Double.parseDouble(value1);
		double lastValue = Double.parseDouble(value2);
		String operator = "-";
		double result = c.calculator(operator, fastValue, lastValue);
		return String.valueOf(result);

	}

	public String mult(String value1, String value2) throws IOException {
		double fastValue = Double.parseDouble(value1);
		double lastValue = Double.parseDouble(value2);
		String operator = "*";
		double result = c.calculator(operator, fastValue, lastValue);
		return String.valueOf(result);

	}

	public String div(String value1, String value2) throws IOException {
		double fastValue = Double.parseDouble(value1);
		double lastValue = Double.parseDouble(value2);
		String operator = "/";
		double result = c.calculator(operator, fastValue, lastValue);
		return String.valueOf(result);
	}
}