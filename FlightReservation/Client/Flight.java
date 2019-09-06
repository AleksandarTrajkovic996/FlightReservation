import java.rmi.*;

public interface Flight extends Remote {
	
	public int nadjiSlobodnoSediste() throws RemoteException;
	
	public void rezervisiMesto(int ind, Passanger putnik) throws RemoteException;
	
}