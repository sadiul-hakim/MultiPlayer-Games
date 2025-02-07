package xyz.sadiulhakim.game.ticTacToe;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private String winner;

    public TicTacToe() {
        this.board = new char[3][3];  // 3x3 game board
        this.currentPlayer = 'X';     // X always starts
        this.gameOver = false;
        this.winner = null;

        // Initialize board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col) {

        if (gameOver || board[row][col] != ' ') {
            return false; // Invalid move
        }

        board[row][col] = currentPlayer;
        if (checkWinner(row, col)) {
            gameOver = true;
            winner = String.valueOf(currentPlayer);
        } else if (isBoardFull()) {
            gameOver = true;
            winner = "Draw";
        } else {
            switchPlayer();
        }

        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private boolean checkWinner(int row, int col) {
        char player = board[row][col];

        // Check row
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) return true;
        // Check column
        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) return true;
        // Check diagonals
        if (row == col && board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        return row + col == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
