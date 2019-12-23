public class Recherche {
    private Case find(int x,int y,Plateau plateau,int cote){
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
    public Case findTop(Case positionActuelle,Plateau plateau){
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
    public Case findBot(Case positionActuelle,Plateau plateau){
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
    public Case findRight(Case positionActuelle,Plateau plateau){
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
    public Case findLeft(Case positionActuelle,Plateau plateau){
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
    public Case findTopLeft(Case positionActuelle,Plateau plateau){
        Case tmpCase=findTop(positionActuelle,plateau);
        tmpCase=findLeft(tmpCase,plateau);
        return tmpCase;
    }
    public Case findTopRight(Case positionActuelle,Plateau plateau){
        Case tmpCase=findTop(positionActuelle,plateau);
        tmpCase=findRight(tmpCase,plateau);
        return tmpCase;
    }
    public Case findBotLeft(Case positionActuelle,Plateau plateau){
        Case tmpCase=findBot(positionActuelle,plateau);
        tmpCase=findLeft(tmpCase,plateau);
        return tmpCase;
    }
    public Case findBotRight(Case positionActuelle,Plateau plateau){
        Case tmpCase=findBot(positionActuelle,plateau);
        tmpCase=findRight(tmpCase,plateau);
        return tmpCase;
    }
}
