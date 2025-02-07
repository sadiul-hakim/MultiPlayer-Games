package xyz.sadiulhakim.game.ticTacToe;

public class Move {
    private String gameId;
    private int row;
    private int col;

    public Move(String gameId, int row, int col) {
        this.gameId = gameId;
        this.row = row;
        this.col = col;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
