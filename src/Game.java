import sas.*;
import java.awt.Color;

public class Game {

    View window;
    Auto auto;
    Obstacle[] hindernisse;



    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        window = new View(1000,700);
        auto = new Auto(50,300);

        hindernisse = new Obstacle[6];

        for (int i =0; i<6; i++) {
            hindernisse[i] = new Obstacle(100+i*400, i*150);
        }

        startGame();

    }

    public void startGame() {
        while (true) {
            window.wait(1);

            if (window.keyUpPressed()) {
                auto.setY(auto.getY() - 1);

            }

            if (window.keyDownPressed()) {
                auto.setY(auto.getY() + 1);


            }

            for (int i = 0; i<6; i++) {
                hindernisse[i].move(-1,0);

                if (hindernisse[i].getX < 0) {
                    hindernisse[i].setX(1000);
                }
            }


        }
    }
}