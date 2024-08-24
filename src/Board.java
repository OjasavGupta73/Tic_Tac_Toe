class Board {
    public SubBoard[][] board;
    public int lastMoveX;
    public int lastMoveY;

    // Constructor
    public Board() {
        lastMoveX = -1;
        lastMoveY = -1;
        board = new SubBoard[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new SubBoard();
            }
        }
    }

    public void setXY(int x, int y, int subBoardX, int subBoardY, int val) {
        board[subBoardX][subBoardY].setXY(x, y, val);
        lastMoveX = x;
        lastMoveY = y;

        if (board[x][y].checkWin() != 0) {
            lastMoveX = -1;
            lastMoveY = -1;
        }
    }

    public int getXY(int x, int y, int subBoardX, int subBoardY) {
        return board[subBoardX][subBoardY].getXY(x, y);
    }

    public void printBoard() {
        int[][] printBuffer = new int[9][9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int rowCoordinate = i * 3;
                int colCoordinate = j * 3;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        printBuffer[rowCoordinate + x][colCoordinate + y] = board[i][j].getXY(x, y);
                    }
                }
            }
        }

        System.out.println("\n=============================");
        for (int i = 0; i < 9; i++) {
            System.out.print("|| ");
            for (int j = 0; j < 9; j++) {
                int temp = printBuffer[i][j];

                if (temp == 0) {
                    System.out.print('.');
                } else if (temp == 1) {
                    System.out.print('x');
                } else {
                    System.out.print('o');
                }

                if (j % 3 == 2) {
                    System.out.print(" || ");
                } else {
                    System.out.print(' ');
                }
            }

            if (i % 3 == 2) {
                System.out.println("\n=============================");
            } else {
                System.out.println();
            }
        }
    }

    public int checkWinAbsolute() {
        int[][] dp = new int[3][3];
        int emptyCounter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = board[i][j].checkWin();
                if (dp[i][j] == 0) {
                    emptyCounter++;
                }
            }
        }

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (dp[i][0] == dp[i][1] && dp[i][1] == dp[i][2] && dp[i][0] != 0 && dp[i][0] != 2) {
                return dp[i][0];
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (dp[0][j] == dp[1][j] && dp[1][j] == dp[2][j] && dp[0][j] != 0 && dp[0][j] != 2) {
                return dp[0][j];
            }
        }

        // Check diagonals
        if (dp[0][0] == dp[1][1] && dp[1][1] == dp[2][2] && dp[0][0] != 0 && dp[0][0] != 2) {
            return dp[0][0];
        }
        if (dp[0][2] == dp[1][1] && dp[1][1] == dp[2][0] && dp[0][2] != 0 && dp[0][2] != 2) {
            return dp[0][2];
        }

        if (emptyCounter > 0) {
            return 0;
        }
        return 2;
    }
}
