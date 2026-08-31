package Logic;

import Logic.Interface.Moveable;

public abstract class Piece implements Moveable, Cloneable {

    // When the piece is white, this variable is true
    protected boolean color = true;
    // The name is the piece's symbol
    protected String name = "";
    // Location in the matrix, X axis
    protected int positionX = 0;
    // Location in the matrix, Y axis
    protected int positionY = 0;

    // Main Methods
    public boolean verifyRange(int coordX, int coordY){
        if(coordX<9 && coordX>0 && coordY<9 && coordY>0){
            return true;
        }
        return false;
    }

    // Getters
    public boolean getColor(){
        return color;
    }
    public String getName(){
        return name;
    }
    public int getPositionX(){
        return positionX;
    }
    public int getPositionY(){
        return positionY;
    }
    // Constructor
    public Piece(boolean color, String name, int positionX, int positionY) {
        this.color = color;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;

    }

    @Override
    public String toString() {
        return "Selected piece: "+this.getName()+"\nNew position X: "+(char)(getPositionX()+64)+" Y: "+getPositionY();
    }

    
}