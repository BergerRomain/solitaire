package solitaire;

import java.util.*;

public class Jeu 
{
	private ArrayList<Paquet> liste = new ArrayList<Paquet>();
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
	
	
	public void affichePioche(Pioche pioche, int curseur)
	{
		System.out.println("Pioche : "+pioche.get(curseur));
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
		for(int i=0;i<liste.size();i++)
		{
			System.out.println("Paquet"+(i+1)+":");
			affichePaquet(liste.get(i));
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
		for(int i=0;i<liste.size();i++)
		{
			for(int y=0;y<i+1;y++)
			{
				remplirCartePaquet(pioche,liste.get(i));
			}
			(liste.get(i)).get((liste.get(i)).size()-1).cache=true;
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
		Carte derniereCarte2 = paquet2.get(paquet2.size()-1);
		if(verifDeplacer(derniereCarte1,derniereCarte2))
		{
			if(paquet1.size()>1)
			{
				Carte avantDerniereCarte1 = paquet1.get(paquet1.size()-2);
				if(avantDerniereCarte1.cache==false)
				avantDerniereCarte1.cache=true;
			}
			paquet2.add(derniereCarte1);
			paquet1.remove(derniereCarte1);
		}
		else
			System.out.println("Déplacement impossible !");
	}
	
	public Paquet choixDeplacer1()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez le 1er paquet : ");
		return liste.get(sc.nextInt()-1);
	}
	
	public Paquet choixDeplacer2()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez le 2ème paquet : ");
		return liste.get(sc.nextInt()-1);
	}
	
	public void ajouterPioche(Pioche pioche, int curseur)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("A quel numero de paquet voulez-vous l'ajouter ? (1-7)");
		int numpaquet = sc.nextInt()-1;
		if(verifDeplacer(pioche.get(curseur),(liste.get(numpaquet)).get(liste.get(numpaquet).size()-1)))
		{
			pioche.get(curseur).cache=true;
			liste.get(numpaquet).add(pioche.get(curseur));
			pioche.remove(curseur);
		}
		else
			System.out.println("Déplacement impossible");
	}

	
	public static void main(String[] args)
	{
		int curseur = 0;
		Jeu jeu = new Jeu();
		Pioche pioche=new Pioche();
		Scanner sc = new Scanner(System.in);
		jeu.liste.add(jeu.paquet1);
		jeu.liste.add(jeu.paquet2);
		jeu.liste.add(jeu.paquet3);
		jeu.liste.add(jeu.paquet4);
		jeu.liste.add(jeu.paquet5);
		jeu.liste.add(jeu.paquet6);
		jeu.liste.add(jeu.paquet7);
		jeu.remplirPioche(pioche);
		jeu.remplirPaquets(pioche);
		jeu.affichePaquets();
		jeu.affichePioche(pioche, curseur);
		
		
		while(true)
		{
			System.out.println("\nQue voulez-vous faire ?\n-1 Piocher\n-2 Déplacer\n-3 Ajouter la carte depuis la pioche");
			int choix = sc.nextInt();
			switch(choix)
			{
			case 1:
				
				if(curseur == pioche.size()-1)
					curseur = 0;
				else
					curseur ++;
			break;
			case 2:
				jeu.deplacerCarte(jeu.choixDeplacer1(),jeu.choixDeplacer2());
			break;
			case 3:
				jeu.ajouterPioche(pioche,curseur);
				if(curseur == pioche.size()-1)
					curseur = 0;
			break;
			}
			jeu.affichePaquets();
			jeu.affichePioche(pioche, curseur);
		}
	}
}
