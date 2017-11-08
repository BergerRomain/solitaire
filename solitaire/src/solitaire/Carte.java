package solitaire;

public class Carte
{
	private int num;
	private String couleur;
	Boolean cache;
	
	public String toString()
	{
		String numstring = ""+num+"";
		switch(num) 
		{
			case 11:
				numstring="valet";
			break;
			case 12:
				numstring="dame";
			break;
			case 13:
				numstring="roi";
			break;
		}
		return numstring+" "+couleur;
	}
	
	public Carte(int num, String couleur,Boolean cache)
	{
		this.num=num;
		this.couleur=couleur;
		this.cache=cache;
	}



	public static void main(String[] args)
	{
		Carte a = new Carte(1,"Coeur",false);
		System.out.println(a.cache);
	}
}