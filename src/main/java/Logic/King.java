package Logic;

public class King extends Piece {
    public King(boolean color, String name, int positionX, int positionY) {
        super(color, name, positionX, positionY);
    }

    


    public String movePiece(int coordX, int coordY, Boolean color, Piece[][] board) {

        // execute verify method
        if (!verifyMovement(coordX, coordY, color, board).equals("true")) {
            return verifyMovement(coordX, coordY, getColor(), board);
        }
        // Update previous positions with the new ones
        this.positionX = coordX;
        this.positionY = coordY;

        return  "true";
    }

    public String verifyMovement(int coordX, int coordY, boolean color, Piece[][] board) {

        int diffX = Math.abs(coordX - this.positionX);
        int diffY = Math.abs(coordY - this.positionY);
 
        // Verify that the new position does not have a piece of the same color
        if (board[coordX][coordY] != null && board[coordX][coordY].getColor() == this.color) {
            return "ERROR [You cannot capture your own piece]";
            // Verify that the king does not leave the board
        } if (!verifyRange(coordX, coordY)) {
            return "ERROR [You have tried to move out of the board]";
            // Verify that the king only moves one square
        }else if (diffX > 1 || diffY > 1) {
            return "ERROR [Invalid move according to chess rules]";
        }else {
            return "true";
        }
    }
}



