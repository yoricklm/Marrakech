/**
*	La classe Plateau est la classe qui genere le plateau de jeu.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/


public class Plateau{
	/**
	*	Le tableau définissant l'interface de jeu 7 par 7 soit 49 cases.
	*	
	**/
	private Cases[][] plat;// tableau définissant l'interface de jeu 7 par 7 soit 49 cases.
	
	/**
	*	Constructeur de la classe.
	*	a noter que le 'X' represente la non presence d'un tapis
	**/
	public Plateau(){
		this.plat = new Cases[7][7];
		char c ='X';
		for(int i=0;i<7;i++){
			for(int j=0 ;j<7;j++){
				this.plat[i][j]= new Cases(c);
			}
		}
	}
	
	/**
	*	Methode qui renvoie le tableau representant le tableau
	*	@return un tableau de cases a deux dimensions
	**/
	public Cases[][] getPlateau(){
		return this.plat;
	}
}