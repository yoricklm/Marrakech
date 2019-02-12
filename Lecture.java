/**
*	La classe Lecture est la classe qui gere les communications avec les joueurs par entree et sorties standard.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/


import java.io.*;

public class Lecture{
	
	/**
	*	L'attribut permettant la lecture de l'entree standard.
	*	
	**/
	private InputStreamReader isr;
	
	/**
	*	L'attribut qui va lire dans l'entree standard.
	*	
	**/
	private BufferedReader br;
	
	/**
	*	Constructeur de la classe.
	*	
	**/
	public Lecture(){
		isr = new InputStreamReader(System.in);
		br=new BufferedReader(isr);	
	}
	
	/**
	*	Methode qui va lire l'orientation desiree par le joueur
	*	@param le tableau des points cardinaux et un int indiquant quel est la position actuelle d'Assam
	*	car Assam n'a pas le droit de faire demi-tour.
	*	@return un char pour la nouvelle orientation.
	**/
	public char lectureOrientation(char[] cardinal,int ii){
		String a = new String();
		char orientation='A';
		int i=ii-1;
		int iii=ii+1;
		if(ii==0) i=3;
		if(ii==3) iii=0;
		System.out.println("Direction cardinal actuelle d'Assam: "+cardinal[ii]);
		while(orientation!=cardinal[ii] && orientation!=cardinal[i] && orientation!=cardinal[iii]){
			System.out.print("Direction cardinal d'Assam (N ou S ou E ou O): ");
			try{
				a=this.br.readLine();
				orientation=a.charAt(0);
				
			}catch(IOException e){
				System.out.println("Erreur de lecture !");
			}
		}
		return orientation;
		
	}
	
	/**
	*	Methode qui va demander a l'utilisateur le nombre de joueur desire entre 2 et 4
	*	@return le nombre de joueur pour la partie
	**/
	public int getNBJoueur(){
		int nbjoueur=0;
		while(nbjoueur<2 || nbjoueur>4){
			System.out.println("Entrez le nombre de joueur: ");
			try{
				String a=this.br.readLine();
				try{
					nbjoueur=Integer.parseInt(a);
				}
				catch(NumberFormatException e){
					System.out.println("Ce n'est pas un entier !");
				}
				
			}
			catch(IOException e){
				System.out.println("Erreur de lecture ! (nombre de joueur) " + e );
				System.exit(-1);
			}
		}
		return nbjoueur;
	}
	
	/**
	*	Methode qui va demander a l'utilisateur a quel endroit il veut placer son tapis autour d'Assam en fonction des choix proposes.
	*	@param un int disant le nombre de choix possible
	*	@return un int indiquant le choix voulu pour placer le tapis
	**/
	public int lectureTapis(int possible){
		String a =new String();
		a="";
		int choix=0;
		try{
			while(choix<1 || choix>possible){
				System.out.print("Donner le placement de votre Tapis: ");
				a=this.br.readLine();
				try{
					choix=Integer.parseInt(a);
				}
				catch(NumberFormatException e){
					System.out.println("Ce n'est pas un entier !");
				}
				
			}
		}catch(IOException e){
			System.out.println("Erreur de lecture ! (demanderTapis) " + e );
			System.exit(-1);
		}
		
		return choix;
	}
	
	/**
	*	Methode qui va fermer les flux permettant les acces a l'entree et la sortie standard
	*	
	**/
	public void fermeture(){
		try{
			this.br.close();
			this.isr.close();
		}catch (IOException e){
			System.out.println("Erreur de fermeture !");
		}
	}
}