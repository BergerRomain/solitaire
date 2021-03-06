package solitaire;

import java.util.*;

public class Jeu 
{
	private ArrayList<Paquet> liste = new ArrayList<Paquet>();
	private ArrayList<Pile> piles = new ArrayList<Pile>();
	private Paquet paquet1 = new Paquet();
	private Paquet paquet2 = new Paquet();
	private Paquet paquet3 = new Paquet();
	private Paquet paquet4 = new Paquet();
	private Paquet paquet5 = new Paquet();
	private Paquet paquet6 = new Paquet();
	private Paquet paquet7 = new Paquet();
	private Pile pile1 = new Pile();
	private Pile pile2 = new Pile();
	private Pile pile3 = new Pile();
	private Pile pile4 = new Pile();	

	
	public void affichePaquets()
	{
		for(int i=0;i<liste.size();i++)
			System.out.println("Paquet"+(i+1)+" :"+liste.get(i));
	}
	
	public void affichePiles()
	{
		for(int i=0;i<piles.size();i++)
			System.out.println("Pile"+(i+1)+" :"+piles.get(i));
	}
	
	public void remplirCartePaquet(Pioche pioche,Paquet paquet)
	{
		Random r = new Random();
		int valeur = 0 + r.nextInt(pioche.size());
		paquet.add(pioche.get(valeur));
		pioche.remove(valeur);
	}
	
	public void remplirPaquets(Pioche pioche) //La pioche doit �tre remplie
	{
		for(int i=0;i<liste.size();i++)
		{
			for(int y=0;y<i+1;y++)
				remplirCartePaquet(pioche,liste.get(i));
			(liste.get(i)).get((liste.get(i)).size()-1).cache=true;
		}
	}
	
	public boolean verifDeplacer(Carte carte1, Carte carte2)
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

	public boolean verifPile(Carte carte1, int numpile)
	{
		Pile pile = piles.get(numpile);
		if(pile.size() == 0)
		{
			if(carte1.getNum() == 1)
				return true;
		}
		else if(carte1.getNum() == (pile.get(pile.size()-1)).getNum()+1 && carte1.getTypeCouleur() == (pile.get(pile.size()-1)).getTypeCouleur())
			return true;
		return false;
	}
	
	public boolean conditiongagner()
	{
		int a=0;
		for(int i=0;i<7;i++)
		{
			if(liste.get(i).isEmpty())
				a++;		
		}
		if(a==7)
		{
			System.out.println("Bien jou� !");
			return false;
		}
		return true;
	}
	
	public void deplacerCarte() //paquet1 est la pioche dans laquelle la carte va aller dans pioche2
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez le 1er paquet : ");
		int num = sc.nextInt()-1;
		paquet1 = liste.get(num);
		if(num>=0 && num <=6 && liste.get(num).size()>0)
		{
			System.out.println("Choisissez le 2�me paquet : ");
			num = sc.nextInt()-1;
			paquet2 = liste.get(num);
			if(num>=0 && num <=6)
			{
				System.out.println("Donnez le nombre de cartes � d�placer : ");
				int numcarte = sc.nextInt();
				Carte derniereCarte1 = paquet1.get(paquet1.size()-1);
				Carte derniereCarte2 = paquet1.get(paquet1.size()-1);
				for(int i=0;i<numcarte;i++)
				{
					if(paquet2.size()>0)
						derniereCarte2 = paquet2.get(paquet2.size()-1);
					derniereCarte1 = paquet1.get(paquet1.size()-numcarte+i);
					if(paquet2.size()==0)
					{
						if(derniereCarte1.getNum()==13)
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
							System.out.println("D�placement impossible !");
							
					}
					else if(verifDeplacer(derniereCarte1,derniereCarte2))
					{
						derniereCarte2 = paquet2.get(paquet2.size()-1);
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
						System.out.println("D�placement impossible !");
				}
			}
			else
				System.out.println("Entre 1 et 7 !");
		}
		else
			System.out.println("Entre 1 et 7 ou paquet vide !");
	}
	
	public void deplacerPioche(Pioche pioche, int curseur)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("A quel numero de paquet voulez-vous l'ajouter ? (1-7)");
		int numpaquet = sc.nextInt()-1;
		if(numpaquet>=0 && numpaquet <=6)
		{
			if(liste.get(numpaquet).size() == 0)
			{
				if(pioche.get(curseur).getNum() == 13)
				{
					pioche.get(curseur).cache=true;
					liste.get(numpaquet).add(pioche.get(curseur));
					pioche.remove(curseur);
				}
				else
					System.out.println("D�placement impossible !");
			}
			else if(verifDeplacer(pioche.get(curseur),(liste.get(numpaquet)).get(liste.get(numpaquet).size()-1)))
			{
				pioche.get(curseur).cache=true;
				liste.get(numpaquet).add(pioche.get(curseur));
				pioche.remove(curseur);
			}
			else
				System.out.println("D�placement impossible !");
		}
		System.out.println("Entre 1 et 7 !");
	}
	
	public void ajouterPile(Pioche pioche,int curseur)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Num�ro de la pile : (1-4)");
		int numpile = sc.nextInt()-1;
		if(numpile>=0 && numpile <=3)
		{
			Pile pile = piles.get(numpile);
			System.out.println("Voulez-vous d�placer une carte :\n-1 De la pioche\n-2 D'un paquet");
			switch(sc.nextInt())
			{
				case 1:
					if(verifPile(pioche.get(curseur),numpile))
					{
						pioche.get(curseur).cache=true;
						pile.add(pioche.get(curseur));
						pioche.remove(curseur);
					}
					else
						System.out.println("D�placement impossible !");
				break;
				case 2:
					System.out.println("Num�ro du paquet de la carte � d�placer : (1-7)");
					int numpaquet = sc.nextInt()-1;
					if(numpaquet>=0 && numpaquet <=6)
					{
						Paquet paquet = liste.get(numpaquet);
						if(verifPile(paquet.get(paquet.size()-1),numpile))
						{
							if(paquet.size()>1)
							{
								Carte avantDerniereCarte1 = paquet.get(paquet.size()-2);
								if(avantDerniereCarte1.cache==false)
								avantDerniereCarte1.cache=true;
							}
							pile.add(paquet.get(paquet.size()-1));
							paquet.remove(paquet.size()-1);
						}
						else
							System.out.println("D�placement impossible !");
						break;
					}
					else
						System.out.println("Entre 1 et 7 !");
			}
		}
		else
			System.out.println("Entre 1 et 4 !");
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
		jeu.piles.add(jeu.pile1);
		jeu.piles.add(jeu.pile2);
		jeu.piles.add(jeu.pile3);
		jeu.piles.add(jeu.pile4);
		pioche.remplirPioche(pioche);
		jeu.remplirPaquets(pioche);
		jeu.affichePaquets();
		jeu.affichePiles();
		pioche.affichePioche(pioche, curseur);
		int choix;
		while(jeu.conditiongagner())
		{
			try 
			{
				System.out.println("\nQue voulez-vous faire ?\n-1 Piocher\n-2 D�placer\n-3 Ajouter une carte depuis la pioche\n-4 Ajouter une carte � une pile");
				choix = sc.nextInt();
				switch(choix)
				{
				case 1:
						
					if(curseur == pioche.size()-1)
						curseur = 0;
					else
						curseur ++;
				break;
				case 2:
					jeu.deplacerCarte();
				break;
				case 3:
					jeu.deplacerPioche(pioche,curseur);
					if(curseur == pioche.size())
						curseur = 0;
				break;
				case 4:
					jeu.ajouterPile(pioche, curseur);
					if(curseur == pioche.size())
						curseur = 0;
				break;
				}
				jeu.affichePaquets();
				jeu.affichePiles();
				pioche.affichePioche(pioche, curseur);
			}
			catch(InputMismatchException | NullPointerException | IndexOutOfBoundsException | IllegalArgumentException e)
			{
				System.out.println("Erreur ! "+e);
				sc.next();
			}
		}
	}
}
