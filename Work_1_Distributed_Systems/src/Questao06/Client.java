package Questao06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Socket client;
		DataInputStream in;
		DataOutputStream out;
		String data;
		try {
			client = new Socket("localhost", 33000);
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());

			data = input.nextLine();
			out.writeUTF(data);

			data = in.readUTF();

			System.out.println(data);
		} catch (Exception e) {
		}
	}
}
