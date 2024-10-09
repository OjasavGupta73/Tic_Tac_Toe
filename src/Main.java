import java.util.*;

public class Main {
    public static void main(String[] args) {
        Board game = new Board();//
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player 1:");
        String p1 = scanner.nextLine();

        System.out.println("Enter Player 2:");
        String p2 = scanner.nextLine();

        int move = 1;
        int xcor, ycor, subBoardSelectX, subBoardSelectY;

        while (true) {
            game.printBoard();

            if (move == 1) {
                System.out.println(p1 + "'s turn");
            } else {
                System.out.println(p2 + "'s turn");
            }

            do {
                subBoardSelectX = game.lastMoveX;
                subBoardSelectY = game.lastMoveY;
                int validity_c=0;
                while (subBoardSelectX == -1 || game.valid(subBoardSelectX,subBoardSelectY)) {
                    System.out.println("Enter Board X:");
                    subBoardSelectX = scanner.nextInt();
                    System.out.println("Enter Board Y:");
                    subBoardSelectY = scanner.nextInt();
                    validity_c++;
                    if(validity_c>1) {
                        System.out.println("WARNING:Wrong Board Chosen Try Again!!");
                    }
                }


                System.out.println("Enter X Coordinate:");
                xcor = scanner.nextInt();
                System.out.println("Enter Y Coordinate:");
                ycor = scanner.nextInt();
            } while (game.getXY(xcor, ycor, subBoardSelectX, subBoardSelectY) != 0);
            game.setXY(xcor, ycor, subBoardSelectX, subBoardSelectY, move);

            int gameState = game.checkWinAbsolute();
            if (gameState == 2) {
                game.printBoard();
                System.out.println("Game Drawn");
                break;
            } else if (gameState == 1) {
                game.printBoard();
                System.out.println(p1 + " Wins");
                break;
            } else if (gameState == -1) {
                game.printBoard();
                System.out.println(p2 + " Wins");
                break;
            }

            move *= -1;
        }
        scanner.close();
    }
}