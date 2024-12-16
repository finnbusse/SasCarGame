import sas.*;
import java.awt.Color;

public class Game {

    View window;
    Auto auto;



    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        window = new View(1000,700);
        auto = new Auto(50,300);

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
        }
    }
}