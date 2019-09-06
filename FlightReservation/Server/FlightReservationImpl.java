import java.rmi.RemoteException;
import java.util.*;
import java.rmi.*;

public class FlightReservationImpl extends java.rmi.server.UnicastRemoteObject implements FlightReservation {
	
	private ArrayList<Flight> letovi;
		
	public FlightReservationImpl() throws RemoteException {
		letovi = new ArrayList<Flight>();
		
		letovi.add(new FlightImpl(55, "Nis", "Berlin"));
		letovi.add(new FlightImpl(200, "Berlin", "New York")); 
	}
	
	
	public Flight pronadjiLet(String polazak, String odrediste) throws RemoteException {
		
		for(int i=0; i<letovi.size(); i++){
			FlightImpl imp = (FlightImpl) letovi.get(i);
			if(imp.polazak.equals(polazak) && imp.odrediste.equals(odrediste))
				return imp;
		}

		return null;
	}
}