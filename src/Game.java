import sas.*;

import java.awt.Color;

public class Game {

    View window;
    Auto auto;
    Obstacle[] hindernisse;

    boolean gameOver;


    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        window = new View(1000, 700);
        auto = new Auto(50, 300);

        hindernisse = new Obstacle[6];

        for (int i = 0; i < 6; i++) {
            hindernisse[i] = new Obstacle(100 + i * 500, i * 200);
        }

        startGame();

    }

    public void startGame() {
        while (gameOver == !true) {
            window.wait(1);

            if (window.keyUpPressed()) {
                auto.setY(auto.getY() - 1);

            }

            if (window.keyDownPressed()) {
                auto.setY(auto.getY() + 1);


            }

            for (int i = 0; i < 6; i++) {
                hindernisse[i].move(-0.5, 0);

                if (hindernisse[i].getX() < -100) {
                    hindernisse[i].setX(1000);
                }

                if (auto.getX() < hindernisse[i].getX() + 100 &&
                        auto.getX() + 50 > hindernisse[i].getX() &&
                        auto.getY() < hindernisse[i].getY() + 100 &&
                        auto.getY() + 100 > hindernisse[i].getY()) {
                    gameOver = true;
                }

            }


        }
    }
}