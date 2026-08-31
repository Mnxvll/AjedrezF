package Logic.Interface;

import Logic.Piece;

public interface Moveable {
    String movePiece(int positionX, int positionY, Boolean color, Piece[][] board);

    String verifyMovement(int coordX, int coordY, boolean color, Piece[][] board);
}
