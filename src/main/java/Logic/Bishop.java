package Logic;



public class Bishop extends Piece{

    

    public Bishop(boolean color, String name, int positionX, int positionY) {
        super(color, name, positionX, positionY);
    }
    

    @Override
    public String movePiece(int coordX, int coordY, Boolean color, Piece[][] board) {
        if (!verifyMovement(coordX, coordY, color, board).equals("true")) {
            return verifyMovement(coordX, coordY, color, board);
        }
        this.positionX = coordX;
        this.positionY = coordY;
        return "true";
    }
    public String verifyMovement(int coordX, int coordY, boolean color, Piece[][] board) {
        // Instantiate Board (comment kept for context)
        

        // If the movement is not diagonal
        // Create two variables to calculate the amount of advanced locations
        int advancedX = Math.abs(coordX-positionX);
        int advancedY = Math.abs(coordY-positionY);

        // Compare the advances, if they are not equal it means it is not a valid move
        if(advancedX != advancedY){
            return "ERROR [Invalid move, not diagonal]";
        }

        // Verify where it is going to go
        // There are five cases of iteration (-y-x), (-x+y), (x+y), (-x-y), (x-y)
        int directionX = Integer.compare(coordX, positionX);
        int directionY = Integer.compare(coordY, positionY);

        // Current position variables
        int currentlyX = positionX + directionX;
        int currentlyY = positionY + directionY;

        // Loop that will iterate to the new piece position
        while(currentlyX != coordX && currentlyY != coordY) {
            if(board[currentlyX][currentlyY] != null){
                // Enter if there is any kind of obstacle
                return "ERROR [Cannot move, a piece is blocking your path]";
            }
            // In theory this iterates in the direction it moved, whether in X or Y
            currentlyX += directionX;
            currentlyY += directionY;
        }

        Piece targetPiece = board[currentlyX][currentlyY];
        if(targetPiece == null || targetPiece.getColor() != getColor())
        return "true";
        else
        return "ERROR [You cannot capture your own piece]";
    }
}
