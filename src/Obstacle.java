import sas.*;
import java.awt.Color;


public class Obstacle {


    private Rectangle block;


    private double x;


    private double y;


    public Obstacle(double pX, double pY) {
        x = pX;
        y = pY;
        block = new Rectangle(pX, pY, 100, 100, Color.RED);
    }


    public void move(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
        block.move(deltaX, deltaY);
    }


    public void setX(double pX) {
        x = pX;
        block.moveTo(x, y);
    }


    public void setY(double pY) {
        y = pY;
        block.moveTo(x, y);
    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }
}
