package Questao01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Despachante extends Thread {
	Socket client;
	String[] vector;
	String result;
	DataOutputStream out;
	DataInputStream in;
	String data;
	Esqueleto s = new Esqueleto();

	public Despachante(String values) throws NumberFormatException, IOException {
		this.data = values;
		this.result = invoke(data);
		this.start();
	}

	public String invoke(String values) throws NumberFormatException, IOException {
		vector = values.split(" ");
		if (vector[1].equals("+")) {
			return s.add(vector[0], vector[2]);
		} else if (vector[1].equals("-")) {
			return s.sub(vector[0], vector[2]);
		} else if (vector[1].equals("*")) {
			return s.mult(vector[0], vector[2]);
		} else if (vector[1].equals("/")) {
			if (!(vector[2].equals("0"))) {
				return s.div(vector[0], vector[2]);
			} else {
				return "Não é possivel dividir por 0";
			}
		}
		return "Erro";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String value) {
		this.result = value;
	}

	public void run() {
		try {
			setResult(invoke(data));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}