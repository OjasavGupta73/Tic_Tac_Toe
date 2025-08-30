class SubBoard {
    public int[][] board;

    // Constructor
    public SubBoard() {
        board = new int[3][3];
        set0();
    }

    public void set0() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
    }
    public int randomfunction(){
        return 0;
    }
    public int checkWin() {
        boolean emptyCount = false;

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                return board[i][0];
            }
            if (board[i][0] == 0) {
                emptyCount = true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                return board[0][i];
            }
            if (board[0][i] == 0) {
                emptyCount = true;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            return board[0][2];
        }

        if (emptyCount) {
            return 0;
        }
        return 2;
    }

    public int setXY(int x, int y, int val) {
        board[x][y] = val;
        return 0;
    }

    public int getXY(int x, int y) {
        return board[x][y];
    }
}