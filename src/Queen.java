//written by: Asma Hasan, hassa749
public class Queen { //queen chess piece class
    private int row;
    private int col;
    private boolean isBlack;

    public Queen(int row, int col, boolean isBlack) { //constructor
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if (board.verifySourceAndDestination(row, col, endRow, endCol, isBlack)) {
            if(board.verifyHorizontal(row,col,endRow,endCol)) { //checks if horizontal move is legal
                return true;
            }
            if(board.verifyVertical(row,col,endRow,endCol)) {//checks if vertical move is legal
                return true;
            }
            if(board.verifyDiagonal(row,col,endRow,endCol)) {//checks if diagonal move is legal
                return true;
            }
            if(board.verifyAdjacent(row,col,endRow,endCol)){//checks if adjacent move is legal
                return true;

            }


                    }

    return false;
                }

            }


