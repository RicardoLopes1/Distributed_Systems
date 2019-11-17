package Questao05;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Read extends Thread {
	DataInputStream in;
	String message;

	public Read(Socket s) throws IOException {
		in = new DataInputStream(s.getInputStream());
		this.start();
	}

	public void run() {
		while (true) {
			try {
				message = in.readUTF();
				System.out.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
