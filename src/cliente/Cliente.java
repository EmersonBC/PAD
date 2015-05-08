package cliente;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cliente extends Remote{
	 public int operacao(String op) throws RemoteException, SecurityException, IOException;
}
