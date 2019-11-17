package Questao01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	DataInputStream in;
	DataOutputStream out;

	public TCPClient() throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		Socket client = new Socket("localhost", 33000);
		in = new DataInputStream(client.getInputStream());
		out = new DataOutputStream(client.getOutputStream());
	}

	public void sendRequest(String value) throws IOException {
		out.writeUTF(value);
	}

	public double getResponse() throws IOException {
		String data = in.readUTF();
		double result = Double.parseDouble(data);
		return result;
	}
}