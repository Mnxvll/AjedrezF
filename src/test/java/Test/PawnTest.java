package Test;

import Logic.Pawn;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Pawn pawn = new Pawn(true, "pawn", 1, 2);
        Pawn pawB = new Pawn(true, "pawn", 2, 3);
        // Test that it does not move more than two squares in its initial position
        assertEquals("ERROR [Invalid movement for this position]", pawn.verifyMovement(1, 5, true, board));
        // Test that it does not move more than one square if not in its initial position
        assertEquals("ERROR [Movement not allowed]", pawB.verifyMovement(2, 5, true, board));
        // Test that it does not move to an empty space to the right or left
        assertEquals("ERROR [Impossible movement]", pawn.movePiece(3, 3, true, board));
        // Test that the pawn does not move backwards
        assertEquals("ERROR [You cannot move backwards]", pawn.movePiece(1, 1, true, board));
        // Test that the pawn does not move diagonally if there are no enemies
        assertEquals("ERROR [Impossible movement]", pawn.movePiece(2, 3, true, board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Pawn pawnA = new Pawn(true, "pawnA", 2, 2);
        Pawn pawnB = new Pawn(true, "pawnB", 1, 3);
        Pawn pawnC = new Pawn(false, "pawnC", 3, 3);
        Pawn pawnD = new Pawn(false, "pawnD", 1, 7);
        board[1][3] = pawnB;
        board[3][3] = pawnC;
        board[1][7] = pawnD;
        // Test that it does not capture its own team
        assertEquals("ERROR [You cannot capture your own piece]", pawnA.movePiece(1, 3, true, board));
        // Test that it captures pieces of another color
        assertEquals("true", pawnA.movePiece(3, 3, true, board));
        // Test that it does not capture diagonally at a long distance
        assertEquals("ERROR [Movement not allowed]", pawnA.movePiece(1, 7, true, board));
    }


}