import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
public class CChauffeur {

	//données membre de la class
	private String mId;
	private String mNom;
	private String mPrenom;
	private String mAnneEmbauche;
	private String mAdresse;
	private List<CTrajet> mLstTrajet;
	
	//constructor class CChauffeur
	public CChauffeur(String _nom, String _prenom, String _adresse, String _anneEmbauche){
		
		this.mNom = _nom;
		this.mPrenom = _prenom;
		this.mAnneEmbauche = _anneEmbauche;
		this.mAdresse = _adresse;
		
		//construction du ID selon les informations recus.
		this.mId = mNom.substring(0,3) + mPrenom.substring(0,1) + mAnneEmbauche.substring(2, 4) ;
		
		this.mLstTrajet = new ArrayList<CTrajet>();
		
	}
	
	public String GetNomComplet(){
		String NomComplet = mPrenom + " " + mNom;
		return NomComplet;
	}
	
	public String AfficherInformationChauffeur(){
		
		return mId + " : " + this.GetNomComplet() + " : " + mAdresse + " : " + mAnneEmbauche;
	}
	
	//ajoute un trajet a la liste des trajets
	public void AjouterTrajet(CTrajet _Trajet){
		mLstTrajet.add(_Trajet);
	}
	
	//Affiche l'instance du chauffeur retourne une string
	public String ToString(){
		return "Chauffeur ID: " + mId ;
	}
}
