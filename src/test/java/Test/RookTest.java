package Test;
import Logic.Piece;
import Logic.Rook;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RookTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Rook rookA = new Rook (true, "rookA", 1, 1);
        // Test that it does not move if the movement is not V or H
        assertEquals("ERROR [You are not moving horizontally or vertically]",rookA.movePiece(2,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Rook rookA = new Rook (true, "rookA", 1, 1);
        Rook rookB = new Rook (true, "rookA", 1, 5);
        board[1][5]=rookB;
        // Test that it does not capture its own team
        assertEquals("ERROR [You cannot capture your own piece]", rookA.movePiece(1, 5, true, board));
    }
    public void OthersTest(){
        Piece[][] board = new Piece[8][8];
        Rook rookA = new Rook (true, "rookA", 1, 1);
        Rook rookB = new Rook (true, "rookB", 1, 5);
        Rook rookC = new Rook (true, "rookC", 3, 1);
        Rook rookD = new Rook (false, "rookD", 2, 1);
        board[1][5]=rookB;
        board[3][1]=rookC;
        board[2][1]=rookD;
        // Test that it does not jump over pieces vertically
        assertEquals("ERROR [Vertical movement, you cannot move, there is a piece blocking your path]", rookA.movePiece(1, 6, true, board));
        // Test that it does not jump over pieces horizontally
        assertEquals("ERROR [Horizontal movement, you cannot move, there is a piece blocking your path]", rookA.movePiece(3, 2, true, board));
        // Test that it captures pieces of another color
        assertEquals("true", rookA.movePiece(2, 1, true, board));
    }

}
