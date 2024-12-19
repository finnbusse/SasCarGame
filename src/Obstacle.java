import sas.*;
import java.awt.Color;

public class Obstacle {

    Rectangle block;
    private double x, y, pX, pY;

    public Obstacle(double pX, double pY) {
        this.x = pX;
        this.y = pY;
        this.block = new Rectangle(pX,pY,100,100,Color.RED);

    }

    public void move(double x, double y) {
        this.pX = x;
        this.pY = y;


        this.block.moveTo(this.pX + this.getX(), this.pY + this.getY());




    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
