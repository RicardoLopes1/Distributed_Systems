package Questao01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		DatagramSocket aSocket;
		try {
			aSocket = new DatagramSocket();
			String data = input.nextLine();
			byte[] m = data.getBytes();
			InetAddress aHost = InetAddress.getByName("localhost");
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket(m, data.length(), aHost, serverPort);
			aSocket.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply:" + new String(reply.getData()));
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
