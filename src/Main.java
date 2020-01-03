public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		Case testCase = new Case(2, true, null, 3, 4);
		testCase.affichage();
		System.out.println();

		//Test LOIC

        Case[][] tableauCase;
        int cote=6;
		System.out.println("-------------------");
		System.out.println("-----Test Loic-----");
		Plateau plateau=new Plateau(cote);
		plateau.initialiser(4);
		plateau.affichage();
		System.out.println("-------------------");
		plateau.tourJoueur();
		System.out.println("-------------------");
	}
	
	
}
