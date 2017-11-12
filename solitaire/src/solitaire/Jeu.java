package solitaire;

import java.util.*;

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
			for(int y=1;y<=13;y++)
			{
				Carte carte = new Carte(y,a,false);
				pioche.add(carte);
			}
		}
		Collections.shuffle(pioche);
	}
	
	
	public void affichePioche(Pioche pioche)
	{
		System.out.println("Pioche :");
		for(int i=0;i<pioche.size();i++)
		{
			if(pioche.get(i).cache==false)
				System.out.println("caché");
			else
				System.out.println(pioche.get(i));
		}
		System.out.println("");
	}
	
	public void affichePaquet(Paquet paquet)
	{
		for(int i=0;i<paquet.size();i++)
		{
			if(paquet.get(i).cache==false)
				System.out.println("caché");
			else
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
			listePaquets[i].get(listePaquets[i].size()-1).cache=true;
		}
	}
	
	public Boolean verifDeplacer(Carte carte1, Carte carte2)
	{
		if(carte1.getNum() == carte2.getNum()-1)
		{
			if(carte1.getTypeCouleur()=="rouge" && carte2.getTypeCouleur() == "noir")
				return true;
			if(carte1.getTypeCouleur()=="noir" && carte2.getTypeCouleur() == "rouge")
				return true;
		}
		return false;
	}
	
	public void deplacerCarte(Paquet paquet1, Paquet paquet2) //paquet1 est la pioche dans laquelle la carte va aller dans pioche2
	{
		Carte derniereCarte1 = paquet1.get(paquet1.size()-1);
		Carte avantDerniereCarte1 = paquet1.get(paquet1.size()-2);
		Carte derniereCarte2 = paquet2.get(paquet2.size()-1);
		if(verifDeplacer(derniereCarte1,derniereCarte2))
		{
			if(paquet1.size()>1 && avantDerniereCarte1.cache==false)
				avantDerniereCarte1.cache=true;
			paquet2.add(derniereCarte1);
			paquet1.remove(derniereCarte1);
		}
		else
			System.out.println("Déplacement impossible !");
	}
	
	public static void main(String[] args)
	{
		Jeu jeu = new Jeu();
		Pioche pioche=new Pioche();
		Scanner sc = new Scanner(System.in);
		jeu.remplirPioche(pioche);
		jeu.remplirPaquets(pioche);
		jeu.affichePaquets();
		System.out.println("Que voulez-vous faire ?\n-1 Piocher\n-2 Déplacer");
		int choix = sc.nextInt();
		switch(choix)
		{
		case 1:
			System.out.println("Pas implémenté :(");
		break;
		case 2:
			System.out.println("Choisissez ");
		break;
		}
		jeu.deplacerCarte(jeu.paquet2, jeu.paquet3);
		System.out.println(choix);
	}
}
