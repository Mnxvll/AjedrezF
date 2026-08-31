package Test;
import Logic.King;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class KingTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        King king = new King(true, "king", 4, 1);
       // Test that the king only moves one square
        assertEquals("ERROR [Invalid move according to chess rules]",king.movePiece(4,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        King kingA = new King(true, "kingA", 4, 1);
        King kingB = new King(true, "kingB", 4, 2);
        King kingC = new King(false, "kingC", 3, 1);
        board[4][2]=kingB;
        board[3][1]=kingC;
        // Test that it does not capture its own team
        assertEquals("ERROR [You cannot capture your own piece]", kingB.movePiece(4, 2, true, board));
        // Test that it captures pieces of another color
        assertEquals("true", kingA.movePiece(3, 1, true, board));
    }
}
