

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerFile extends Remote{
	public String list() throws RemoteException;
	public String list(String args) throws RemoteException;
	public String remove(String args) throws RemoteException;
}
