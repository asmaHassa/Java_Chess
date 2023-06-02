//written by: Emily Mathew, mathe798
public class Rook {
    private int row;
    private int col;
    private boolean isBlack;

    //rook moves horizontal or diagonal
    public Rook(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    //horizontal and vertical
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, this.isBlack)) {
            if (board.verifyHorizontal(row, col, endRow, endCol)) {//checks if horizontal movement is legal
                if(board.verifyVertical(row, col, endRow, endCol)) {//checks if vertical movement is legal
                    return true;
                }
            }
        }
        return false;
        //verifies legal and in bounds first
    }
}