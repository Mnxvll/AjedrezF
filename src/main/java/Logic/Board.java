package Logic;

import Logic.Exceptions.CustomWinException;

public class Board {


    private Piece[][] board;

    
    public Piece[][] assignQueen(Piece[][] board) {
        board[5][1] = new Queen(true, "♛", 5, 1);
        board[5][8] = new Queen(false, "♕", 5, 8);
        return board;
    }

    //Kings
    public Piece[][] assignKings(Piece[][] board) {
        board[4][1] = new King(true, "♚", 4, 1);
        board[4][8] = new King(false, "♔", 4, 8);
        return board;
    }

    //Pawns
    public Piece[][] assignPawns(Piece[][] board) {
        for (int i = 1; i < 9; i++) {
            board[i][2] = new Pawn(true, "♙", i, 2);
            board[i][7] = new Pawn(false, "♟", i, 7);
        }
        return board;
    }

    //Knights
    public Piece[][] assignKnights(Piece[][] board) {
        board[2][1] = new Knight(true, "♞", 2, 1);
        board[7][1] = new Knight(true, "♞", 7, 1);
        board[2][8] = new Knight(false, "♘", 2, 8);
        board[7][8] = new Knight(false, "♘", 7, 8);
        return board;
    }

    //Bishops
    public Piece[][] assignBishops(Piece[][] board) {
        board[3][1] = new Bishop(true, "♝", 3, 1);
        board[6][1] = new Bishop(true, "♝", 6, 1);
        board[3][8] = new Bishop(false, "♗", 3, 8);
        board[6][8] = new Bishop(false, "♗", 6, 8);
        return board;
    }

    //Rooks
    public Piece[][] assignRooks(Piece[][] board) {
        board[1][1] = new Rook(true, "♜", 1, 1);
        board[8][1] = new Rook(true, "♜", 8, 1);
        board[1][8] = new Rook(false, "♖", 1, 8);
        board[8][8] = new Rook(false, "♖", 8, 8);
        return board;
    }

    

    // Getters and Setters
    public Piece[][] getBoard() {
        return board;
    }
    public void setBoard(Piece[][] board) {
        this.board = board;
    }
    public Piece[][] getCloneBoard(){
        return board.clone();
    }
   
    public Board() {
        board = new Piece[9][9];
        assignKings(board);
        assignQueen(board);
        assignBishops(board);
        assignKnights(board);
        assignPawns(board);
        assignRooks(board);
    }
    // Move piece method
    public Piece[][] movePiece (int cordX, int cordY, int newCordX, int newCordY, Piece type, boolean color) throws CustomWinException{
        if (type != null) {

            if(board[newCordX][newCordY] != null && (type.getColor() != board[newCordX][newCordY].getColor()) &&(board[newCordX][newCordY].getName().equals("♔")||board[newCordX][newCordY].getName().equals("♚"))) {
                String turn = "";
                if(color){turn = "White";}else turn="Black";
                throw new CustomWinException("");
            }
            // updates the real board
            board[cordX][cordY] = null;
            board[newCordX][newCordY] = type;
        }
        return null;
    }

}