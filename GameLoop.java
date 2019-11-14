import com.sun.istack.internal.NotNull;

import java.util.Scanner;

public class GameLoop {
    private static int collectedFood = 0;
    private boolean isWall = false, isFood = false; //for AI-Logic
    private static Scanner sc = new Scanner(System.in);

    public GameLoop() {
        System.out.println("Please Enter a Name for your Hamster!");
        String name = sc.nextLine();
        System.out.println("Reminder: You can write '-1' any time to exit the game!");
        Hamster h1 = new Hamster(name);
        Map map = new Map();
        loop(map, h1);
    }

    public void loop(Map map, Hamster hamster) {
        int userInput = 0;

        while (userInput != -1) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            map.printMap();

            if (collectedFood >= map.getFoodAmount()) {
                victoryPrint();
            }

            System.out.println("Where should " + ConsoleColors.RED + hamster.getName() + ConsoleColors.RESET + " go? \n1 : Turn Left\n2: Turn Right\n3: Walk Forward\n");
            userInput = sc.nextInt();
            switch (userInput) {
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
            }
        }
    }

    public void walk(Map map, Hamster hamster) {
        int obstacleCheck = checkObstacle(map, hamster);
        if (obstacleCheck == 0 || obstacleCheck == 1) {
            if (obstacleCheck == 1) {
                collectedFood++;
            }
            map.setLayout(hamster.getX(), hamster.getY(), " ");
            hamster.setX(hamster.getX() + hamster.getMovingX());
            hamster.setY(hamster.getY() + hamster.getMovingY());
            map.setLayout(hamster.getX(), hamster.getY(), ConsoleColors.RED + hamster.getCurrentDirection() + ConsoleColors.RESET);
        } else if (obstacleCheck == 2) {
            //dont move
        } else {
            System.out.println("OOB while walking. Breaking . . .");
            System.exit(-1);
        }

    }

    public void turnLeft(Map map, Hamster hamster) {
        hamster.turnLeft();
        map.setLayout(hamster.getX(), hamster.getY(), ConsoleColors.RED + hamster.getCurrentDirection() + ConsoleColors.RESET);
    }

    public void turnRight(Map map, Hamster hamster) {
        hamster.turnRight();
        map.setLayout(hamster.getX(), hamster.getY(), ConsoleColors.RED + hamster.getCurrentDirection() + ConsoleColors.RESET);
    }

    public int checkObstacle(Map map, Hamster hamster) { //0=free, 1=food, 2:barrier
        return doCheck(hamster.getX() + hamster.getMovingX(), hamster.getY() + hamster.getMovingY(), map);
    }

    public int doCheck(int xHamster, int yHamster, Map map) {
        if (map.getLayout()[xHamster][yHamster].equals(" ")) {
            isWall = false;
            return 0;
        } else if (map.getLayout()[xHamster][yHamster].equals(map.getFood())) {
            isWall = false;
            isFood = true;
            return 1;
        } else {
            isWall = true;
            return 2;
        }
    }


    public void victoryPrint(){
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