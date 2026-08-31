package View;

import Controller.ControllerA;
import Logic.Piece;
import Logic.Exceptions.CustomWinException;

import java.util.Scanner;

public class Main  {

    // Instances
    static ControllerA control = new ControllerA();
    static Main boardView = new Main();
    public static void main(String[] args) {
             
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Chess");
        // Print board
        try {
            do {
                boardView.options();
            }while (true);
        } catch (CustomWinException e) {
            System.err.println("WOW..... you have won"+ "\nTHANK YOU FOR PLAYING"
            +"\n\n\nBy: David S and Jose S");
        }
    }

    public void printBoard(Piece[][] cloneBoard) {

        char c = 'A';
        for (int i = 0; i < cloneBoard.length; i++){
            System.out.print(i);
            for (int j = 0; j < cloneBoard[i].length ; j++){
                if(cloneBoard[j][i] != null) {
                    System.out.print(cloneBoard[j][i].getName()+"\t");
                } else if (j==0) {
                    System.out.print("\t");
                } else if (i==0) {
                    System.out.print(c+"\t");
                    c=++c;
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println("");
        }
    }
    public void options() throws CustomWinException{
        Scanner scanner = new Scanner(System.in);
        
        boardView.printBoard(control.getBoardPieces());
            // Ask for data

            System.out.println("Select a piece using its coordinates");

            System.out.print("Please enter ... \nCoordinate X: ");
            String coordX = scanner.nextLine();
            System.out.print("Please enter... \nCoordinate Y: ");
            String coordY = scanner.nextLine();

            System.out.print("Enter the X coordinate where you want to move the piece: ");
            String newCoordX = scanner.nextLine();
            System.out.print("Enter the Y coordinate where you want to move the piece: ");
            String newCoordY = scanner.nextLine();
            // call the verify data method
            System.out.println(control.verifyData(coordX, coordY, newCoordX, newCoordY));

    }
}