import java.rmi.*;
//import java.rmi.Remote;

public interface FlightReservation extends Remote {
	
	public Flight pronadjiLet(String polazak, String odrediste) throws RemoteException;
	
}