import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String args[]) throws Exception {
		
		CCompagnie CO = new CCompagnie();
		
		CChauffeur Chauffeur1 = new CChauffeur("Francis","Marsolais","725 Duhamel","2017");
		CLimousine Limousine1 = new CLimousine("Y22 ESN", "Noir", 8, 60, 120000);
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
			System.out.println("4: Consulter les trajets.");
			
			System.out.print("Choix : ->");
			String entre = in.readLine();
			
			if(Integer.parseInt(entre) == 1){
				System.out.println("-------------------------");
				System.out.println("Que desirez vous ajouter ?");
				System.out.println("1: Un chauffeur");
				System.out.println("2: Une limousine");
				
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
					int kilometrageAct = 0;
					
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
					
					//demande et enregistre le kilometrage
					System.out.print("Kilometrage Actuel : ");
					entre = in.readLine();
					kilometrageAct = Integer.parseInt(entre);
					
					//creation de la limousine
					CLimousine NLimousine = new CLimousine(matriculation,couleur,nbPassager,reservoir,kilometrageAct);
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
				
				//variables
				String villeDepart = "";
				String villeDestination = "";
				int distance = 0;
				int passager = 0;
				CLimousine limousine = null;
				
				//creation d'un nouveau trajet
				System.out.println("Réservation d'une limousine");
				System.out.println("***************************");
				
				System.out.println("Ville de départ :");
				System.out.print("-> ");
				villeDepart = in.readLine();
				
				System.out.println("Ville de destination :");
				System.out.print("-> ");
				villeDestination = in.readLine();
				
				System.out.println("Distance à parcourir :");
				System.out.print("-> ");
				distance = Integer.parseInt(in.readLine());
				
				System.out.println("Nombre de passager :");
				System.out.print("-> ");
				passager = Integer.parseInt(in.readLine());
				
				limousine = CO.GetLimousineRandomFromNbPassager(passager);
				
				int kiloDebut = limousine.GetKilometrageAct();
				int kiloFin = kiloDebut + distance;
				
				//création du trajet
				CTrajet NTrajet = new CTrajet(villeDepart,villeDestination,kiloDebut, kiloFin, limousine);
				
				//creation de la reservation
				CReservation NReservation = new CReservation(CO.GetChauffeurRandom(), NTrajet, limousine);
				
				
				//demande de confirmation et enregistrement
				System.out.print("La réservation " + NReservation.toString() + " va être effectué! voulez-vous poursuivre?Y/N :");
				String reponse = in.readLine();
				if( reponse.toUpperCase().equals("Y")){
					CO.AddReservation(NReservation);
					
					NReservation.GetLimousine().AjouterKilometrage(distance); //ajoute la distance parcourue 
					
					System.out.println("*************************************");
					System.out.println("*!!Votre reservation est confirmé !!*");
					System.out.println("*************************************");
				}
				
				
				System.out.print("Appuyer sur entrer ...");
				in.readLine();
				
			}
			//---------------------------------------------------------------------------- OPTION 3 -------------
			else if(Integer.parseInt(entre) == 3){ //afficher les chauffeurs
				System.out.println("Voici la liste des chauffeurs :");
				int i = 0;
				for(CChauffeur CC : CO.GetAllChauffeur()){
					System.out.println(i++ + ": " + CC.AfficherInformationChauffeur());
					CLimousine[] tbl =  CO.GetLimousinesSelonChauffeur(CC);
					if(tbl.length>0){
						for(CLimousine LL : tbl){
							System.out.println("     -" + LL.ToString());
						}
					}
					else{
						System.out.println("     Aucune limousine.");
					}
				}
				System.out.print("Appuyer sur entrer ...");
				in.readLine();
			}
			//---------------------------------------------------------------------------------- option 4 ----------
			else if(Integer.parseInt(entre) == 4){
				System.out.println("Voici la liste des trajets :");
				for(CTrajet TT : CO.GetAllTrajets()){
					System.out.println("-" + TT.ToString());
				}
				System.out.print("Appuyer sur entrer ...");
				in.readLine();
			}
			else{
				System.out.println("Choix non valide");
			}
			System.out.println("-------------------------");
		}
	}
	
}
