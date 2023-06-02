//written by: Emily Mathew, mathe798
//written by: Asma Hasan, hassa749
public class Board {

    // Instance variables
    private static Piece[][] board;


    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        this.board = new Piece[8][8];
        // makes the board


    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
        //gets piece at certain row and column

    }


    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
        //sets piece at certain row and column

    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move
    // is legal, and to execute the move if it is. Your Game class should not 
    // directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece starting = getPiece(startRow, startCol);
        Piece ending = getPiece(endRow, endCol);
        if (!verifySourceAndDestination(startRow, startCol, endRow, endCol, starting.getIsBlack())) {
            return false;

        }
        if (!starting.isMoveLegal(this, endRow, endCol)) {
            return false;

        }
        setPiece(endRow, endCol, starting);
        setPiece(startRow, startCol, ending);
        return true;
    }


    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        boolean whiteKing = false;
        boolean blackKing = false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {
                    char piece = board[row][col].getCharacter();
                    if (piece == ('\u2654')) { //checks if white king in piece
                        whiteKing = true;
                    }
                    if (piece == ('\u265a')) { //checks if black king in piece
                        blackKing = true;
                    }
                }
            }
        }
        if(blackKing == false || whiteKing == false){
            return true;

        }
        System.out.println("Game over");
        return false;
    }
    //return statement


    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String output = "";
        output += "  " + "0"+ " "+ "1"+ " "+ "2"+ " "+ "3"+ " "+ "4" +" "+ "5"+" "+ "6"+ " "+ "7"+ " \n";
        for (int i = 0; i < 8; i++) { //row
            output += i;
            for (int j = 0; j < 8; j++) { //col
                output += "|";
                if (board[i][j] == null) {
                    output += '\u2001'; //adds space in board
                } else {
                    output += board[i][j]; //adds character
                }

            }
            output+="|\n";
        }
        return output;
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = null;
            }
        }


    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (startRow < 0 || startRow > 7 || startCol < 0 || startCol > 7 || endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7){
            return false; //checks if in bounds
        }
        Piece starting = getPiece(startRow,startCol); //makes piece that gets a piece at Startrow and startcol
        if(starting == null || starting.getIsBlack() != isBlack ){
            return false;
        }
        Piece ending = getPiece(endRow,endCol); //makes piece that gets a piece at endrol and endcol
        if(ending !=null && ending.getIsBlack() == isBlack){
            return false;
        }
        return true;
    }


    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
//            for(int i = startCol; i != endCol; i++){
//                for(int j = startRow; j != endRow; j++){
        if (Math.abs(endRow - startRow) <= 1 && Math.abs(endCol - startCol) <= 1) {
            return true;
        }
        return false;
//
    }


    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startCol == endCol && startRow ==endRow){
            return true;
        }
        if (startRow != endRow) {
            return false;
        }
        else {
            if (startCol < endCol) {
                for (int open = startCol + 1; open < endCol; open++) {
                    if (board[startRow][open] != null) { //checking if you're going down
                        return false;
                    }
                }
                return true;
            } else if (endCol < startCol) {
                for (int open = endCol + 1; open < startCol; open++) {
                    if (board[startRow][open] != null) { //checking if you're going down..
                        return false;
                    }
                }
                return true;
            }
        }
                    return false;
            }


    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol != endCol) {
            return false;
        }
        if (startRow < endRow) {
            for (int vert = startRow + 1; vert < endRow; vert++) {
                if (board[vert][endCol] != null) {
                    return false;
                }
            }
        } else if (endRow < startRow) {
            for (int vert = endRow + 1; vert < startRow; vert++) {
                if (board[vert][endCol] != null) {
                    return false;
                }
            }
        } else {
            return true;
        }
        return true;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        int minimum = Math.min(startRow, endRow);
        int maximum = Math.max(endRow, startRow);
        if ((startRow - startCol) == endRow - endCol) {
            for (int i = minimum + 1; i < maximum; i++) {
                if (board[i][(startCol - startRow) + i] != null) {
                    return false;
                }
            }
            return true;
        }
        else if ((startRow + startCol) == endRow + endCol) {
            for (int diag = minimum + 1; diag < maximum; diag++) {
                if (board[diag][(startCol + startRow) - diag] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

