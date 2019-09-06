import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
	
	public Client(String h, String p, String s) throws RemoteException, NotBoundException {
		
		FlightReservation reservation = null;
		
		try{
			
			reservation = (FlightReservation) Naming.lookup("rmi://" + h + ":" + p + "/" + s); //preuzimanje reference na udaljeni objekat
			
			Scanner unos = new Scanner(System.in);
			System.out.println("Unesite mesto polaska: ");
			String pol = unos.nextLine();
			System.out.println("Unesite mesto odredista: ");
			String odr = unos.nextLine();
			
			Flight f = reservation.pronadjiLet(pol, odr);
			if(f!=null){
				
				int indexSedista = f.nadjiSlobodnoSediste();
				if(indexSedista<0){
					System.out.println("Ovaj let je popunjen!");
				}else{
						System.out.print("Unesite Vase ime: \n");
						String ime = unos.nextLine();
						System.out.print("Unesite Vase prezime: \n");
						String prez = unos.nextLine();
						System.out.print("Unesite Vasu e-mail adresu: \n");
						String email = unos.nextLine();
						
						Passanger putnik = new Passanger(ime, prez, email);
						f.rezervisiMesto(indexSedista, putnik);
				}
				
			}else{
				System.out.println("Nazalost takav let ne postoji.");
			}
			
		}catch(RemoteException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(NotBoundException e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		
		String h = args[0];
		String p = args[1];
		String s = args[2];
		try{
			
			new Client(h, p, s);
		
		}catch(RemoteException e){
			System.out.println(e);
		}catch(NotBoundException e){
			System.out.println(e);
		}
	}
	
}