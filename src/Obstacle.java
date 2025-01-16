import sas.*;
import java.awt.Color;


public class Obstacle {


    private Tree block;


    private double x;


    private double y;


    public Obstacle(double pX, double pY) {
        x = pX;
        y = pY;

    }


    public void move(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
        block.move(deltaX, deltaY);
    }


    public void setX(double pX) {
        x = pX;
        block.move(x, y);
    }


    public void setY(double pY) {
        y = pY;
        block.move(x, y);
    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }
}
