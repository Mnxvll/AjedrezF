package Controller;

import Logic.*;
import Logic.Exceptions.CustomWinException;

public class ControllerA {
    
    private Board boardInstance = new Board();

    private Piece[][] board = boardInstance.getCloneBoard();

    private int turn = 0;

    private boolean colorTurn = true;
    
    public void turn() {

        colorTurn = !colorTurn;
        turn = (turn == 0) ? 1 : 0;

    }

    public String verifyData(String coordX, String coordY, String newCoordX, String newCoordY) throws CustomWinException {

        int coordDX = 0;
        int coordDY = 0;
        int newCoordDX = 0;
        int newCoordDY = 0;

        try {
            coordDX = coordX.charAt(0) - 64;
            coordDY = Integer.parseInt(coordY);
            newCoordDX = newCoordX.charAt(0) - 64;
            newCoordDY = Integer.parseInt(newCoordY);
            return identifyPiece(coordDX, coordDY, colorTurn, newCoordDX, newCoordDY);
        } catch (NumberFormatException e) {
            return "Invalid data type entered";
        } catch (ArrayIndexOutOfBoundsException exp) {
            return "Out of bounds";
        } catch (StringIndexOutOfBoundsException exception) {
            return "Conflicting data type entered";
        }
        
    }

    public String identifyPiece(int coordX, int coordY, Boolean color, int newCoordX, int newCoordY) throws CustomWinException {

        Piece piece = board[coordX][coordY];
        if (piece == null) {
            // handle the case where there is no piece at the specified coordinate
            return "Enter a valid space";
        } 

        
        if (piece.getColor() != color) {
            
            return "Not the player's turn";

        }else if(!piece.movePiece(newCoordX, newCoordY, color, boardInstance.getCloneBoard()).equals("true") ){

            //return "Invalid move";
            return piece.movePiece(newCoordX, newCoordY, color, boardInstance.getCloneBoard());
    
        }
        // If the movement is valid, iterate the turn
        else
        turn();
    
        boardInstance.movePiece(coordX, coordY, newCoordX, newCoordY, piece, color);
        return piece.toString();
    }

    // return newBoardPieces
    public Piece[][] getBoardPieces(){
        Piece[][] boardPieces = boardInstance.getCloneBoard();
        return boardPieces;
    }

}
