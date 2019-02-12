/**
*	La classe Joueur est une classe qui gère les actions du joueur.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/

public class Joueur {
	/**
	*	Couleur du joueur.
	*	
	**/
	private char couleur;
	/**
	*	Nombre de tapis que possede le joueur.
	*	
	**/
	private int nb_tapis;
	/**
	*	Nombre de dirham que possede le joueur.
	*	
	**/
	private int argentJoueur;
	/**
	*	Attribut representant la banque.
	*	
	**/
	private Argent monnaie;
	/**
	*	Constructeur de la classe.
	*	@param la couleur qu'aura le joueur et son nombre de tapis.
	**/
	public Joueur(char couleur, int nb_tapis) {
		this.couleur = couleur;
		monnaie = new Argent();
		argentJoueur = monnaie.getArgent();
		this.nb_tapis = nb_tapis;
	}
	/**
	*	Methode qui renvoie la couleur du joueur.
	*	@return la couleur du joueur
	**/
	public char getCouleur() {
		return this.couleur;
	}
	
	/**
	*	Methode qui attribut un nombre de tapis au joueur.
	*	@param le nombre de tapis a attribuer
	**/
	public void setNb_tapis(int tapis) {
		this.nb_tapis = tapis;
	}
	/**
	*	Methode qui renvoie le nombre de tapis du joueur.
	*	@return le nombre de tapis du joueur
	**/
	public int getNb_tapis() {
		return this.nb_tapis;
	}
	/**
	*	Methode qui decremente le nombre de tapis du joueur lorsque qu'il en pose un.
	*
	**/
	public void jouerTapis(){
		this.nb_tapis--;
	}

	/**
	*	Methode qui decremente l'argent du joueur.
	*
	**/
	public void donnerArgent() {
		argentJoueur--;
		monnaie.setArgent(argentJoueur);
	}
	/**
	*	Methode qui incremente l'argent du joueur.
	*
	**/
	public void recevoirArgent() {
		argentJoueur++;
		monnaie.setArgent(argentJoueur);
	}
	/**
	*	Actualisation de l'argent.
	*
	**/
	public void setArgent() {
		this.argentJoueur = monnaie.getArgent();
	}
	/**
	*	Methode qui renvoie le nombre de dirham du joueur.
	*	@return le nombre de dirham du joueur
	**/
	public int getArgent() {
		return argentJoueur;
	}
	/**
	*	Methode qui annule la derniere entree/perte d'argent.
	*	
	**/
	public void undoArgent() {
		monnaie.undo();
		setArgent();
	}
}