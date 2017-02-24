import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String args[]) throws Exception {
		
		CCompagnie CO = new CCompagnie();
		
		CChauffeur Chauffeur1 = new CChauffeur("Francis","Marsolais","725 Duhamel","2017");
		CLimousine Limousine1 = new CLimousine("Y22 ESN", "Noir", 8, 60);
		CTrajet Trajet1 = new CTrajet("Mascouche", "Terrebonne", 12000, 12030, Limousine1);
		CReservation Reservation1 = new CReservation(Chauffeur1, Trajet1, Limousine1);
		
		CO.AddChauffeur(Chauffeur1);
		CO.AddLimousine(Limousine1);
		CO.AddReservation(Reservation1);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){ //boucle du logiciels
			System.out.println("Veuillez choisir une des option suivante :");
			System.out.println("1: Ajouter des chauffeurs ou limousines.");
			System.out.println("2: Faire une reservation.");
			System.out.println("3: Consulter les chauffeurs.");
			
			System.out.print("Choix : ->");
			String entre = in.readLine();
			
			if(Integer.parseInt(entre) == 1){
				System.out.println("-------------------------");
				System.out.println("Que desirez vous ajouter ?");
				System.out.println("1: Un chauffeur");
				System.out.println("2: Une limousine");
				System.out.println("3: Annuler");
				
				System.out.print("Choix : ->");
				entre = in.readLine();
				
				//ajout d'un nouveau chauffeur
				if(Integer.parseInt(entre) == 1){
					
					//initialisation des valeurs 
					String prenom = "";
					String nom = "";
					String adresse = "";
					String annee = "";
					
					System.out.println("-------------------------");
					
					//demande et enregistre le prenom
					System.out.print("Prénom: ");
					entre = in.readLine();
					prenom = entre;
					
					//demande et enregistre le nom
					System.out.print("Nom: ");
					entre = in.readLine();
					nom = entre;
					
					//demande et enregistre ladresse
					System.out.print("Adresse: ");
					entre = in.readLine();
					adresse = entre;
					
					//demande et enregistre lannee dembauche
					System.out.print("Année embauche: ");
					entre = in.readLine();
					annee = entre;
					
					//creation du chauffeur
					CChauffeur NChauffeur = new CChauffeur(prenom,nom,adresse,annee);
					//demande de confirmation et enregistrement
					System.out.print("Le chauffeur " + NChauffeur.AfficherInformationChauffeur() + " va etre ajouter! voulez-vous poursuivre?Y/N :");
					String reponse = in.readLine();
					if( reponse.toUpperCase().equals("Y")){
						CO.AddChauffeur(NChauffeur);
						System.out.println("********************************");
						System.out.println("*!! Nouveau chauffeur ajouté !!*");
						System.out.println("********************************");
					}
				}
				else if(Integer.parseInt(entre) == 2){ //ajout d'une limousine
					//initialisation des valeurs 
					String matriculation = "";
					String couleur = "";
					int nbPassager = 0;
					int reservoir = 0;
					
					System.out.println("-------------------------");
					
					//demande et enregistre les matriculations
					System.out.print("Matriculation : ");
					entre = in.readLine();
					matriculation = entre;
					
					//demande et enregistre les matriculations
					System.out.print("Couleur : ");
					entre = in.readLine();
					couleur = entre;
					
					//demande et enregistre les matriculations
					System.out.print("Nombre de passager : ");
					entre = in.readLine();
					nbPassager = Integer.parseInt(entre);
					
					//demande et enregistre les matriculations
					System.out.print("Capacité réservoir : ");
					entre = in.readLine();
					reservoir = Integer.parseInt(entre);
					
					//creation de la limousine
					CLimousine NLimousine = new CLimousine(matriculation,couleur,nbPassager,reservoir);
					//demande de confirmation et enregistrement
					System.out.print("La limousine " + NLimousine.ToString() + " va etre ajouter! voulez-vous poursuivre?Y/N :");
					String reponse = in.readLine();
					if( reponse.toUpperCase().equals("Y")){
						CO.AddLimousine(NLimousine);
						System.out.println("**********************************");
						System.out.println("*!! Nouvelle limousine ajoutée !!*");
						System.out.println("**********************************");
					}
				}
			}
			else if(Integer.parseInt(entre) == 2){ //faire une reservation
				
			}
			//---------------------------------------------------------------------------- OPTION 3 -------------
			else if(Integer.parseInt(entre) == 3){ //afficher les chauffeurs
				System.out.println("Voici la liste des chauffeurs :");
				int i = 0;
				for(CChauffeur CC : CO.GetAllChauffeur()){
					System.out.println(i++ + ": " + CC.AfficherInformationChauffeur());
					CLimousine[] tbl =  CO.GetLimousinesSelonChauffeur(CC);
					for(CLimousine LL : tbl){
						System.out.println("     -" + LL.ToString());
					}
				}
			}
			else{
				System.out.println("Choix non valide");
			}
			System.out.println("-------------------------");
		}
	}
	
}
