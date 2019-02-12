/**
*	La classe Assam est la classe qui gere le personnage d'Assam.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/


import java.io.*;

public class Assam {
	
	/**
	*	Le tableau contenant X et Y qui sont les coordonnées d'Assam 
	*	
	**/
	private int[] pa;
	
	/**
	*	Le caractere définnissant la direction du déplacement d'Assam dans le plateau
	*	
	**/
	private char direction;
	
	/**
	*	Le tableau qui contient les 4 directions cardinales afin de faciliter les comparaisons lors de la recuperation
	*	
	**/
	private char[] cardinal = {'N','E','S','O'};
	
	/**
	*	Constructeur de la classe.
	*
	**/
	public Assam(){ 
		this.pa = new int[2];
		this.pa[0] = 3;
		this.pa[1] = 3;
		this.direction=cardinal[0];
	}
	
	/**
	*	Methode renvoyant la position X d'Assam.
	*	@return la position selon X d'Assam
	*
	**/
	public int getXA(){
		return this.pa[0];
	}
	
	/**
	*	Methode renvoyant la position Y d'Assam.
	*	@return la position selon Y d'Assam
	*
	**/
	public int getYA(){
		return this.pa[1];
	}
	
	/**
	*	Methode permettant de modifier la position X d'Assam
	*	@param un int pour la coordonnee
	*	
	**/
	public void setXA(int a){
		this.pa[0] = a;
	}
	
	/**
	*	Methode permettant de modifier la position Y d'Assam
	*	@param un int pour la coordonnee
	*	
	**/
	public void setYA(int b){
		this.pa[1] = b;
	}
	
	/**
	*	Methode qui retourne en fonction de la diretion actuelle d'Assam l'indice correspondant dans le tableau cardinal
	* 	necessaire pour setDirection().
	*	@return la couleur du tapis
	*
	**/
	public  int getCardinal(){
		int i=0;
		for(int indice=0;indice<4;indice++ ){
			if(this.direction==this.cardinal[indice]){
				i=indice;
			}
		}
		return i;
	}
	
	/**
	*	Méthode qui gère le changement de direction d'Assam
	*   @param le lecteur qui gere les acces a l'entree standard
	*
	**/
	public void setDirection(Lecture lecteur){
		int ii=getCardinal();
		this.direction=lecteur.lectureOrientation(cardinal,ii);
	}
	
	/**
	*	Méthode qui va déplacer Assam d'un nombre de case sur le plateau en fonction du lancé de dé et de la direction d'Assam
	*   @param un int pour de deplacement de Assam dans le direction desiree par le joueur.
	*
	**/
	public void deplacement(int n){
		System.out.println(n);
		if(this.direction == 'N' ){
			for(int i=0;i<n;i++){
				this.pa[0] = this.pa[0] - 1;
				if(this.pa[0] == -1) this.pa[0]=6;
			}
		}else if(this.direction == 'S' ){
			for(int i=0;i<n;i++){
				this.pa[0] = this.pa[0] + 1;
				if(this.pa[0] == 7) this.pa[0]=0;
			}
		}else if(this.direction == 'O' ){
			for(int i=0;i<n;i++){
				this.pa[1] = this.pa[1] - 1;
				if(this.pa[1] == -1) this.pa[1]=6;
			}
		}else if(this.direction == 'E' ){
			for(int i=0;i<n;i++){
				this.pa[1] = this.pa[1] + 1;
				if(this.pa[1] == 7) this.pa[1]=0;
			}
		}
	}
}