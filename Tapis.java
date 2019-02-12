/**
*	La classe Tapis est une classe qui gère les tapis.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/

public class Tapis {
	/**
	*	Tableau representant le plateau de jeu.
	*	
	**/
	private Cases[][] cases;
	/**
	*	Constructeur de la classe.
	*	@param le plateau de jeu
	**/
	public Tapis(Cases[][] cases) {
		this.cases = cases;
	}
	/**
	*	Methode permettant de poser un tapis en fonction de ses coordonnees et de sa couleur.
	*	@param coordonnee de la case pour poser le tapis et la couleur du tapis 
	**/
	public void poserTapis(int y, int x, char l) {
		cases[y][x].setLettre(l);
	}
	/**
	*	Methode renvoyant la couleur du tapis se trouvant sur une case.
	*	@param coordonnee de la case dont on veut recuperer la couleur du tapis
	*	@return la couleur du tapis
	**/
	public char getCaseLettre(int y, int x) {
		return cases[y][x].getLettre();
	}


	
}