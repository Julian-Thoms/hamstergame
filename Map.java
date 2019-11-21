import gameobjects.Food;
import gameobjects.*;
import res.ConsoleColors;

public class Map {
    static public final int MAX_X = 11;
    static public final int MAX_Y = 8;
    private Wall wall;
    private Grass grass;
    private Food food;
    private int foodAmount;
    private GameObject[][] layout;
    Hamster h1;

    //initialize map
    public Map(Hamster h1) {
        wall = new Wall();
        grass = new Grass();
        food = new Food();
        this.h1 = h1;
        foodAmount = 6;
        layout = new GameObject[MAX_X][MAX_Y];
        layout[0][0] = wall;
        layout[1][0] = wall;
        layout[2][0] = wall;
        layout[3][0] = wall;
        layout[4][0] = wall;
        layout[5][0] = wall;
        layout[6][0] = wall;
        layout[7][0] = wall;
        layout[8][0] = wall;
        layout[9][0] = wall;
        layout[10][0] = wall;

        layout[0][1] = wall;
        layout[1][1] = grass;
        layout[2][1] = grass;
        layout[3][1] = grass;
        layout[4][1] = grass;
        layout[5][1] = grass;
        layout[6][1] = food;
        layout[7][1] = grass;
        layout[8][1] = grass;
        layout[9][1] = grass;
        layout[10][1] = wall;

        layout[0][2] = wall;
        layout[1][2] = grass;
        layout[2][2] = grass;
        layout[3][2] = grass;
        layout[4][2] = wall;
        layout[5][2] = grass;
        layout[6][2] = grass;
        layout[7][2] = grass;
        layout[8][2] = food;
        layout[9][2] = grass;
        layout[10][2] = wall;

        layout[0][3] = wall;
        layout[1][3] = grass;
        layout[2][3] = grass;
        layout[3][3] = grass;
        layout[4][3] = food;
        layout[5][3] = wall;
        layout[6][3] = grass;
        layout[7][3] = grass;
        layout[8][3] = grass;
        layout[9][3] = grass;
        layout[10][3] = wall;

        layout[0][4] = wall;
        layout[1][4] = grass;
        layout[2][4] = grass;
        layout[3][4] = grass;
        layout[4][4] = food;
        layout[5][4] = grass;
        layout[6][4] = grass;
        layout[7][4] = wall;
        layout[8][4] = wall;
        layout[9][4] = grass;
        layout[10][4] = wall;

        layout[0][5] = wall;
        layout[1][5] = grass;
        layout[2][5] = food;
        layout[3][5] = grass;
        layout[4][5] = grass;
        layout[5][5] = wall;
        layout[6][5] = food;
        layout[7][5] = grass;
        layout[8][5] = grass;
        layout[9][5] = grass;
        layout[10][5] = wall;

        layout[0][6] = wall;
        layout[1][6] = grass;
        layout[2][6] = grass;
        layout[3][6] = h1;
        layout[4][6] = grass;
        layout[5][6] = wall;
        layout[6][6] = grass;
        layout[7][6] = grass;
        layout[8][6] = grass;
        layout[9][6] = grass;
        layout[10][6] = wall;

        layout[0][7] = wall;
        layout[1][7] = wall;
        layout[2][7] = wall;
        layout[3][7] = wall;
        layout[4][7] = wall;
        layout[5][7] = wall;
        layout[6][7] = wall;
        layout[7][7] = wall;
        layout[8][7] = wall;
        layout[9][7] = wall;
        layout[10][7] = wall;

    }

    public void printMap() {
        int i = 0, j = 0;

        while (j < MAX_Y) {
            while (i < MAX_X) {
                if (layout[i][j].equals(wall)) {
                    System.out.print(ConsoleColors.BLACK_BOLD_BRIGHT + layout[i][j].getSymbol());
                } else if (layout[i][j].equals(food)) {
                    System.out.print(ConsoleColors.GREEN_BOLD + layout[i][j].getSymbol());
                } else if (layout[i][j].equals(h1)) {
                    System.out.print(ConsoleColors.RED_BOLD + layout[i][j].getSymbol());
                } else {
                    System.out.print(layout[i][j].getSymbol());
                }
                i++;
            }
            i = 0;
            j++;
            System.out.print("\n");
        }
        System.out.print(ConsoleColors.RESET); //resets color of console after map drawn
    }

    public GameObject[][] getLayout() {
        return layout;
    }

    public void setLayout(int x, int y, GameObject g) {
        layout[x][y] = g;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public Food getFood() {
        return food;
    }

    public Grass getGrass() {
        return grass;
    }

    public Wall getWall() {
        return wall;
    }
}
