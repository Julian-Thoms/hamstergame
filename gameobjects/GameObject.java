package gameobjects;

public abstract class GameObject {
    char symbol;
    boolean walkable;

    public GameObject(char symbol, boolean walkable) {
        this.symbol = symbol;
        this.walkable = walkable;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isWalkable() {
        return walkable;
    }
}
