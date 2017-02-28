
public class CTrajet {
	
	//Donn�es membres
	private String mVilleDebut;
	private String mVilleFin;
	private int mKiloDebut;
	private int mKiloFin;
	private CLimousine mLimousine;
	
	//Constructor class CTrajet
	public CTrajet(String _villeDebut, String _villeFin, int _kiloDebut, int _kiloFin, CLimousine _limousine) throws TrajetTooLongException{
		if((_kiloFin - _kiloDebut) < 200){
		
			mVilleDebut = _villeDebut;
			mVilleFin = _villeFin;
			mKiloDebut = _kiloDebut;
			mKiloFin = _kiloFin;
			mLimousine = _limousine;
			
		}
		else{
			throw new TrajetTooLongException();
		}
		
		
	}
	
	//Retourne la String du trajet
	public String ToString(){
		int distanceTot = mKiloFin - mKiloDebut;
		return "Trajet de " + mVilleDebut + " vers " + mVilleFin + " d'une distance de " + distanceTot + "Km avec la limousine " + mLimousine.ToString();
	}
}
