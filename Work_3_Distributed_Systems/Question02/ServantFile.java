

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServantFile implements ServerFile{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ServantFile() throws RemoteException {
		super();
	}

	@Override
	public String list() throws RemoteException {
		File Diretorio = new File(System.getProperty("user.home"));
		File arquivos[] = Diretorio.listFiles();
		String lista = " ";
		for (File i : arquivos) {
			lista += i.getName() + " ";
		}
		return "Arquivos remotos: " + lista;
	}

	@Override
	public String list(String args) throws RemoteException {
		File Diretorio = new File(System.getProperty("user.home") + "/" + args);
		File arquivos[] = Diretorio.listFiles();
		String lista = " ";
		for (File i : arquivos) {
			lista += i.getName() + " ";
		}
		return "Arquivos remotos: " + lista;
	}
	@Override
	public String remove(String args) throws RemoteException {
		String[] vector = args.split(" ");
		if (vector.length == 2) {
			File Diretorio = new File(System.getProperty("user.home") + "/" + vector[0]);
			File arquivos[] = Diretorio.listFiles();
			for (File i : arquivos) {
				if (i.getName().equals(vector[1])) {
					i.delete();
					return "arquivo " + vector[1] + " removido do servidor";
				}
			}
		} else {
			File Diretorio = new File(System.getProperty("user.home"));
			File arquivos[] = Diretorio.listFiles();
			for (File i : arquivos) {
				if (i.getName().equals(vector[0])) {
					i.delete();
					return "arquivo " + vector[0] + " removido do servidor";
				}
			}
		}
		return "Erro";
	}
}
