package solitaire;

public class Carte
{
	private String num;
	private String couleur;
	
	public String toString()
	{
		return num+" "+couleur;
	}
	
	public Carte(String num, String couleur)
	{
		this.num=num;
		this.couleur=couleur;
	}



	public static void main(String[] args)
	{
		Carte a = new Carte("1","Coeur");
		System.out.println(a);
	}
}