
public class CLimousine {
	
	private String mMatriculation;
	private int mCapaciteReservoir;
	private int mNbPassager;
	private int mKilometrage;
	private String mCouleur;

	//constructor class CLimousine
	public CLimousine(String _matricule, String _couleur, int _nbPassager, int _capaciteReservoir, int _kilometrage){
		
		this.mMatriculation = _matricule;
		this.mCouleur = _couleur;
		this.mNbPassager = _nbPassager;
		this.mCapaciteReservoir = _capaciteReservoir;
		this.mKilometrage = _kilometrage;
		
	}
	
	//--------------------------------- get --------------------------------------
	public int GetNombrePassager(){
		return mNbPassager;
	}
	
	public int GetKilometrageAct(){
		return mKilometrage;
	}
	
	//Affiche les informations de l'instance CLimousine
	public String ToString(){
		return "Limousine #" + mMatriculation + " " + mCouleur + " " + mNbPassager + " Passager(s) " + mCapaciteReservoir + "L " + mKilometrage +  "KM";
	}
}
