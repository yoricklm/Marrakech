/**
*	La classe Controleur gere la majeur partie du jeu.
*	
*	@author David, Maxime, Yorick, Imane, Majdi
*	@version 0.11
**/

import java.util.Arrays;

public class Controleur {
	/**
	*	Le tableau qui contient les 4 couleurs de tapis possible pour les joueurs.
	*	
	**/
	char[] couleur= {'R','B','V','J'};
	
	/**
	*	L'attribut permet de définir la couleur de tapis en fonction du nombre de joueur
	*	
	**/
	int indice_couleur=0;
	
	/**
	*	L'attribut permet de définir quel joueur joue actuellement
	*	
	**/
	int indice_tour=0;
	
	/**
	*	L'attribut qui defini le nombre de joueurs dans la partie
	*	
	**/
	int nb_joueur=0;
	
	/**
	*	L'attribut qui defini le tour des joueurs
	*	
	**/
	int nb_tour=0;
	
	/**
	*	L'attribut de la classe Tapis qui sera utilise pour la pose des tapis
	*	
	**/
	private Tapis t;
	/**
	*	L'attribut de la classe Joueur et qui defini le joueur 1 afin de faciliter l'acces a celui-ci.
	*	
	**/
	private Joueur joueur1;
	
	/**
	*	L'attribut de la classe Joueur et qui defini le joueur 2 afin de faciliter l'acces a celui-ci.
	*	
	**/
	private Joueur joueur2;
	
	/**
	*	L'attribut de la classe Joueur et qui defini le joueur 3 afin de faciliter l'acces a celui-ci.
	*	
	**/
	private Joueur joueur3;
	
	/**
	*	L'attribut de la classe Joueur et qui defini le joueur 4 afin de faciliter l'acces a celui-ci.
	*	
	**/
	private Joueur joueur4;
	
	/**
	*	Le tableau du nombre de joueur afin de permettre des comparaisons pour payer la dîme.
	*	
	**/
	private Joueur[] joueurs;
	
	/**
	*	L'attribut de la classe Lecture qui va servir pour les lectures sur entree et sortie standard.
	*	
	**/
	private Lecture lecteur;
	
	
	/**
	*	Constructeur de la classe.
	*	Il contient l'initialisation des attributs et la creation du necessaire pour la partie.
	*	Il contient aussi la boucle qui permet à chaque joueur de jouer tour à tour.
	*
	**/
	public Controleur(){
		/* initialisation des attributs de la classe */ 
		Plateau plat = new Plateau();
		t = new Tapis(plat.getPlateau());
		lecteur = new Lecture();
		Assam a = new Assam();
		nb_joueur=lecteur.getNBJoueur();
		joueurs=new Joueur[nb_joueur];
		/* creation des variables suplementaires necessaires */
		int nbtapis=2;
		int la,ca,i;
		char couleur_tapis;
		char indice_tapis_joueuractuel;
		int indice_joueur_paye=0;
		Cases[][] p;
		/* ajout des joueurs */ 
		for(i=0; i<nb_joueur;i++){
			this.addJoueur(nbtapis);
		}
		/* affichage du plateau de jeu */
		Afficher afficheur = new Afficher();
		afficheur.afficher(plat,a);
		/* boucle qui va definir le tour d'un joueur */ 
		for(nb_tour=0;nb_tour<(nb_joueur*nbtapis);nb_tour++){
			/* deplacement d'assam */
			System.out.println("C'est le tour du joueur "+(indice_tour+1));
			a.setDirection(this.lecteur);
			a.deplacement(LancerDe.lancer());
			afficheur.afficher(plat,a);
			/* paye la dîme si necessaire */ 
			la=a.getYA();
			ca=a.getXA();
			couleur_tapis=t.getCaseLettre(ca,la);
			if(couleur_tapis!='X'){
				p = plat.getPlateau();
				indice_tapis_joueuractuel=joueurs[indice_tour].getCouleur();
				System.out.println(indice_tapis_joueuractuel);
				if(indice_tapis_joueuractuel != couleur_tapis ){
					for(i=0;i<4;i++){
						if(couleur[i]==couleur_tapis){
								indice_joueur_paye=i;
						}
					}
					System.out.println("joueur qui paye = j"+(indice_tour+1));
					System.out.println("joueur payé = j"+(indice_joueur_paye+1));
					System.out.println((la+1)+","+(ca+1));
					p[la][ca].payerDime(joueurs[indice_tour], joueurs[indice_joueur_paye]);
					System.out.println("Dime payée - joueur "+(indice_tour+1)+" : " + joueurs[indice_tour].getArgent() + " - joueur "+(indice_joueur_paye+1)+" : " + joueurs[indice_joueur_paye].getArgent());
				}
			}
			/* ajoute un tapis sur le plateau de jeu */ 
			int[] cords= new int[2];
			cords = afficheur.demanderTapis(this.lecteur,a);
			this.poseTapis(cords);
			afficheur.afficher(plat,a);
			this.indice_tour+=1;
			this.indice_tour=this.indice_tour%this.nb_joueur;
		}
		/* fin de la partie et determination du gagnant */
		
		

		/* affichage du gagnant et fermeture du flux d'entree standard */
		System.out.println("Le gagnant est le joueur "+(finPartie()[0]+1));
		lecteur.fermeture();
	}


	public int[] finPartie(){
		int[] t= new int[nb_joueur];
		int[] trier= new int[nb_joueur];
		int[] classement= new int[nb_joueur];
		int nbtapis=0,jgagnant=0;
		for(int i=0;i<nb_joueur;i++){
			t[i]=comptageTapis(joueurs[i].getCouleur());
			if(t[i] > nbtapis){
				jgagnant=i;
				nbtapis=t[i];
			}
			
		}
		trier=t;
		Arrays.sort(trier);
		int x=0;
		for(int i=0;i<nb_joueur;i++){
			while(t[x]!=trier[i]){
				x++;
			}
			classement[i]=x;
			x=0;

		}

		/*int indice_joueur_gagne=0;
		int argent=joueur1.getArgent();
		
		for(int i=1;i<nb_joueur;i++){
			if(joueurs[i].getArgent() > argent ){
				indice_joueur_gagne=i;
				argent=joueurs[i].getArgent();
			}
		}*/

		return classement;
	}

	public int comptageTapis(char c){
		int res=0;
		for(int x=0;x<7;x++){
			for(int y=0;y<7;y++){
				if(t.getCaseLettre(x,y)==c)
					res++;
			}
		}
		return res;
	}
	/**
	*	Methode qui va ajouter un joueur 
	*	@param un int nbtapis afin de permettre d'uniformiser le nombre de tapis
	*
	**/
	public void addJoueur(int nbtapis){
		switch(indice_couleur){
			case 0:
				joueur1 = new Joueur(couleur[indice_couleur],nbtapis);
				joueurs[indice_couleur]=joueur1;
				this.indice_couleur++;
				break;
			case 1:
				joueur2 = new Joueur(couleur[indice_couleur],nbtapis);
				joueurs[indice_couleur]=joueur2;
				this.indice_couleur++;
				break;
			case 2:
				joueur3 = new Joueur(couleur[indice_couleur],nbtapis);
				joueurs[indice_couleur]=joueur3;
				this.indice_couleur++;
				break;
			case 3:
				joueur4 = new Joueur(couleur[indice_couleur],nbtapis);
				joueurs[indice_couleur]=joueur4;
				this.indice_couleur++;
				break;
		}
	}
	
	/**
	*	Methode qui va poser un tapis sur le plateau de jeu en fonction des coordonnees et de la couleur des tapis du joueur
	*	@param le couple de coordonnees de la position dans le plateau
	*	
	**/
	public void poseTapis(int[] cords){
		if(this.indice_tour==0){
			t.poserTapis(cords[1], cords[0], joueur1.getCouleur() );
			this.joueur1.jouerTapis();
		}else if(this.indice_tour==1){
			t.poserTapis(cords[1], cords[0], joueur2.getCouleur() );
			this.joueur2.jouerTapis();
		}else if (this.indice_tour==2){
			t.poserTapis(cords[1], cords[0], joueur3.getCouleur() );
			this.joueur3.jouerTapis();
		}else {
			t.poserTapis(cords[1], cords[0], joueur4.getCouleur() );
			this.joueur4.jouerTapis();
		}
	}
}