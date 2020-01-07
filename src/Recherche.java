import java.util.ArrayList;

public class Recherche {
    protected Case find(int x,int y,Plateau plateau,int cote){
        if((x<0 || y<0) || (x>cote || y>cote)){
            return null;
        }
        else{
            for (int i = 0; i < cote; i++) {
                for (int j = 0; j < cote ; j++) {
                    Case tmpCase=plateau.getTableauCase()[i][j];
                    if(tmpCase!=null) {
                        if (tmpCase.getX() == x && tmpCase.getY() == y) {
                            return tmpCase;
                        }
                    }
                }
            }
            return null;
        }
    }
    protected Case findTop(Case positionActuelle,Plateau plateau){
        int cote=plateau.getCote();
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX()-1;
            int tmpY=positionActuelle.getY();
            if(tmpX<0 || tmpX >cote){
                return null;
            }
            else{
                return find(tmpX,tmpY,plateau,cote);
            }
        }
        return null;
    }
    protected Case findBot(Case positionActuelle,Plateau plateau){
        int cote=plateau.getCote();
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX()+1;
            int tmpY=positionActuelle.getY();
            if(tmpX<0 || tmpX >cote){
                return null;
            }
            else{
                return find(tmpX,tmpY,plateau,cote);
            }
        }
        return null;
    }
    protected Case findRight(Case positionActuelle,Plateau plateau){
        int cote=plateau.getCote();
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX();
            int tmpY=positionActuelle.getY()+1;
            if(tmpY<0 || tmpY >cote){
                return null;
            }
            else{
                return find(tmpX,tmpY,plateau,cote);
            }
        }
        return null;
    }
    protected Case findLeft(Case positionActuelle,Plateau plateau){
        int cote=plateau.getCote();
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX();
            int tmpY=positionActuelle.getY()-1;
            if(tmpY<0 || tmpY >cote){
                return null;
            }
            else{
                return find(tmpX,tmpY,plateau,cote);
            }
        }
        return null;
    }
    protected Case findTopLeft(Case positionActuelle,Plateau plateau){
        Case tmpCase=findTop(positionActuelle,plateau);
        tmpCase=findLeft(tmpCase,plateau);
        return tmpCase;
    }
    protected Case findTopRight(Case positionActuelle,Plateau plateau){
        Case tmpCase=findTop(positionActuelle,plateau);
        tmpCase=findRight(tmpCase,plateau);
        return tmpCase;
    }
    protected Case findBotLeft(Case positionActuelle,Plateau plateau){
        Case tmpCase=findBot(positionActuelle,plateau);
        tmpCase=findLeft(tmpCase,plateau);
        return tmpCase;
    }
    protected Case findBotRight(Case positionActuelle,Plateau plateau){
        Case tmpCase=findBot(positionActuelle,plateau);
        tmpCase=findRight(tmpCase,plateau);
        return tmpCase;
    }
    protected ArrayList<Case> findAllNbCase(Case positionActuelle, Plateau plateau, int nbCaseAuTour) {
    	Case tmpRechercheCase = positionActuelle;
    	ArrayList<Case> tabCasePositionEnnemi = new ArrayList<Case>(); 		
		for (int i = -nbCaseAuTour; i <= nbCaseAuTour; i++) {
			for (int j = -nbCaseAuTour; j <= nbCaseAuTour; j++) {
				tmpRechercheCase = findCase(positionActuelle, plateau, i, j);
				Case tmpIfEnnemi = ifEnnemiReturnCase(tmpRechercheCase, positionActuelle);
				if (tmpIfEnnemi != null) tabCasePositionEnnemi.add(tmpIfEnnemi);
			}
		}
		return tabCasePositionEnnemi;
	}
    protected Case findCase(Case positionActuelle,Plateau plateau, int x, int y){
        int cote=plateau.getCote();
        if(positionActuelle!=null){
            int tmpX=positionActuelle.getX()+x;
            int tmpY=positionActuelle.getY()+y;
            if(tmpX<0 || tmpX >cote){
                return null;
            }
            else{
                return find(tmpX,tmpY,plateau,cote);
            }
        }
        return null;
    }
    protected Case ifEnnemiReturnCase(Case position, Case RechercheAPartirDe) {
    	Case base = RechercheAPartirDe;
    	Case tmp = position;
    	if(RechercheAPartirDe.getPersonnage() instanceof Corsaire && position.getPersonnage() instanceof Pirate) {
    		return tmp;
    	}
    	else if (RechercheAPartirDe.getPersonnage() instanceof Flibustier && position.getPersonnage() instanceof Corsaire) {
			return tmp;
		}
    	return null;
	}
}
