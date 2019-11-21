import com.sun.istack.internal.NotNull;
import com.sun.media.sound.InvalidFormatException;

import java.text.NumberFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GameLoop {
    private static int collectedFood = 0;
    private boolean isWall = false, isFood = false; //for AI-Logic
    private static Scanner sc = new Scanner(System.in);
    Hamster h1;
    Map map;
    public GameLoop() {
        System.out.println("Please Enter a Name for your Hamster!");
        String name = sc.nextLine();
        System.out.println("Reminder: You can write '-1' any time to exit the game!");
        h1 = new Hamster(name);
        map = new Map();
    }

    public void init(){
        loop(map, h1);
    }

    private void loop(Map map, Hamster hamster) {
        int userOption = 0;
        String userInput;
        while (userOption != -1) {

            //clears console page
            System.out.print("\033[H\033[2J");
            System.out.flush();

            map.printMap();

            if (collectedFood >= map.getFoodAmount()) {
                victoryPrint();
            }

            System.out.println("Where should "+ hamster.getName() + " go? \n1 : Turn Left\n2: Turn Right\n3: Walk Forward\n");
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
            catch(Exception e){
                System.out.println("Please Stick to 1, 2 and 3! \n");
                continue;
                }
            }
        }


    public void walk(Map map, Hamster hamster) {
        int obstacleCheck = checkObstacle(map, hamster);
        if (obstacleCheck == 0 || obstacleCheck == 1) {
            if (obstacleCheck == 1) {
                collectedFood++;
            }
            map.setLayout(hamster.getX(), hamster.getY(), map.getGrass());
            hamster.setX(hamster.getX() + hamster.getMovingX());
            hamster.setY(hamster.getY() + hamster.getMovingY());
            map.setLayout(hamster.getX(), hamster.getY(), hamster.getCurrentDirection());
        } else if (obstacleCheck == 2) {
            //dont move
        } else {
            System.out.println("OOB while walking. Breaking . . .");
            System.exit(-1);
        }

    }

    public void turnLeft(Map map, Hamster hamster) {
        hamster.turnLeft();
        map.setLayout(hamster.getX(), hamster.getY(), hamster.getCurrentDirection());
    }

    public void turnRight(Map map, Hamster hamster) {
        hamster.turnRight();
        map.setLayout(hamster.getX(), hamster.getY(), hamster.getCurrentDirection());
    }

    public int checkObstacle(Map map, Hamster hamster) { //0=free, 1=food, 2:barrier
        return doCheck(hamster.getX() + hamster.getMovingX(), hamster.getY() + hamster.getMovingY(), map);
    }

    public int doCheck(int xHamster, int yHamster, Map map) {
        if (map.getLayout()[xHamster][yHamster] == map.getGrass()) {
            isWall = false;
            return 0;
        } else if (map.getLayout()[xHamster][yHamster] == map.getFood()) {
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
                " # V       V   III    CCCCC  TTTTTTT   OOO    RRRR   Y     Y # \n" +
                " #  V     V     I    C          T     O   O   R   R   Y   Y  # \n" +
                " #   V   V      I   C           T    O     O  RRRR      Y    # \n" +
                " #    V V       I    C          T     O   O   R R       Y    # \n" +
                " #     V       III    CCCCC     T      OOO    R   R     Y    # \n" +
                " ############################################################# \n");
        System.out.println("Thanks for playing!");
        System.exit(0);
    }
}