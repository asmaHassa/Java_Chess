//written by: Emily Mathew, mathe798
//written by: Asma Hasan, hassa749
import java.util.Scanner;

public class Game {

    public static void main (String[] args) {
        boolean isBlack = false;
        Board board = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board);
        boolean WhitePlayer = false;
        boolean BlackPlayer = false;
        Scanner myScanner = new Scanner(System.in);
        while(!board.isGameOver()){
            System.out.print(board);
            if(!isBlack)
                System.out.println("Player 1: what is your move? , format: [startRow] [startcol] [endRow] [endCol]"); //white player
            else
                System.out.println("Player 2: what is your move? , format: [startRow] [startcol] [endRow] [endCol]"); //black player
            int startRow = 0;
            int startCol = 0;
            int endRow =0;
            int endCol = 0;
        while(true) {
            WhitePlayer = true;
            String input = myScanner.nextLine();
            String[] plot = input.split(" ");
             startRow = Integer.parseInt(plot[0]);
             startCol = Integer.parseInt(plot[1]);
             endRow = Integer.parseInt(plot[2]);
             endCol = Integer.parseInt(plot[3]);
            //if colors dont match then restart while loop and get new input
            if (board.getPiece(startRow, startCol) != null && board.getPiece(startRow, startCol).getIsBlack() == isBlack)
                  break;
            else{
                System.out.println("invalid input try again:");
            }
        }
            if(board.getPiece(startRow,startCol).isMoveLegal(board,endRow,endCol) && !isBlack && board.getPiece(startRow,startCol)!=null) {

                board.movePiece(startRow, startCol, endRow, endCol);//checks if it's a black piece, a valid move, and if the spot is null
                //board.movePiece(startRow, startCol, endRow, endCol);
                System.out.println(board);//board should print with piece moved
                BlackPlayer = false;
                board.getPiece(endRow,endCol).pawnPromotion();
            }
            else if((board.getPiece(startRow,startCol).isMoveLegal(board,endRow,endCol) && isBlack && board.getPiece(startRow,startCol)!=null)){
                board.movePiece(startRow, startCol, endRow, endCol);//checks if it's a white piece, a valid move, and if the spot is null
                //board.movePiece(startRow, startCol, endRow, endCol);
                System.out.println(board);//board prints with the piece moved
                WhitePlayer = false;
                board.getPiece(endRow,endCol).pawnPromotion();
            }
            else{
                System.out.println("Not a valid position");

                //want to move piece to the endRow,endCol
//                System.out.println("Player 2:, your turn, what is your move? , format: [startRow] [startcol] [endRow] [endCol]"); //black player
//                BlackPlayer = true;
//                Scanner scanner2 = new Scanner(System.in);
//                String input2 = myScanner.nextLine();
//                Piece piece = board.getPiece(startRow, startCol);
             }
            isBlack = !isBlack;
        }
        //write an if statement to say who the winner is

//        boolean whitePlayer = !this.getBlack; //setting white player to nonblack pieces
//         boolean blackPlayer = getBlack(); //setting black player to black pieces


    }

    }


