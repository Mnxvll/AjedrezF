package Test;

import Logic.Knight;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class KnightTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Knight knight = new Knight(true, "knight", 2, 1);
        // Test that the knight only moves in L shape
        assertEquals("ERROR [Movement does not follow chess rules]",knight.movePiece(2, 3, true, board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Knight knightA = new Knight(true, "knightA", 2, 1);
        Knight knightB = new Knight(true, "knightB", 2, 2);
        Knight knightC = new Knight(false, "knightC", 1, 3);
        board[3][3]=knightB;
        board[1][3]=knightC;
        // Test that it does not capture its own team
        assertEquals("ERROR [You cannot capture your own piece]", knightA.movePiece(3, 3, true, board));
        // Test that it captures pieces of another color
        assertEquals("true", knightA.movePiece(1, 3, true, board));
    }
    
}
