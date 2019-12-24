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
		plateau.setCote(cote);
		plateau.setTableauCase(plateau.generatePlateauWithoutItem());
		plateau.generatePelleIntoPlateau(4);
		plateau.generateMachetteIntoPlateau(4);
		plateau.generateMousquetIntoPlateau(4);
		plateau.generateArmureIntoPlateau(4);
		plateau.affichage();
		System.out.println("-------------------");
		for (int i = 0; i <cote ; i++) {
			for (int j = 0; j <cote ; j++) {
				if(plateau.getTableauCase()[i][j].getItem()!=null){
					System.out.print(plateau.getTableauCase()[i][j].getItem().getType());
				}
				else{
					System.out.print(4);
				}
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	
}
