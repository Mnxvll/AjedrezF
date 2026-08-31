package Logic;

public class Pawn extends Piece {


    public Pawn(boolean color, String name, int positionX, int positionY) {
        super(color, name, positionX, positionY);
    }

    @Override
    public String movePiece(int coordX, int coordY, Boolean color, Piece[][] board ) {

        // execute the verify method, if it fails it will return the error string
        if (!verifyMovement(coordX, coordY, color, board).equals("true")) {
            return verifyMovement(coordX, coordY, color, board);
        }

        // update the positions
        this.positionX = coordX ;
        this.positionY = coordY ;

        return "true";
    }
    
    public String verifyMovement(int coordX, int coordY, boolean color, Piece[][] board) {

        int diffX = Math.abs(coordX - this.positionX);
        int diffY = Math.abs(coordY - this.positionY);

        // Verify that the new position does not have a piece of the same color
        if (board[coordX][coordY] != null && board[coordX][coordY].getColor() == this.color) {
            return ("ERROR [You cannot capture your own piece]");
        // Verify that the pawn does not leave the board
        } else if (verifyRange(coordX, coordY) == false) {
            return("ERROR [New coordinates are not on the board]");
        // Verify that if the pawn is in its initial position, it doesn't move more than 2 positions in Y
        } else if (this.positionY == 2 && diffX == 0 && (coordY > 4 || board[coordX][this.positionY+1]!=null)) {
            return("ERROR [Invalid movement for this position]");
        } else if (this.positionY == 7 && diffX == 0 && (coordY < 5 || board[coordX][this.positionY-1]!=null)) {
            return("ERROR [Invalid movement for this position]");
        // Verify that if the pawn is not in its initial position, it doesn't move more than 1 position in Y
        } else if (this.positionY != 7 && this.positionY != 2 && diffY > 1) {
            return("ERROR [Movement not allowed]");
        // Verify that the pawn does not move to an empty space diagonally (unless en passant, not implemented)
        } else if (board[coordX][coordY] == null && diffX != 0) {
            return ("ERROR [Impossible movement]");
        // Verify that the pawn does not capture sideways
        }else if (board[coordX][coordY] != null && diffX != 0 && coordY == this.positionY) {
            return("ERROR [You cannot capture sideways]");
        // Verify that the pawn does not capture forward
        } else if (board[coordX][coordY] != null && diffX == 0 && diffY == 1) {
            return("ERROR [You cannot capture forward]");
        // Verify that the pawn does not move diagonally more than one square
        } else if (diffX >=1 && diffY>1 && board[coordX][coordY] !=null && board[coordX][coordY].getColor() != this.color ) {
            return "ERROR [You cannot move this way]";
        // Verify that the pawn does not try to move backwards depending on its color
        } else if ((color && coordY < this.positionY) || (!color && coordY > this.positionY)) {
            return("ERROR [You cannot move backwards]");
        }else {
            return "true";
        }
    }
}