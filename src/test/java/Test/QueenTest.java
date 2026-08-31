package Test;
import Logic.Piece;
import Logic.Queen;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Queen queen = new Queen (true, "queen", 5, 1);
        // Test that it does not move like a knight
        assertEquals("ERROR [Invalid movement]",queen.movePiece(4,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Queen queenA = new Queen (true, "queenA", 5, 1);
        Queen queenB = new Queen (true, "queenB", 5, 2);
        board[5][2]=queenB;
        // Test that it does not capture its own team
        assertEquals("ERROR [You cannot capture your own piece]", queenA.movePiece(5, 2, true, board));
    }
    @Test
    public void OthersTest(){
        Piece[][] board = new Piece[8][8];
        Queen queenA = new Queen (true, "queenA", 5, 1);
        Queen queenB = new Queen (true, "queenB", 5, 2);
        Queen queenC = new Queen (true, "queenC", 4, 2);
        Queen queenD = new Queen (false, "queenD", 6, 2);
        board[5][2]=queenB;
        board[4][2]=queenC;
        board[6][2]=queenD;
        // Test that it does not jump over pieces vertically
        assertEquals("ERROR [Vertical movement, you cannot move, a piece is blocking your path]", queenA.movePiece(5, 3, true, board));
        // Test that it does not jump over pieces diagonally
        assertEquals("ERROR [Cannot move, a piece is blocking your path]", queenA.movePiece(3, 3, true, board));
        // Test that it captures pieces of another color
        assertEquals("true", queenA.movePiece(6, 2, true, board));
    }
}
