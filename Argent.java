/**
*	La classe Argent est une classe qui gère l'argent du joueur.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/


import java.util.*;

public class Argent {
	/**
	*
	*		L'argent de base que possede le joueur
	*
	**/
	private int argent_defaut;
	/**
	*
	*		L'argent que possede le joueur en temps reel
	*
	**/
	private int argent;
	/**
	*
	*		Historique des echanges d'argent
	*
	**/
	List<Integer> listeargent = new ArrayList<Integer>();
	/**
	*
	*		Historique de l'argent du joueur
	*
	**/
	List<Integer> listeargent_save = new ArrayList<Integer>();
	/**
	*
	*		Constructeur de la classe qui attribut l'argent par defaut
	*
	**/
	public Argent() {
		argent_defaut = 30;
		argent = 30;
	}
	/**
	*
	*		Methode qui renvoie le nombre de dirham que possede le joueur
	*		@return le nombre de dirham
	*
	**/
	public int getArgent() {
		return this.argent;
	}
	/**
	*
	*		Methode qui attribut de l'argent au joueur
	*		@param argent est le nombre de dirham à attribuer
	*
	**/
	public void setArgent(int argent) {
		this.argent = argent;
		this.listeargent.add(argent);
		//System.out.println(listeargent.get(0));
	}
	/**
	*
	*		Methode de retour
	*
	**/
	public void undo() {
		if (listeargent.size() == 0) {
			this.argent=argent_defaut;
		}
		else {
			listeargent_save.add(listeargent.get(listeargent.size()-1));
			listeargent.remove(listeargent.size()-1);

			
			if (listeargent.size() == 0) {
				this.argent=argent_defaut;
				//System.out.println(this.argent);
			}
			else {
				this.argent=listeargent.get(listeargent.size()-1);
			}
			
		}
	}
}