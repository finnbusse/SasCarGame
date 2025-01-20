import sas.*;

public class Game {

    View window;
    private Auto auto;
    private Tree[] trees;
    private Cybertruck[] cybertrucks;

    boolean gameOver;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new View(1000, 700);
        auto = new Auto(50, 300);

        // Nur ein Baum pro x-Position
        trees = new Tree[100];
        cybertrucks = new Cybertruck[100];

        for (int i = 0; i < trees.length; i++) {
            double x = 600 + i * 1000;  // Verteile die Bäume entlang der X-Achse
            double y = Tools.randomNumber(0, 500);  // Zufällige Y-Position
            trees[i] = new Tree(x, y);
        }




        startGame();
    }

    public void startGame() {
        while (!gameOver) {
            window.wait(1);

            if (window.keyUpPressed()) {
                auto.setY(auto.getY() - 1);
            }

            if (window.keyDownPressed()) {
                auto.setY(auto.getY() + 1);
            }

            for (int i = 0; i < trees.length; i++) {
                trees[i].move(-0.5, 0);

                // Baum zurücksetzen, wenn er aus dem Sichtfeld ist
                if (trees[i].getX() < -167) {
                    trees[i].setX(-1000);
                    trees[i].setY(Tools.randomNumber(0, 500)); // Neue zufällige Y-Position
                }

                // Kollisionserkennung
                if (auto.getX() < trees[i].getX() + 167 &&  // Rechter Bereich des Hindernisses
                        auto.getX() + auto.getWidth() > trees[i].getX() &&  // Linker Bereich des Hindernisses
                        auto.getY() < trees[i].getY() + 414 &&  // Unterer Bereich des Hindernisses
                        auto.getY() + auto.getHeight() > trees[i].getY()) {  // Oberer Bereich des Hindernisses
                    gameOver = true;
                }
            }
        }
    }
}

