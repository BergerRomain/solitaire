package solitaire;

import java.util.ArrayList;
import java.util.Collections;

public class Pioche extends ArrayList<Carte>
{
	public void remplirPioche(Pioche pioche)
	{
		String a = "";
		for(int i=0;i<4;i++)
		{
			if(i==0)
				a="coeur";
			if(i==1)
				a="carreau";
			if(i==2)
				a="trefle";
			if(i==3)
				a="pique";
			for(int y=1;y<=13;y++)
			{
				Carte carte = new Carte(y,a,false);
				pioche.add(carte);
			}
		}
		Collections.shuffle(pioche);
	}
	
	public void affichePioche(Pioche pioche, int curseur)
	{
		pioche.get(curseur).cache=true;
		System.out.println("Pioche : "+pioche.get(curseur));
		pioche.get(curseur).cache=false;
	}
}

