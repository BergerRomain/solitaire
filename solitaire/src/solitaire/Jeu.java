package solitaire;

import java.util.ArrayList;
import java.util.Random;

public class Jeu 
{
	private Paquet paquet1 = new Paquet();
	private Paquet paquet2 = new Paquet();
	private Paquet paquet3 = new Paquet();
	private Paquet paquet4 = new Paquet();
	private Paquet paquet5 = new Paquet();
	private Paquet paquet6 = new Paquet();
	private Paquet paquet7 = new Paquet();
	
	
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
	
	public void affichePioche(Pioche pioche)
	{
		System.out.println("Pioche :");
		for(int i=0;i<pioche.size();i++)
		{
			System.out.println(pioche.get(i));
		}
		System.out.println("");
	}
	
	public void affichePaquet(Paquet paquet)
	{
		for(int i=0;i<paquet.size();i++)
		{
			System.out.println(paquet.get(i));
		}
		System.out.println("");
	}
	
	public void affichePaquets()
	{
		Paquet listePaquets[] = {paquet1,paquet2,paquet3,paquet4,paquet5,paquet6,paquet7};
		for(int i=0;i<listePaquets.length;i++)
		{
			System.out.println("Paquet"+(i+1)+":");
			affichePaquet(listePaquets[i]);
		}
	}
	
	public void remplirCartePaquet(Pioche pioche,Paquet paquet)
	{
		Random r = new Random();
		int valeur = 0 + r.nextInt(pioche.size());
		paquet.add(pioche.get(valeur));
		pioche.remove(valeur);
	}
	
	public void remplirPaquets(Pioche pioche) //La pioche doit être remplie
	{
		Paquet listePaquets[] = {paquet1,paquet2,paquet3,paquet4,paquet5,paquet6,paquet7};
		for(int i=0;i<listePaquets.length;i++)
		{
			for(int y=0;y<i+1;y++)
			{
				remplirCartePaquet(pioche,listePaquets[i]);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Jeu jeu = new Jeu();
		Pioche pioche=new Pioche();
		jeu.remplirPioche(pioche);
		jeu.remplirPaquets(pioche);
		jeu.affichePioche(pioche);
		jeu.affichePaquets();
	}
}
