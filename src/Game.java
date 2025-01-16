import sas.*;

public class Game {

    View window;
    Auto auto;
    Tree[] trees;

    boolean gameOver;


    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        window = new View(1000, 700);
        auto = new Auto(50, 300);

        trees = new Tree[100];

        for (int i = 0; i < 100; i++) {
            trees[i] = new Tree(400 + i * 500, Tools.randomNumber(0, 500));
        }

        startGame();

    }

    public void startGame() {
        while (gameOver == !true) {
            window.wait(1);
            System.out.println(trees[1].getX());

            if (window.keyUpPressed()) {
                auto.setY(auto.getY() - 1);

            }

            if (window.keyDownPressed()) {
                auto.setY(auto.getY() + 1);


            }

            for (int i = 0; i < 100; i++) {
                trees[i].move(-0.5, 0);

                if (trees[i].getX() < -167) {
                    trees[i].setX(1000);
                }

                if (auto.getX() < trees[i].getX() + 167 &&  // Prüfe, ob das Auto im rechten Bereich des Hindernisses ist
                        auto.getX() + auto.getWidth() > trees[i].getX() &&  // Prüfe, ob das Auto im linken Bereich des Hindernisses ist
                        auto.getY() < trees[i].getY() + 414 &&  // Prüfe, ob das Auto im unteren Bereich des Hindernisses ist
                        auto.getY() + auto.getHeight() > trees[i].getY()) {  // Prüfe, ob das Auto im oberen Bereich des Hindernisses ist
                    gameOver = true;
                }


            }


        }
    }
}