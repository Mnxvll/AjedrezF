package Logic;

public class Rook extends Piece{

   // Constructor
    public Rook(boolean color, String name, int positionX, int positionY) {
        super(color, name, positionX, positionY);
    }
    // Methods
    @Override
    public String movePiece(int coordX, int coordY, Boolean color, Piece[][] board) {
        if (!verifyMovement(coordX, coordY, color, board).equals("true")) {
            return verifyMovement(coordX, coordY, getColor(), board);
        }
        this.positionX = coordX;
        this.positionY = coordY;
        return "true";
    }

    public String verifyMovement(int coordX, int coordY, boolean color, Piece[][] board) {
        
        // See which direction the movement goes
        int dirX = Integer.compare(coordX, positionX);
        int dirY = Integer.compare(coordY, positionY);
    
        // see if it moves vertically
        if (dirX == 0) {
            int currentY = positionY + dirY;
            while (currentY != coordY) {
                if (board[positionX][currentY] != null) {

                    return "ERROR [Vertical movement, you cannot move, there is a piece blocking your path]"; // Executes if there is something in the path
                }
                currentY += dirY;
            }
        }
        // if it moves horizontally
        else if (dirY == 0) {
            int currentX = positionX + dirX;
            while (currentX != coordX) {
                if (board[currentX][positionY] != null) {
                    return "ERROR [Horizontal movement, you cannot move, there is a piece blocking your path]"; // Executes if there is something in the path
                }
                currentX += dirX;
            }
        }
        // if it doesn't comply with either of the two types of movement, return false
        else {
            return "ERROR [You are not moving horizontally or vertically]";
        }
    
        // Verify if the piece's color is equal to the interruption's color
        Piece targetPiece = board[coordX][coordY];
        if(targetPiece == null || targetPiece.getColor() != color)
        return "true";
        else
        return "ERROR [You cannot capture your own piece]";
    }

}