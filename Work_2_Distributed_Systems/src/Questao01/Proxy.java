package Questao01;

import java.io.IOException;
import java.net.UnknownHostException;

public class Proxy {
	TCPClient tcpClient;
	double result;

	public Proxy() throws UnknownHostException, IOException {
		tcpClient = new TCPClient();
	}

	public void add(double value1, double value2) throws IOException {
		String value = String.valueOf(value1 + " + " + value2);
		tcpClient.sendRequest(value);
		result = tcpClient.getResponse();
	}

	public void sub(double value1, double value2) throws IOException {
		String value = String.valueOf(value1 + " - " + value2);
		tcpClient.sendRequest(value);
		result = tcpClient.getResponse();
	}

	public void mult(double value1, double value2) throws IOException {
		String value = String.valueOf(value1 + " * " + value2);
		tcpClient.sendRequest(value);
		result = tcpClient.getResponse();
	}

	public void div(double value1, double value2) throws IOException {
		String value = String.valueOf(value1 + " / " + value2);
		tcpClient.sendRequest(value);
		result = tcpClient.getResponse();
	}
}