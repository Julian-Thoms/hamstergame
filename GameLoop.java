import gameobjects.Hamster;
import res.ConsoleColors;

import java.util.Scanner;

public class GameLoop {
    //private boolean isWall = false, isFood = false; //for AI-Logic
    private static Scanner sc = new Scanner(System.in);
    private Hamster h1;
    private Map map;

    public GameLoop() {
        System.out.println("Please Enter a Name for your Hamster!");
        String hamsterName;
        hamsterName = sc.nextLine();
        System.out.println("Reminder: You can write '-1' any time to exit the game!");
        h1 = new Hamster(hamsterName);
        map = new Map(h1);
    }

    public void init() {
        loop(map, h1);
    }

    private void loop(Map map, Hamster hamster) {
        int userOption = 0;
        String userInput;
        while (userOption != -1) {

            //clears console page, doesn't work in IDE
            System.out.print("\033[H\033[2J");
            System.out.flush();

            map.printMap();


            if (hamster.getFoodCollected() >= map.getFoodAmount()) {
                victoryPrint();
            }

            System.out.println("Where should " + ConsoleColors.RED_BOLD + hamster.getName() + ConsoleColors.RESET + " go? \n1: Turn Left\n2: Turn Right\n3: Walk Forward\n");
            userInput = sc.next();
            try {
                userOption = Integer.parseInt(userInput);
                switch (userOption) {
                    case 1:
                        turnLeft(map, hamster);
                        break;
                    case 2:
                        turnRight(map, hamster);
                        break;
                    case 3:
                        walk(map, hamster);
                        break;
                    default:
                        throw new Exception();
                }
            }
            //catches all wrong userinputs
            catch (Exception e) {
                System.out.println("Please Stick to 1, 2 and 3! \n");
                //continues
            }
        }
    }


    public void walk(Map map, Hamster h) {
        int obstacleCheck = checkObstacle(map, h);
        if (obstacleCheck == 0 || obstacleCheck == 1) {
            if (obstacleCheck == 1) {
                h.collectedFood();
            }

            map.setLayout(h.getX(), h.getY(), map.getGrass());
            h.setX(h.getX() + h.getMovingX());
            h.setY(h.getY() + h.getMovingY());
            map.setLayout(h.getX(), h.getY(), h);

        } else if (obstacleCheck != 2) {
            System.out.println("OOB while walking. Breaking . . .");
            System.exit(-1);
        }

    }

    public void turnLeft(Map map, Hamster h) {
        h.turnLeft();
        map.setLayout(h.getX(), h.getY(), h);
    }

    public void turnRight(Map map, Hamster h) {
        h.turnRight();
        map.setLayout(h.getX(), h.getY(), h);
    }

    //this method uses walking direction to adjust which direction gets checked
    public int checkObstacle(Map map, Hamster h) { //returns 0=free, 1=food, 2:barrier
        return doCheck(h.getX() + h.getMovingX(), h.getY() + h.getMovingY(), map);
    }

    //this method checks the tile in the chosen direction, returns 0=free, 1=food, 2:barrier
    public int doCheck(int x, int y, Map map) {
        if (map.getLayout()[x][y].isWalkable()) {
            //isWall = false;

            if (map.getLayout()[x][y] == map.getFood()) {
                //isFood = true;
                return 1;
            }
            return 0;
        } else {
            //isWall = true;
            return 2;
        }
    }

    public void victoryPrint() {
        System.out.println(" ############################################################# \n" +
                " # " + ConsoleColors.GREEN + "V       V  " + ConsoleColors.RED + " III " + ConsoleColors.GREEN + "   CCCCC " + ConsoleColors.RED + " TTTTTTT " + ConsoleColors.GREEN + "  OOO    " + ConsoleColors.RED + "RRRR  " + ConsoleColors.GREEN + " Y     Y" + ConsoleColors.RESET + " # \n" +
                " # " + ConsoleColors.GREEN + " V     V   " + ConsoleColors.RED + "  I  " + ConsoleColors.GREEN + "  C      " + ConsoleColors.RED + "    T    " + ConsoleColors.GREEN + " O   O   " + ConsoleColors.RED + "R   R " + ConsoleColors.GREEN + "  Y   Y " + ConsoleColors.RESET + " # \n" +
                " # " + ConsoleColors.GREEN + "  V   V    " + ConsoleColors.RED + "  I  " + ConsoleColors.GREEN + " C       " + ConsoleColors.RED + "    T    " + ConsoleColors.GREEN + "O     O  " + ConsoleColors.RED + "RRRR  " + ConsoleColors.GREEN + "    Y   " + ConsoleColors.RESET + " # \n" +
                " # " + ConsoleColors.GREEN + "   V V     " + ConsoleColors.RED + "  I  " + ConsoleColors.GREEN + "  C      " + ConsoleColors.RED + "    T    " + ConsoleColors.GREEN + " O   O   " + ConsoleColors.RED + "R R   " + ConsoleColors.GREEN + "    Y   " + ConsoleColors.RESET + " # \n" +
                " # " + ConsoleColors.GREEN + "    V      " + ConsoleColors.RED + " III " + ConsoleColors.GREEN + "   CCCCC " + ConsoleColors.RED + "    T    " + ConsoleColors.GREEN + "  OOO    " + ConsoleColors.RED + "R   R " + ConsoleColors.GREEN + "    Y   " + ConsoleColors.RESET + " # \n" +
                " ############################################################# \n");
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

}