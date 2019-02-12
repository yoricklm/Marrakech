import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Demarrage2 {
	private static Cases[][] cases = new Cases[7][7];
	private static Cases[][] history = new Cases[7][7];
	public static void main(String[] args) throws IOException {
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				cases[i][j] = new Cases('X');
			}
		}

		int x=1, y=1;
		
		Joueur[] joueurs = new Joueur[2];
		
		joueurs[0] = new Joueur('R', 10);
		joueurs[1] = new Joueur('B', 10);
		//Joueur joueur3 = new Joueur('V', 10);
		//Joueur joueur4 = new Joueur('J', 10);

		String s;
		InputStreamReader isr;
		BufferedReader br;
		Tapis t = new Tapis(cases);

		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		
		for (int i = 1; i <= 2; i++) {
			System.out.print("Joueur " + i + " x: ");
			s = br.readLine();
			x = Integer.parseInt(s);
			System.out.print("Joueur " + i + " y: ");
			s = br.readLine();
			y = Integer.parseInt(s);
			
			x--;
			y--;
			
			t.poserTapis(y, x, joueurs[i-1].getCouleur());
		}


		/*if (cases[y][x].payerDime(joueurs[0], joueurs[1])) {
			System.out.println("Dime payée - joueur 1 : " + joueurs[0].getArgent() + " - joueur 2 : " + joueurs[1].getArgent());

			
		}*/

		/*if (cases[y][x].payerDime(joueurs[0], joueurs[1])) {
			System.out.println("Dime payée - joueur 1 : " + joueurs[0].getArgent() + " - joueur 2 : " + joueurs[1].getArgent());

			
		}*/

		/*joueurs[0].undoArgent();
		joueurs[1].undoArgent();
		System.out.println("joueur 1 : " + joueurs[0].getArgent() + " - joueur 2 : " + joueurs[1].getArgent());
		
		cases[1][1].debug();
		cases[1][1].undo();
		cases[1][1].undo();
		cases[1][1].debug();*/
		//System.out.println(cases[1][1].getLastTapis());
		
		
		//char c = t.getCaseLettre(2, 2);
		//System.out.println(c);



		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(t.getCaseLettre(i, j) + " ");
			}
			System.out.println("");
		}
		
		
		/*int de_lance = LancerDe.lancer();
		System.out.println(de_lance);*/
		
	}
}