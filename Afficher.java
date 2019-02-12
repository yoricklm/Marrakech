/**
*	La classe Afficher est la classe qui permet d'afficher l'etat du plateau de jeu
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/


import java.io.*;
import java.lang.String;

public class Afficher{
	/**
	*	Constructeur de la classe.
	*	
	**/
	public Afficher(){}
	
	/**
	*	Methode qui va afficher l'etat du plateau de jeu.
	*	@param le plateau de jeu et Assam
	**/
	public void afficher(Plateau plateau,Assam pa){
		int xa = pa.getXA();
		int ya = pa.getYA();
		char c;
		Cases[][] p = plateau.getPlateau();
		for(int i=0;i<7;i++){
			for(int j=0 ;j<7;j++){
				if(xa==i && ya==j){
					c=p[i][j].getLettre();
					if(c=='R'){
						System.out.print("\u001B[31mA\033[0m ");
					}
					if(c=='B'){
						System.out.print("\u001B[34mA\033[0m ");
					}
					if(c=='V'){
						System.out.print("\u001B[32mA\033[0m ");
					}
					if(c=='J'){
						System.out.print("\u001B[33mA\033[0m ");
					}
					if(c=='X'){
						System.out.print("A ");
					}
				}else{
					c=p[i][j].getLettre();
					if(c=='R'){
						System.out.print("\u001B[31m"+c+"\033[0m ");
					}
					if(c=='B'){
						System.out.print("\u001B[34m"+c+"\033[0m ");
					}
					if(c=='V'){
						System.out.print("\u001B[32m"+c+"\033[0m ");
					}
					if(c=='J'){
						System.out.print("\u001B[33m"+c+"\033[0m ");
					}
					if(c=='X'){
						System.out.print(c+" ");
					}
				}
				if(j==6){
					System.out.println(" ");
					System.out.println(" ");
				}
			}
		}
		System.out.println(" ");
		System.out.println(" ");
	}
	
	/**
	*	Methode qui va predefinir les choix de position de Tapis.
	*	@param le Lecteur et Assam
	*	@return un tableau de int indiquant les positions du choix dans le tapis.
	**/
	public int[] demanderTapis(Lecture lecteur, Assam a){
		int[] couple = new int[2];
		int[][] couples = new int [4][2];
		int choix;
		int y=a.getXA();
		int x=a.getYA();
		int[] xa=new int[4],ya =new int[4];
		int possible=0;
		xa[0]=x;
		xa[1]=x+1;
		xa[2]=x;
		xa[3]=x-1;
		
		
		ya[0]=y-1;
		ya[1]=y;
		ya[2]=y+1;
		ya[3]=y;
		for(int i=0;i<4;i++){
			if((xa[i]>=0&& xa[i]<7 ) && (ya[i]>=0&&ya[i]<7)){
				couples[possible][0]=xa[i];
				couples[possible][1]=ya[i];
				possible+=1;
				System.out.println("le choix numéro "+possible+" est:  ("+(1+couples[possible-1][0])+","+(1+couples[possible-1][1])+")");
			}
		}
		
		choix=lecteur.lectureTapis(possible);	
		System.out.println(choix);
		couple[0]=couples[choix-1][0];
		couple[1]=couples[choix-1][1];
		
		return couple;
		
	}
}