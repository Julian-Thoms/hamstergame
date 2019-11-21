package gameobjects;

import gameobjects.GameObject;

public class Wall extends GameObject {
    public Wall() {
        super('#', false);
    }
    public char getSymbol(){
        return symbol;
    }

}
