package Questao01;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class User {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws UnknownHostException, IOException {
		Proxy proxy = new Proxy();
		System.out.println("Insira um valor:");
		Double value1 = input.nextDouble();
		input.nextLine();
		System.out.println("Insira o operador");
		String operator = input.nextLine();
		System.out.println("Insira um valor:");
		Double value2 = input.nextDouble();
		input.nextLine();
		if (operator.equals("+")) {
			proxy.add(value1, value2);
			System.out.println("Resultado: " + proxy.result);
		} else if (operator.equals("-")) {
			proxy.sub(value1, value2);
			System.out.println("Resultado: " + proxy.result);
		} else if (operator.equals("*")) {
			proxy.mult(value1, value2);
			System.out.println("Resultado: " + proxy.result);
		} else if (operator.equals("/")) {
			proxy.div(value1, value2);
			System.out.println("Resultado: " + proxy.result);
		} else {
			System.out.println("Valores não Valido");
		}
	}
}