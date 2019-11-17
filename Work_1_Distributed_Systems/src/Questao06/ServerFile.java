package Questao06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class ServerFile extends Thread {
	Socket client;
	DataInputStream in;
	DataOutputStream out;
	String data;

	public ServerFile(Socket s) throws IOException {
		this.client = s;
		this.in = new DataInputStream(client.getInputStream());
		this.out = new DataOutputStream(client.getOutputStream());
		this.start();
	}

	public String remove(String args) {
		String[] vector = args.split(" ");
		if (vector.length == 2) {
			File Diretorio = new File(System.getProperty("user.home") + "/" + vector[0]);
			File arquivos[] = Diretorio.listFiles();
			for (File i : arquivos) {
				if (i.getName().equals(vector[1])) {
					i.delete();
					return "arquivo " + vector[1] + " removivo do servidor";
				}
			}
		} else {
			File Diretorio = new File(System.getProperty("user.home"));
			File arquivos[] = Diretorio.listFiles();
			for (File i : arquivos) {
				if (i.getName().equals(vector[0])) {
					i.delete();
					return "arquivo " + vector[0] + " removivo do servidor";
				}
			}
		}
		return "Erro";
	}

	public String list(String args) {
		File Diretorio = new File(System.getProperty("user.home") + "/" + args);
		File arquivos[] = Diretorio.listFiles();
		String lista = " ";
		for (File i : arquivos) {
			lista += i.getName() + " ";
		}
		return "Arquivos remotos: " + lista;
	}

	public String list() {
		File Diretorio = new File(System.getProperty("user.home"));
		File arquivos[] = Diretorio.listFiles();
		String lista = " ";
		for (File i : arquivos) {
			lista += i.getName() + " ";
		}
		return "Arquivos remotos: " + lista;
	}

	public void run() {
		try {
			data = in.readUTF();
			String Vector[] = data.split(" ");
			if (Vector[0].equalsIgnoreCase("list")) {
				if (Vector.length == 2) {
					data = list(Vector[1]);
					out.writeUTF(data);
				} else {
					data = list();
					out.writeUTF(data);
				}
			} else if (Vector[0].equalsIgnoreCase("remove")) {
				if (Vector.length == 3) {
					String args = Vector[1] + " " + Vector[2];
					data = remove(args);
					out.writeUTF(data);
				} else {
					String args = Vector[1];
					data = remove(args);
					out.writeUTF(data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}