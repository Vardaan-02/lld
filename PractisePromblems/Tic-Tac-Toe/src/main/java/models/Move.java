package models;

public class Move {
    private final int row;
    private final int col;
    private final Player player;

    public Move(int row, int col, Player player){
        this.row = row;
        this.col = col;
        this.player = player;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public Player getPlayer(){
        return this.player;
    }
}
