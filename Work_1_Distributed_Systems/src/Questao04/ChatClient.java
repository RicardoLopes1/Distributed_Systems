package Questao04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Socket client = null;
		DataOutputStream out;
		DataInputStream in;
		String message;
		try {
			client = new Socket("localhost", 33000);
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			while (true) {
				message = input.nextLine();
				out.writeUTF(message);
				System.out.println(in.readUTF());
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
