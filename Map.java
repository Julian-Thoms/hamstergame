public class Map {
    static final int MAX_X = 11;
    static final int MAX_Y = 8;

    private int foodAmount;

    private String food = ConsoleColors.GREEN + "*" + ConsoleColors.RESET;
    private String wall = ConsoleColors.BLACK_BRIGHT + "#" + ConsoleColors.RESET;

    private String[][] layout;

    //initialize map
    public Map(){
        foodAmount = 6;
        layout = new String[MAX_X][MAX_Y];
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
        layout[1][1] = " ";
        layout[2][1] = " ";
        layout[3][1] = " ";
        layout[4][1] = " ";
        layout[5][1] = " ";
        layout[6][1] = food;
        layout[7][1] = " ";
        layout[8][1] = " ";
        layout[9][1] = " ";
        layout[10][1] = wall;

        layout[0][2] = wall;
        layout[1][2] = " ";
        layout[2][2] = " ";
        layout[3][2] = " ";
        layout[4][2] = wall;
        layout[5][2] = " ";
        layout[6][2] = " ";
        layout[7][2] = " ";
        layout[8][2] = food;
        layout[9][2] = " ";
        layout[10][2] = wall;

        layout[0][3] = wall;
        layout[1][3] = " ";
        layout[2][3] = " ";
        layout[3][3] = " ";
        layout[4][3] = food;
        layout[5][3] = wall;
        layout[6][3] = " ";
        layout[7][3] = " ";
        layout[8][3] = " ";
        layout[9][3] = " ";
        layout[10][3] = wall;

        layout[0][4] = wall;
        layout[1][4] = " ";
        layout[2][4] = " ";
        layout[3][4] = " ";
        layout[4][4] = food;
        layout[5][4] = " ";
        layout[6][4] = " ";
        layout[7][4] = wall;
        layout[8][4] = wall;
        layout[9][4] = " ";
        layout[10][4] = wall;

        layout[0][5] = wall;
        layout[1][5] = " ";
        layout[2][5] = food;
        layout[3][5] = " ";
        layout[4][5] = " ";
        layout[5][5] = wall;
        layout[6][5] = food;
        layout[7][5] = " ";
        layout[8][5] = " ";
        layout[9][5] = " ";
        layout[10][5] = wall;

        layout[0][6] = wall;
        layout[1][6] = " ";
        layout[2][6] = " ";
        layout[3][6] = ConsoleColors.RED + "<" + ConsoleColors.RESET;
        layout[4][6] = " ";
        layout[5][6] = wall;
        layout[6][6] = " ";
        layout[7][6] = " ";
        layout[8][6] = " ";
        layout[9][6] = " ";
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
                System.out.print(layout[i][j]);
                i++;
            }
            i = 0;
            j++;
            System.out.print("\n");
        }
    }


    public String[][] getLayout() {
        return layout;
    }

    public void setLayout(int x, int y, String c) {
        layout[x][y] = c;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
    public String getFood() {
        return food;
    }

    public String getWall() {
        return wall;
    }

    }
