
public class CLimousine {
	
	private String mMatriculation;
	private int mCapaciteReservoir;
	private int mNbPassager;
	private String mCouleur;

	//constructor class CLimousine
	public CLimousine(String _matricule, String _couleur, int _nbPassager, int _capaciteReservoir){
		
		mMatriculation = _matricule;
		mCouleur = _couleur;
		mNbPassager = _nbPassager;
		mCapaciteReservoir = _capaciteReservoir;
		
	}
	
	//Affiche les informations de l'instance CLimousine
	public String ToString(){
		return "Limousine #imatriculation: " + mMatriculation + " de couleur " + mCouleur + " pouvant accueillir " + mNbPassager + " Passager(s) \n taille du réservoir :" + mCapaciteReservoir + "L.";
	}
}
