import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String args[]) throws Exception {
		CCompagnie CO = new CCompagnie();
		CChauffeur Chauffeur1 = new CChauffeur("Francis","Marsolais","725 Duhamel","2017");
		Chauffeur1.ToString();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("S'il vous plaît entrez ville d'arrivée:\n\t");
		String entre = in.readLine();
		System.out.print(entre + " est votre choix!");
	}
	
}
