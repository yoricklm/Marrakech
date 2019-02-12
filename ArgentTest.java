import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.lang.Math;
import java.util.Random;

/**
*	La classe ArgentTest gere le test unitaire de la classe Argent.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/

public class ArgentTest {
	/**
	*	Methode de test du paiement de la dime.
	*   Verifie si le total d'argent des joueurs correspond à 120 (4 joueurs).
	**/
	@Test
	public void testArgent() {
		Joueur[] joueurs = new Joueur[4];
		joueurs[0] = new Joueur('R', 10);
		joueurs[1] = new Joueur('B', 10);
		joueurs[2] = new Joueur('V', 10);
		joueurs[3] = new Joueur('J', 10);

		Random random = new Random();

		int la, ca, indice_tour, indice_joueur_paye, argent_total = 0, nb_dimes;
		Cases[][] cases = new Cases[7][7];

		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				cases[i][j] = new Cases('X');
			}
		}



		for (int j = 0; j < 1000000; j++) {
			la = random.nextInt(7);
			ca = random.nextInt(7);
			nb_dimes = random.nextInt(30);
			indice_tour = random.nextInt(4);
			indice_joueur_paye = random.nextInt(4);
			
			for (int i = 0; i < nb_dimes+1; i++) {
				cases[la][ca].payerDime(joueurs[indice_tour], joueurs[indice_joueur_paye]);
			}
			

			for (int i = 0; i < 4; i++) {
				argent_total += joueurs[i].getArgent();
				//System.out.print(joueurs[i].getArgent() + "    ");
			}
			/*System.out.println("");

			System.out.println("Argent total = " + argent_total);
			System.out.println("");*/
			assertEquals(120, argent_total);
			argent_total = 0;
		}
	}
}