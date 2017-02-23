import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
public class CCompagnie {
	
	private List<CLimousine> mLstLimousine;
	private List<CChauffeur> mLstChauffeur;
	private List<CReservation> mLstReservation;
	
	//Constructor class CCompagnie
	public CCompagnie(){
		mLstLimousine = new ArrayList<CLimousine>();
		mLstChauffeur = new ArrayList<CChauffeur>();
		mLstReservation = new ArrayList<CReservation>();
	}
	
	public List<CLimousine> GetLimousinesSelonChauffeur(CChauffeur _chauffeur){
		List<CLimousine> LstLimousineTemp = new ArrayList<CLimousine>();
		for(CReservation R : mLstReservation){
			if( LstLimousineTemp.size() > 0){
				
			}
		}
		
		return LstLimousineTemp;
	}
	
	//retourne la liste des chauffeur sous forme de Array
	public CChauffeur[] GetLstChauffeur(){
		
		CChauffeur[] TabChauffeur = new CChauffeur[mLstChauffeur.size()];
		
		for(int i = 0;i<mLstChauffeur.size();i++){
			TabChauffeur[i] = mLstChauffeur.get(i);
		}
		
		return TabChauffeur;
	}
	
	public CChauffeur GetChauffeur(int _indice){
		CChauffeur ChauffeurTemp = mLstChauffeur.get(_indice);
		return ChauffeurTemp;
	}
	
	public void AddLimousine(CLimousine _limousine){
		mLstLimousine.add(_limousine);
	}
	
	public void AddChauffeur(CChauffeur _chauffeur){
		mLstChauffeur.add(_chauffeur);
	}
		
	public String ToString(){
		int NbChauffeur = mLstChauffeur.size();
		int NbLimousine = mLstLimousine.size();
		
		return "La compagnie contient " + NbChauffeur + " chauffeur(s) et " + NbLimousine + " limousine(s).";
	}
}
