import sas.*;
public class Test {

    View window;
    Tree tree;

    public static void main(String[] args) {new Test();}
    Test(){

        window = new View(1000, 1000);
        tree = new Tree(100, 100);

        System.out.println(tree.getX());


        window.wait(1000);
        System.out.println("1000");

        tree.move(200, 200);





    }
}
