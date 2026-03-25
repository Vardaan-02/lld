package models;

public class Board {
    private final int size;
    Cell[][] grid;

    public Board(int size){
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++){
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int row, int col){
        return grid[row][col];
    }

    public int getSize(){
        return this.size;
    }

    public boolean isFull(){
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++){
                if (grid[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    public void applyMove(Move move){
        int row = move.getRow();
        int col = move.getCol();
        validateBounds(row, col);
        
        grid[row][col].setPiece(move.getPlayer().getPiece());
    }

    public void revertMove(Move move){
        int row = move.getRow();
        int col = move.getCol();
        validateBounds(row, col);
        
        grid[row][col].clear();
    }

    private void validateBounds(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid move: (" + row + ", " + col + ") is out of bounds for board size " + size);
        }
    }
}
