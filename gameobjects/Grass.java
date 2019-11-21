package gameobjects;

public class Grass extends GameObject {
    public Grass() {
        super(' ', true);
    }
    public char getSymbol(){
        return symbol;
    }
}
