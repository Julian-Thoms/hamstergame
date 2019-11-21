package gameobjects;

public class Food extends GameObject {
    public Food() {
        super('*', true);
    }
    public char getSymbol(){
        return symbol;
    }
}
