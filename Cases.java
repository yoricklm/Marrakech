/**
*	La classe Cases gère les cases du plateau de jeu.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/


import java.util.*;


public class Cases {
	/**
	*
	*		La lettre qui correspond à la couleur du joueur qui est sur la case.
	*
	**/
	private char lettre;
	/**
	*
	*		Historique de tous les tapis qui ont été posé sur la case.
	*
	**/
	List<Character> listetapis = new ArrayList<Character>();
	/**
	*
	*		Historique des tapis ayant été retirés (undo).
	*
	**/
	List<Character> listetapis_save = new ArrayList<Character>();
	/**
	*
	*		Constructeur de la classe case
	* 		@param la lettre du joueur qui est sur la case
	*
	**/
	public Cases(char l) {
		this.lettre = l;
	}
	/**
	*
	*		Accesseur en lecture qui retourne la couleur du joueur posé sur la case
	* 		@return charactère correspondant à la couleur du joueur
	*
	**/
	public char getLettre() {
		return lettre;
	}
	/**
	*
	*		Accesseur en écriture qui permet d'associé la couleur d'un joueur à une case
	* 		@param la lettre du joueur à placer sur la case
	*
	**/
	public void setLettre(char c){
		this.lettre=c;
		listetapis.add(c);
	}
	/**
	*
	*		Methode qui renvoie le dernier tapis posé sur la case
	* 		@return le dernier tapis posé sur la case
	*
	**/
	public char getLastTapis() {
		if (listetapis.size() == 0) {
			return 'X';
		}
		return listetapis.get(listetapis.size()-2);
	}


	public void debug() {
		//System.out.println(listetapis.size());
		for(int i=0;i<listetapis.size();i++){
		    System.out.println(listetapis.get(i));
		} 
	}
	/**
	*
	*		Methode qui permet de payer la dime 
	* 		@param le joueur qui donne la dime, le joueur qui recoit la dile
	*		@return vrai ou faux si le joueur n'a pas assez d'argent
	*
	**/
	public void payerDime(Joueur jperd, Joueur jgagne) {		
		jperd.donnerArgent();
		jgagne.recevoirArgent();
	}
	/**
	*
	*		Methode qui retire le dernier tapis de la case (undo)
	*
	**/
	public void undo() {
		if (listetapis.size() == 0) {
			this.lettre='X';
		}
		else {
			listetapis_save.add(listetapis.get(listetapis.size()-1));
			listetapis.remove(listetapis.size()-1);

			if (listetapis.size() == 0) {
				this.lettre='X';
			}
			else {
				this.lettre=listetapis.get(listetapis.size()-1);
			}
			
		}
		
	}


}