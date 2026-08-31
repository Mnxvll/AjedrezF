    package Logic;

    public class Queen extends Piece {


        //True White, False Black
        public Queen(boolean color, String name, int positionX, int positionY) {
            super(color, name, positionX, positionY);
        }

        
        public String movePiece(int coordX, int coordY, Boolean color, Piece[][] board) {

            // execute verify method
            if (!verifyMovement(coordX, coordY, color,board).equals("true")) {
                return verifyMovement(coordX, coordY, color, board);
            }
            // Update previous positions with the new ones
            this.positionX = coordX;
            this.positionY = coordY;

            return  "true";
        }

        @Override
        public String verifyMovement(int coordX, int coordY, boolean color, Piece[][] board) {
           // If the movement is not diagonal
            // Create two variables to calculate the amount of advanced locations
            int advancedX = Math.abs(coordX-positionX);
            int advancedY = Math.abs(coordY-positionY);

            // Verify where it is going to go
            // There are five cases of iteration (-y-x), (-x+y), (x+y), (-x-y), (x-y)
            int directionX = Integer.compare(coordX, positionX);
            int directionY = Integer.compare(coordY, positionY);

            // Current position variables
            int currentlyX = positionX + directionX;
            int currentlyY = positionY + directionY;

            if(advancedX == advancedY){

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

            }
            // vertical movement
            else if (directionX == 0) {
                int currentY = positionY + directionY;
                while (currentY != coordY) {
                    if (board[positionX][currentY] != null) {
                        return "ERROR [Vertical movement, you cannot move, a piece is blocking your path]"; // Executes if there is something in the path
                    }
                    currentY += directionY;
                }
            }
            // horizontal movement
            else if (directionY == 0) {
                int currentX = positionX + directionX;
                while (currentX != coordX) {
                    if (board[currentX][positionY] != null) {
                        return "ERROR [Horizontal movement, you cannot move, a piece is blocking your path]"; // Executes if there is something in the path
                    }
                    currentX += directionX;
                }
            }else if(advancedX != advancedY && directionX!=0 && directionY != 0){
                return "ERROR [Invalid movement]";
            }

            Piece targetPiece = board[coordX][coordY];
            if(targetPiece == null || targetPiece.getColor() != getColor())
                return "true";
            else
                return "ERROR [You cannot capture your own piece]";
        }



    }