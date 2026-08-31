package Test;
import Logic.Bishop;
import Logic.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BishopTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Bishop bishop = new Bishop(true, "bishop", 3, 1);
        // Test that it only moves diagonally
        assertEquals("ERROR [Invalid move, not diagonal]",bishop.movePiece(3,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Bishop bishopA = new Bishop(true, "bishopA", 3, 1);
        Bishop bishopB = new Bishop(true, "bishopB", 2, 2);
        board[2][2]=bishopB;
        // Test that it does not capture its own team
        assertEquals("ERROR [You cannot capture your own piece]", bishopA.movePiece(2, 2, true, board));
    }
    @Test
    public void OthersTest(){
        Piece[][] board = new Piece[8][8];
        Bishop bishopA = new Bishop(true, "bishopA", 3, 1);
        Bishop bishopB = new Bishop(true, "bishopB", 2, 2);
        Bishop bishopC = new Bishop(false, "bishopC", 4, 2);
        board[2][2]=bishopB;
        board[4][4]=bishopC;
        // Test that it does not jump over pieces
        assertEquals("ERROR [Cannot move, a piece is blocking your path]", bishopA.movePiece(1, 3, true, board));
        // Test that it captures pieces of another color
        assertEquals("true", bishopA.movePiece(4, 2, true, board));
    }
}
