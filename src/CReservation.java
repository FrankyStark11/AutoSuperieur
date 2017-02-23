
public class CReservation {
	
	private CChauffeur mChauffeur;
	private CTrajet mTrajet;
	private CLimousine mLimousine;
	
	public CReservation(CChauffeur _chauffeur, CTrajet _trajet, CLimousine _limousine){
		
		mChauffeur = _chauffeur;
		mTrajet = _trajet;
		mLimousine = _limousine;
		
	}
	
	public CChauffeur GetChauffeur(){
		return mChauffeur;
	}
	public CTrajet GetTrajet(){
		return mTrajet;
	}
	public CLimousine GetLimousine(){
		return mLimousine;
	}
	
	public String toString(){
		return "Chauffeur -> " + mChauffeur.GetNomComplet() + ": Trajet -> " + mTrajet.ToString() + " : Limousine -> " + mLimousine.ToString(); 
	}
}
