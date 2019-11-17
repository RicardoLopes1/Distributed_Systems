package Questao05;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	@SuppressWarnings("unused")
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws UnknownHostException, IOException {
		try {
			Socket client = new Socket("localhost", 33000);
			@SuppressWarnings("unused")
			Read r = new Read(client);
			@SuppressWarnings("unused")
			Send s = new Send(client);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
