import java.rmi.*;

public interface FlightReservation extends Remote {
	
	public Flight pronadjiLet(String polazak, String odrediste) throws RemoteException;
	
}