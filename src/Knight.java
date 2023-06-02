//written by: Asma Hasan, hassa749
public class Knight {
    private int row;
    private int col;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        int absRow = Math.abs(endRow-row);
        int absCol = Math.abs(endCol-col);

        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack)){
            if(absRow == 2 && absCol==1){
                return true;
            } if (absRow ==1 && absCol == 2){
                return true;
            }
        }
        return false;
    }
}
