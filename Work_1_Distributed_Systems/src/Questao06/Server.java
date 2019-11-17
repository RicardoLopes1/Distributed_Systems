package Questao06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		try {
			Socket client = null;
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(33000);
			while (true) {
				client = server.accept();
				@SuppressWarnings("unused")
				ServerFile s = new ServerFile(client);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}