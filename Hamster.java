public class Hamster {
    private String name;
    private int x, y; //current x and y coordinate
    private char currentDirection;
    private int movingX; //moving left = -1, moving right = 1, otherwise 0
    private int movingY; //moving up = -1, moving down = 1, otherwise 0
    private int foodCollected;

    //initiate hamster at 3|6
    public Hamster(String name) {
        setName(name);
        setX(3);
        setY(6);
        setCurrentDirection('<');
    }


    public void turnLeft() {
        switch (getCurrentDirection()) {
            case '<':
                setCurrentDirection('v');
                break;
            case '^':
                setCurrentDirection('<');
                break;
            case '>':
                setCurrentDirection('^');
                break;
            case 'v':
                setCurrentDirection('>');
                break;
            default:
                System.out.println("setCurrentDirection OOB! Breaking . . .");
                System.exit(-1);
        }
    }

    public void turnRight() {
        switch (getCurrentDirection()) {
            case '<':
                setCurrentDirection('^');
                break;
            case '^':
                setCurrentDirection('>');
                break;
            case '>':
                setCurrentDirection('v');
                break;
            case 'v':
                setCurrentDirection('<');
                break;
            default:
                System.out.println("setCurrentDirection OOB! Breaking . . .");
                System.exit(-1);
        }
    }

    //getters & setters

    public int getFoodCollected(){
        return foodCollected;
    }

    public void setFoodCollected(int foodCollected){
        this.foodCollected = foodCollected;
    }

    public void collectedFood(){
        foodCollected++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.equals(""))
            this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if ((x <= Map.MAX_X) && (x >= 0)) {
            this.x = x;
        } else {
            System.out.println("Error: Trying to set X Variable outside OOB!.");
            System.exit(-1);
        }
        ;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if ((y <= Map.MAX_Y) && (y >= 0)) {
            this.y = y;
        } else {
            System.out.println("Error: Trying to set Y Variable OOB!.");
            System.exit(-1);
        }
        ;
    }

    public char getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(char currentDirection) {

        //the grid starts top left with x = 0 && y = 0;
        switch (currentDirection) {
            case '<':
                setMovingX(-1);
                setMovingY(0);
                break;
            case '^':
                setMovingX(0);
                setMovingY(-1);
                break;
            case '>':
                setMovingX(1);
                setMovingY(0);
                break;
            case 'v':
                setMovingX(0);
                setMovingY(1);
                break;
            default:
                System.out.println("OOB CurrentDirection. Breaking . . . ");
                System.exit(-1);
        }
        this.currentDirection = currentDirection;
    }

    public int getMovingX() {
        return movingX;
    }

    public void setMovingX(int movingX) {
        if (movingX >= -1 && movingX <= 1) {
            this.movingX = movingX;
        } else {
            System.out.println("setMovingX OOB! Breaking . . .");
            System.exit(-1);
        }
    }

    public int getMovingY() {
        return movingY;
    }

    public void setMovingY(int movingY) {
        if (movingY >= -1 && movingY <= 1) {
            this.movingY = movingY;
        } else {
            System.out.println("setMovingY OOB! Breaking . . .");
            System.exit(-1);
        }
    }
}
