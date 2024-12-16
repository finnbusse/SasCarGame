import sas.Circle;
import sas.Polygon;

import java.awt.*;

public class Auto {
    private Circle rad1;
    private Circle rad2;
    private Circle licht;
    private Polygon karosse;
    private double x;
    private double y;

    public Auto(double pX, double pY) {
        this.x = pX;
        this.y = pY;
        this.karosse = new Polygon(pX + (double)10.0F, pY + (double)30.0F);
        this.karosse.add((double)50.0F, (double)-30.0F);
        this.karosse.add((double)100.0F, (double)-30.0F);
        this.karosse.add((double)150.0F, (double)0.0F);
        this.karosse.add((double)180.0F, (double)0.0F);
        this.karosse.add((double)190.0F, (double)30.0F);
        this.karosse.add((double)-10.0F, (double)30.0F);
        this.karosse.setColor(Color.RED);
        this.rad1 = new Circle(this.x + (double)30.0F, this.y + (double)50.0F, (double)15.0F, Color.BLACK);
        this.rad2 = new Circle(this.x + (double)130.0F, this.y + (double)50.0F, (double)15.0F, Color.BLACK);
        this.licht = new Circle(this.x + (double)200.0F, this.y + (double)50.0F, (double)5.0F, Color.YELLOW);
    }

    public void setX(double pX) {
        if (pX > (double)-50.0F && pX < (double)150.0F) {
            this.x = pX;
            this.karosse.moveTo(this.x + (double)10.0F, this.y);
            this.rad1.moveTo(this.x + (double)30.0F, this.y + (double)50.0F);
            this.rad2.moveTo(this.x + (double)130.0F, this.y + (double)50.0F);
            this.licht.moveTo(this.x + (double)200.0F, this.y + (double)50.0F);
        }

    }

    public void setY(double pY) {
        if (pY > (double)0.0F && pY < (double)600.0F) {
            this.y = pY;
            this.karosse.moveTo(this.x + (double)10.0F, this.y);
            this.rad1.moveTo(this.x + (double)30.0F, this.y + (double)50.0F);
            this.rad2.moveTo(this.x + (double)130.0F, this.y + (double)50.0F);
            this.licht.moveTo(this.x + (double)200.0F, this.y + (double)50.0F);
        }

    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getWidth() {
        return (double)200.0F;
    }

    public double getHeight() {
        return (double)65.0F;
    }

    public void hide() {
        this.karosse.setHidden(true);
    }

    public void show() {
        this.karosse.setHidden(false);
    }
}
