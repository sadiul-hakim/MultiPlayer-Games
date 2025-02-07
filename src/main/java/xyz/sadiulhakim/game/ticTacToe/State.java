package xyz.sadiulhakim.game.ticTacToe;

public class State {
    private String gameId;
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private String winner;
    private boolean validMove;

    public State(String gameId, char[][] board, char currentPlayer,
                 boolean gameOver, String winner, boolean validMove) {
        this.gameId = gameId;
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.gameOver = gameOver;
        this.winner = winner;
        this.validMove = validMove;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
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

    public boolean isValidMove() {
        return validMove;
    }

    public void setValidMove(boolean validMove) {
        this.validMove = validMove;
    }
}
