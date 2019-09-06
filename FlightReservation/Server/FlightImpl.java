import java.rmi.RemoteException;
import java.util.*;
import java.rmi.*;

public class FlightImpl extends java.rmi.server.UnicastRemoteObject implements Flight {

	public String polazak;
	public String odrediste;
	private ArrayList<Passanger> putnici;
	private boolean[] sedista;
	private int brMesta;
	
	public FlightImpl() throws RemoteException { 
	}

	public FlightImpl(int br, String pol, String odr) throws RemoteException {
		this.polazak = pol;
		this.odrediste = odr;
		this.brMesta = br;
		this.sedista = new boolean[br];
		for(int i=0; i<br; i++)
			sedista[i] = false;
		putnici = new ArrayList<Passanger>();
	}

	public int nadjiSlobodnoSediste() throws RemoteException {
		
		int index =0;
		for(int i=0; i<this.brMesta; i++){
			if(sedista[i]==false){ 
				index = i;
				return index; 
			}
		}
		return -1;
	}
	
	public void rezervisiMesto(int ind, Passanger putnik) throws RemoteException {
		putnici.add(putnik);
		sedista[ind] = true;
		
		for(Passanger p : putnici)
			System.out.println(p.getIme() + " " + p.getPrezime());
	}
}	