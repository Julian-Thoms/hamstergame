import gameobjects.Food;
import gameobjects.*;

public class Map {
    static final int MAX_X = 11;
    static final int MAX_Y = 8;
    Wall wall = new Wall();
    Grass grass = new Grass();
    Food food = new Food();
    private int foodAmount;
    private char[][] layout;

    //initialize map
    public Map(){
        foodAmount = 6;
        layout = new char[MAX_X][MAX_Y];
        layout[0][0] = wall.getSymbol();
        layout[1][0] = wall.getSymbol();
        layout[2][0] = wall.getSymbol();
        layout[3][0] = wall.getSymbol();
        layout[4][0] = wall.getSymbol();
        layout[5][0] = wall.getSymbol();
        layout[6][0] = wall.getSymbol();
        layout[7][0] = wall.getSymbol();
        layout[8][0] = wall.getSymbol();
        layout[9][0] = wall.getSymbol();
        layout[10][0] = wall.getSymbol();

        layout[0][1] = wall.getSymbol();
        layout[1][1] = grass.getSymbol();
        layout[2][1] = grass.getSymbol();
        layout[3][1] = grass.getSymbol();
        layout[4][1] = grass.getSymbol();
        layout[5][1] = grass.getSymbol();
        layout[6][1] = food.getSymbol();
        layout[7][1] = grass.getSymbol();
        layout[8][1] = grass.getSymbol();
        layout[9][1] = grass.getSymbol();
        layout[10][1] = wall.getSymbol();

        layout[0][2] = wall.getSymbol();
        layout[1][2] = grass.getSymbol();
        layout[2][2] = grass.getSymbol();
        layout[3][2] = grass.getSymbol();
        layout[4][2] = wall.getSymbol();
        layout[5][2] = grass.getSymbol();
        layout[6][2] = grass.getSymbol();
        layout[7][2] = grass.getSymbol();
        layout[8][2] = food.getSymbol();
        layout[9][2] = grass.getSymbol();
        layout[10][2] = wall.getSymbol();

        layout[0][3] = wall.getSymbol();
        layout[1][3] = grass.getSymbol();
        layout[2][3] = grass.getSymbol();
        layout[3][3] = grass.getSymbol();
        layout[4][3] = food.getSymbol();
        layout[5][3] = wall.getSymbol();
        layout[6][3] = grass.getSymbol();
        layout[7][3] = grass.getSymbol();
        layout[8][3] = grass.getSymbol();
        layout[9][3] = grass.getSymbol();
        layout[10][3] = wall.getSymbol();

        layout[0][4] = wall.getSymbol();
        layout[1][4] = grass.getSymbol();
        layout[2][4] = grass.getSymbol();
        layout[3][4] = grass.getSymbol();
        layout[4][4] = food.getSymbol();
        layout[5][4] = grass.getSymbol();
        layout[6][4] = grass.getSymbol();
        layout[7][4] = wall.getSymbol();
        layout[8][4] = wall.getSymbol();
        layout[9][4] = grass.getSymbol();
        layout[10][4] = wall.getSymbol();

        layout[0][5] = wall.getSymbol();
        layout[1][5] = grass.getSymbol();
        layout[2][5] = food.getSymbol();
        layout[3][5] = grass.getSymbol();
        layout[4][5] = grass.getSymbol();
        layout[5][5] = wall.getSymbol();
        layout[6][5] = food.getSymbol();
        layout[7][5] = grass.getSymbol();
        layout[8][5] = grass.getSymbol();
        layout[9][5] = grass.getSymbol();
        layout[10][5] = wall.getSymbol();

        layout[0][6] = wall.getSymbol();
        layout[1][6] = grass.getSymbol();
        layout[2][6] = grass.getSymbol();
        layout[3][6] = '<';
        layout[4][6] = grass.getSymbol();
        layout[5][6] = wall.getSymbol();
        layout[6][6] = grass.getSymbol();
        layout[7][6] = grass.getSymbol();
        layout[8][6] = grass.getSymbol();
        layout[9][6] = grass.getSymbol();
        layout[10][6] = wall.getSymbol();

        layout[0][7] = wall.getSymbol();
        layout[1][7] = wall.getSymbol();
        layout[2][7] = wall.getSymbol();
        layout[3][7] = wall.getSymbol();
        layout[4][7] = wall.getSymbol();
        layout[5][7] = wall.getSymbol();
        layout[6][7] = wall.getSymbol();
        layout[7][7] = wall.getSymbol();
        layout[8][7] = wall.getSymbol();
        layout[9][7] = wall.getSymbol();
        layout[10][7] = wall.getSymbol();

    }

    public void printMap() {
        int i = 0, j = 0;

        while (j < MAX_Y) {
            while (i < MAX_X) {
                System.out.print(layout[i][j]);
                i++;
            }
            i = 0;
            j++;
            System.out.print("\n");
        }
    }


    public char[][] getLayout() {
        return layout;
    }

    public void setLayout(int x, int y, char c) {
        layout[x][y] = c;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
    public char getFood() { return food.getSymbol(); }
    public char getGrass() { return grass.getSymbol();}
    public char getWall() {
        return wall.getSymbol();
    }

    }
