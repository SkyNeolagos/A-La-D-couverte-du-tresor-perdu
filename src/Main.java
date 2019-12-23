public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		Case testCase = new Case(2, true, null, 3, 4);
		testCase.affichage();
		System.out.println();

		//Test LOIC
		System.out.println("-------------------");
		System.out.println("-----Test Loic-----");
        Case[][] tableauCase=new Case[5][5];
        int cote=5;
		Plateau plateau=new Plateau(cote,tableauCase);
        plateau.setTableauCase(plateau.generatePlateauWithoutItem(cote));
        plateau.affichage();
        System.out.println("-------------------");
	}
	
	
}
