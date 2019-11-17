package Questao05;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Send extends Thread {
	Scanner input = new Scanner(System.in);
	DataOutputStream out;
	String message;

	public Send(Socket s) throws IOException {
		out = new DataOutputStream(s.getOutputStream());
		this.start();
	}

	public void run() {
		while (true) {
			try {
				message = input.nextLine();
				out.writeUTF(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
