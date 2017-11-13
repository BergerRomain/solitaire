package solitaire;

public class Carte
{
	private int num;
	private String couleur;
	Boolean cache;
	
	public String toString()
	{
		if(getCache())
		{
			String numstring = ""+getNum()+"";
			switch(getNum()) 
			{
				case 1:
					numstring="as de";
				break;
				case 11:
					numstring="valet de";
				break;
				case 12:
					numstring="dame de";
				break;
				case 13:
					numstring="roi de";
				break;
			}
			return numstring+" "+getCouleur();
		}
		else
			return "caché";
	}
	
	public Carte(int num, String couleur,Boolean cache)
	{
		this.setNum(num);
		this.setCouleur(couleur);
		this.cache=cache;
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

	public Boolean getCache()
	{
		return cache;
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