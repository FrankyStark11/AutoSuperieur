
public class TrajetTooLongException extends Exception {
	
	public TrajetTooLongException(){
		System.out.println("La distance est trop longue! Elle ne doit pas d�passer 200KM");
	}
	
	public String getMessage(){
		return "Trop long";
	}
}
