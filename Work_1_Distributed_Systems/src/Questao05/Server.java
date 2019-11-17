package Questao05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(33000);
		Socket client = null;
		try {
			while (true) {
				client = server.accept();
				@SuppressWarnings("unused")
				Send s = new Send(client);
				@SuppressWarnings("unused")
				Read r = new Read(client);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
