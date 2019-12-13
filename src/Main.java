public class Main {
	public static void main(String[] args) {
		//Test LOIC
		int cote=3;
		Case[][] tableauCase = new Case[cote][cote];
		Case tmpCase;
		for(int i=0; i<cote; i++)
		{
			for(int j=0; j<cote; j++)
			{
				int x=i;
				int y=j;
				tmpCase = new Case(2, false, null, x, y);
				tableauCase[i][j]=tmpCase;
			}
		}
		Plateau plateau=new Plateau(cote,tableauCase);
		plateau.affichage();

	}
	
	
}
