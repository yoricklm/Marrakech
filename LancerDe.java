/**
*	La classe LancerDe est une classe qui gère le lance de de pour le deplacement d'Assam.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/


import java.lang.Math;
import java.util.Random;

public class LancerDe {
	/**
	*	Constructeur de la classe.
	*
	**/
	public LancerDe() {}
	
	/**
	*		Methode qui renvoie la valeur du de
	*		@return un int de la valeur du de.
	*
	**/
	public static int lancer() {
		int[] de = {1, 2, 2, 3, 3, 4};
		Random random = new Random();
		int n = random.nextInt(6);
		return de[n];
	}
}