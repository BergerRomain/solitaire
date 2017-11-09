package solitaire;

public class Carte
{
	private int num;
	private String couleur;
	Boolean cache;
	
	public String toString()
	{
		String numstring = ""+getNum()+"";
		switch(getNum()) 
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
		return numstring+" "+getCouleur();
	}
	
	public Carte(int num, String couleur,Boolean cache)
	{
		this.setNum(num);
		this.setCouleur(couleur);
		this.cache=cache;
	}


	public static void main(String[] args)
	{
		Carte a = new Carte(1,"coeur",false);
		System.out.println(a.cache);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCouleur() {
		return couleur;
	}
	
	public String getTypeCouleur()
	{
		if(couleur == "coeur" || couleur == "carreau")
			return "rouge";
		else
			return "noir";
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
}