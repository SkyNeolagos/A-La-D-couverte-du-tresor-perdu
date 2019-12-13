public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		Case testCase = new Case(2, true, null, 3, 4);
		testCase.affichage();







		//Test LOIC
		int cote=3;
		Case[][] tableauCase = new Case[cote][cote];
		for(int i=0; i<cote; i++)
		{
			for(int j=0; j<cote; j++)
			{
				int x=i;
				int y=j;
				Case tmpCase = new Case(2, true, null, x, y);
				tableauCase[i][j]=tmpCase;
			}
		}

		Plateau plateau=new Plateau(cote,tableauCase);
		System.out.print(plateau.find(0,0)+"\n");
		System.out.print(plateau.find(0,1)+"\n");
	}
	
	
}
