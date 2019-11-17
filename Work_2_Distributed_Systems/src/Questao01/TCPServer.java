package Questao01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings({ "resource" })
		ServerSocket server = new ServerSocket(33000);
		Socket client = null;
		DataInputStream in;
		DataOutputStream out;
		String data;
		try {
			while (true) {
				client = server.accept();
				out = new DataOutputStream(client.getOutputStream());
				in = new DataInputStream(client.getInputStream());
				data = in.readUTF();
				Despachante despachante = new Despachante(data);
				data = despachante.getResult();
				out.writeUTF(data);
			}
		} catch (EOFException e) {
			e.printStackTrace();
		}
	}
}