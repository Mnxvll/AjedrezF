package Logic;

public class Knight extends Piece {


    public Knight(boolean color, String name, int positionX, int positionY) {
        super(color, name, positionX, positionY);
    }

    @Override
    public String movePiece(int coordX, int coordY, Boolean color, Piece [][] board) {


        // execute verify method
        if (!verifyMovement(coordX, coordY, color, board).equals("true")) {
            return verifyMovement(coordX, coordY, color, board);
        }

        // update previous positions with the new ones
        this.positionX = coordX;
        this.positionY = coordY;

        return "true";
    }

    public String verifyMovement(int coordX, int coordY, boolean color, Piece[][] board) {
        
        int diffX = Math.abs(coordX - this.positionX);
        int diffY = Math.abs(coordY - this.positionY);
 
        // Verify that the new position does not have a piece of the same color
        if (board[coordX][coordY] != null && board[coordX][coordY].getColor() == this.color) {
            return "ERROR [You cannot capture your own piece]";
            // Verify that the knight does not leave the board
        } else if (!verifyRange(coordX, coordY)) {
            return "ERROR [You have gone out of bounds]"; // This should never execute
            // Verify that the knight moves in L shape
        } else if ((diffX + diffY )!= 3) {
            return "ERROR [Movement does not follow chess rules]";
        } else if (diffX == 0 && diffY!=0) {
            return "ERROR [Invalid move]";
        } else if (diffX>2) {
            return "ERROR [Invalid move]";
        } else {
            return "true";
        }
    }
}