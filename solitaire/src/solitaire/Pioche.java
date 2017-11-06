package solitaire;

import java.util.ArrayList;

public class Pioche extends ArrayList<Carte>
{
	public static void remplirPioche(Pioche pioche)
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
			for(int y=1;y<=10;y++)
			{
				String num=Integer.toString(y);
				Carte carte = new Carte(num,a);
				pioche.add(carte);
			}
			Carte carte = new Carte("valet",a);
			pioche.add(carte);
			Carte carte2 = new Carte("dame",a);
			pioche.add(carte2);
			Carte carte3 = new Carte("roi",a);
			pioche.add(carte3);
		}
	}
	
	public static void affichePioche(Pioche pioche)
	{
		for(int i=0;i<pioche.size();i++)
		{
			System.out.println(pioche.get(i));
		}
	}

	public static void main(String[] args)
	{
		Pioche pioche = new Pioche();
		remplirPioche(pioche);
		affichePioche(pioche);
	}
	
}

