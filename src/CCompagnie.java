import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.*;
public class CCompagnie {
	
	//---------------------------- DONNÉES MEMBRES -------------------------------------------
	
	private List<CLimousine> mLstLimousine;
	private List<CChauffeur> mLstChauffeur;
	private List<CReservation> mLstReservation;
	
	//CONSTRUCTEUR DE LA CLASS
	public CCompagnie(){
		
		mLstLimousine = new ArrayList<CLimousine>(); //LISTE DES LIMOUSINES
		mLstChauffeur = new ArrayList<CChauffeur>(); //LISTE DES CHAUFFEURS
		mLstReservation = new ArrayList<CReservation>(); //LISTE DES RESERVATIONS
		
	}
	
	//-------------------------------- GET ----------------------------------------------------------
	
	//GET RETOURNE UN ARRAY CONTENANT LES LIMOUSINES POUR LE CHAUFFEUR EN PARAM
	public CLimousine[] GetLimousinesSelonChauffeur(CChauffeur _chauffeur){
		
		List<CLimousine> LstLimousine = new ArrayList<CLimousine>();
		int i = 0;
		
		if( mLstLimousine.size() > 0 && mLstChauffeur.size() > 0){ //si il y a chauffeur et limousine faire ...
			for(CReservation R : mLstReservation){ //parcourt toutes les réservations
				if(R.GetChauffeur().equals(_chauffeur)){ //si le chauffeur demandé apparait dans la reservation
					boolean present = false;
					for(int j = 0 ; j < LstLimousine.size()-1 ; j++){
						if(LstLimousine.get(j).equals(R.GetLimousine())){
							present = true;
						}
					}
					if(!present){ //si la limousine est absente on peut lajouter
						LstLimousine.add(R.GetLimousine()); //ajouter la limousine au array
					}
				}
			}
		}
		CLimousine[] TabLimousine = new CLimousine[LstLimousine.size()];
		return LstLimousine.toArray(TabLimousine); // retourne le array
	}
	
	//GET RETOURNE UN ARRAY CONTENANT LES CHAUFFEURS
	public CChauffeur[] GetAllChauffeur(){
		
		CChauffeur[] TabChauffeur = new CChauffeur[mLstChauffeur.size()];
		
		for(int i = 0;i<mLstChauffeur.size();i++){
			TabChauffeur[i] = mLstChauffeur.get(i);
		}
		
		return TabChauffeur;
	}
	
	//GET RETOURNE UN ARRAY CONTENANT LES LIMOUSINES
	public CLimousine[] GetAllLimousine(){
		
		CLimousine[] TabLimousine = new CLimousine[mLstLimousine.size()];
		
		for(int i = 0 ; i < mLstLimousine.size() ; i++){
			TabLimousine[i] = mLstLimousine.get(i);
		}
		
		return TabLimousine;
	}
	
	//GET RETOURNE LE CHAUFFEUR DEMANDÉ EN INDICE I
	public CChauffeur GetChauffeur(int _indice){
		CChauffeur ChauffeurTemp = mLstChauffeur.get(_indice);
		return ChauffeurTemp;
	}
	
	//-------------------------------- ADD -----------------------------------------------------------
	
	//ADD AJOUTE UNE LIMOUSINE RECUS EN PARAMETRE
	public void AddLimousine(CLimousine _limousine){
		mLstLimousine.add(_limousine);
	}
	
	//ADD AJOUTE UN CHAUFFEUR RECUS EN PARAMETRE
	public void AddChauffeur(CChauffeur _chauffeur){
		mLstChauffeur.add(_chauffeur);
	}
	
	//ADD AJOUTE UNE RESERVATION RECUS EN PARAM
	public void AddReservation(CReservation _reservation){
		mLstReservation.add(_reservation);
	}
	
	//-------------------------------------- METHODES -------------------------------------------------
	
	public CLimousine GetLimousineRandomFromNbPassager(int _passager){
		
		boolean limousineNonTrouve = true;
		int i = 0;
		CLimousine limousine = null;
		
		while(limousineNonTrouve){
			
			Random randomno = new Random();
			i = randomno.nextInt(mLstLimousine.size());
			
			if(mLstLimousine.get(i).GetNombrePassager() > _passager){
				limousineNonTrouve = !limousineNonTrouve;
				limousine = mLstLimousine.get(i);
			}
		}
		return limousine;
	}
	
	//retourne un chauffeur aleatoire de la liste des chauffeurs
	public CChauffeur GetChauffeurRandom(){
		
		int i = 0;
		Random randomno = new Random();
		i = randomno.nextInt(mLstChauffeur.size());
		return mLstChauffeur.get(i);
		
	}
	
	//RETOURNE UN STRING AVEC L'INFORMATION DE LA COMPAGNIE
 	public String ToString(){
		int NbChauffeur = mLstChauffeur.size();
		int NbLimousine = mLstLimousine.size();
		
		return "La compagnie contient " + NbChauffeur + " chauffeur(s) et " + NbLimousine + " limousine(s).";
	}
}
