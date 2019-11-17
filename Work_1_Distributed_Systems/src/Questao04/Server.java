package Questao04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Socket client = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		String message;
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(33000);
			client = server.accept();
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			while (true) {
				message = in.readUTF();
				System.out.println(message);
				message = input.nextLine();
				out.writeUTF(message);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
