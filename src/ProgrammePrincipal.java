import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProgrammePrincipal 
{
	public static void main(String args[]) throws IException
	{
		final int FIN = 4;
		String entrée = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Compagnie comp = new Compagnie();
		
		do
		{
			try 
			{
				System.out.print("\n\n1. Faire la réservation d’une limousine\n");
				System.out.print("2. Trouver toutes les limousines conduites par un chauffeur\n");
				System.out.print("3. D’afficher toutes les trajets effectués\n");
				System.out.print("4. Sortie\n");
				System.out.print("Sélectionnez une option:\n\t:");
				
				entrée = in.readLine();
				
				//Réservation d’une limousine
				if(Integer.parseInt(entrée) == 1)
				{
					String départ = null;
					String arrivée = null;
					System.out.print("S'il vous plaît entrez ville de départ:\n\t");
					entrée = in.readLine();
					départ = entrée;
					
					System.out.print("S'il vous plaît entrez ville d'arrivée:\n\t");
					entrée = in.readLine();
					arrivée = entrée;
					
					comp.trouveLimou(départ, arrivée);
					entrée = "-1";
				}
				//Trouver toutes les limousines conduites par un chauffeur 
				else if(Integer.parseInt(entrée) == 2)
				{
					System.out.print("S'il vous plaît entrez le nom d'un chauffeur:\n\t");
					entrée = in.readLine();
					comp.limouChauffeur(entrée);
					entrée = "-1";
				}
				//D’afficher toutes les caractéristiques des trajets
				else if(Integer.parseInt(entrée) == 3)
				{
					comp.afficherToutesTrajets();
				}
				//Sortie
				else if(Integer.parseInt(entrée) == 4);
				else
				{
					System.out.println("S'il vous plaît sélectionner une option valable");
					throw new IException();
					
				}
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			catch(NumberFormatException e)
			{
				System.out.println();
				System.out.println("Entrez un numéro s'il vous plaît");
				entrée = "-1";
			}
			catch(IException e)
			{
				
			} 
		}while(!(Integer.parseInt(entrée) == FIN));	
	}
}
