import java.io.Serializable;

public class Passanger implements Serializable {
	
	private String ime;
	private String prezime;
	private String e_mail;
	
	
	public Passanger(String i, String p, String e){
		this.ime = i;
		this.prezime = p;
		this.e_mail=e;
	}
	
	public String getIme(){
		return this.ime;
	}
	public String getPrezime(){
		return this.prezime;
	}
	
}