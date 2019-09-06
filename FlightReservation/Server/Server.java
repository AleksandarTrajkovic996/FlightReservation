import java.io.IOException; 
import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.rmi.registry.*; 

public class Server {
	
	public Server(String h, String p, String s) {
		
		FlightReservation reservation = null;
		
		try{
			reservation = new FlightReservationImpl();
			LocateRegistry.createRegistry(Integer.parseInt(p));
			Naming.rebind("rmi://" + h + ":" + p + "/" + s, reservation);
		}catch(RemoteException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}
		
		try{
			System.out.println("Server uspesno startovan. \n");
			System.in.read();
		}catch(RemoteException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args){
		
		String h = args[0];
		String p = args[1];
		String s = args[2];
		
		new Server(h, p, s);
		
	}
	
	
}