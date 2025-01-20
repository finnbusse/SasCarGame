import sas.*;
import java.awt.Color; 
// import java.*;// Import der Klasse Color, um einfacher auf die Farben zuzugreifen.

class SASPolygonEditor
{
    // Deklarationen
    View fenster;

    public static void main(String[] args) {
        new SASPolygonEditor();
    }

    Rectangle viewport,box;

    Text xPos,yPos,hint;
    Polygon[] poly;
    Rectangle[] rect;
    int count = 0;
    double startX = 0;
    double startY = 0;
    boolean isFirst = true;
    Color[] color = new Color[]{Color.BLACK, Color.GREEN, Color.BLUE, Color.YELLOW, 
            Color.LIGHT_GRAY, Color.ORANGE, new Color(100,100,100), Color.MAGENTA,
            new Color(20,200,100), new Color(200,70,10), 
            new Color(100,200,150), new Color(190,3,70),
            new Color(0,200,50), new Color(10,250,200),
            new Color(50,0,250), new Color(50,10,150),
            Color.RED, new Color(255,255,255)
        };
    // public Kugel kugel1,kugel2, kugel3, kugel4, kugel5, kugel6;

    // Konstruktor dieser Klasse
    SASPolygonEditor()
    {
        // Initialisierungen
        fenster = new View(1000,750,"SAS Polygon Editor");
        viewport = new Rectangle(0,0,1000,750,Color.WHITE);
        //
        for (int i = 0;i < 100;i++) {
            new Rectangle(i*10,0,1,750,Color.LIGHT_GRAY);
        }
        for (int i = 0;i < 75;i++) {
            new Rectangle(0,i*10-1,1000,1,Color.LIGHT_GRAY);
        }

        rect = new Rectangle[18];
        for (int i = 0;i < 18;i++) {
            rect[i] = new Rectangle(950,i*38+10,40,28,color[i]);
        }

        // box      = new Rectangle(10,10,50,50,Color.GREEN); 
        poly     =   new Polygon[20];
        // rect = new Rectangle[18]; // poly[0]  = new Polygon (300,200);
        // poly[0].
        //System.out.print("Polygon polygon1;\n\npolygon1 = new Polygon(300,200);\n\n");
        //Circle c1 = new Circle (300-2,200-2,2,Color.RED);
        xPos = new Text (10,10,"X = ...");
        yPos = new Text (10,50,"Y = ...");
        hint = new Text (5,700,"Cmd: new (p)oly (first active!),( ) turn,(1-6) scale,(d)elete&new poly,(a,w,s,y,...) move,poly(c)ircle");
        //yyPos = new Text (10,130,"Y2 = ...");
        new Rectangle(280,199,40,2,Color.BLACK);        
        new Rectangle(299,180,2,40,Color.BLACK);
        // new Circle(300,200,150,Color.LIGHT_GRAY);
        showQuickGuide();
        run();
    }

    void showQuickGuide(){
        System.out.print("//#####################################\n");
        System.out.print("//#  SAS P o l y g o n  E d i t o r   #\n");
        System.out.print("//#####################################\n");
        System.out.print("//#     K u r z a n l e i t u n g     #\n");
        System.out.print("//#####################################\n");

        System.out.print("// 1. In der Konsole 'unlimited Buffer'\n");
        System.out.print("//    aktivieren und ggf. Log-Text löschen\n");
        System.out.print("// 2. Veränderungen am Polygon nur möglich,\n");
        System.out.print("//    solange 'aktiv' \n");
        System.out.print("// 3. Auch MouseDragged (= Stift) funktioniert\n"); 
        System.out.print("// 4. Wähle immer aktiv eine Farbe aus,\n");
        System.out.print("//    sonst bleibt das Polygon schwarz !\n");
        System.out.print("// 5. Gesamten Log-Text in den Konstruktor\n");
        System.out.print("//    der Klasse 'PolyTemplate' kopieren\n");
        System.out.print("//    und in der Klasse 'TestPoly...' testen \n");
        System.out.print("//#####################################\n\n\n");

        
    }
    // Methoden
    void run() {     

        while (!fenster.keyEnterPressed()) {
            fenster.wait(10);
            if (fenster.keyPressed('p')) {
                fenster.wait(500);
                count++;
                isFirst = true;
                startX = 0;
                startY = 0;

            }

            if (fenster.keyPressed(' ')) {
                fenster.wait(30);
                poly[count].turn(1); // setHidden(true);
                System.out.print("polygon"+(count+1)+".turn(1);\n");           
            }

            if (fenster.keyPressed('6')) {
                fenster.wait(150);
                poly[count].scale(1,1.1); // setHidden(true);
                System.out.print("polygon"+(count+1)+".scale(1,1.1);\n");            
            }

            if (fenster.keyPressed('5')) {
                fenster.wait(150);
                poly[count].scale(1,0.9); // setHidden(true);
                System.out.print("polygon"+(count+1)+".scale(1,0.9);\n");            
            }

            if (fenster.keyPressed('4')) {
                fenster.wait(150);
                poly[count].scale(1.1,1); // setHidden(true);
                System.out.print("polygon"+(count+1)+".scale(1.1,1);\n");            
            }

            if (fenster.keyPressed('3')) {
                fenster.wait(150);
                poly[count].scale(0.9,1); // setHidden(true);
                System.out.print("polygon"+(count+1)+".scale(0.9,1);\n");            
            }

            if (fenster.keyPressed('2')) {
                fenster.wait(150);
                poly[count].scale(1.1,1.1); // setHidden(true);
                System.out.print("polygon"+(count+1)+".scale(1.1,1.1);\n");            
            }

            if (fenster.keyPressed('1')) {
                fenster.wait(150);
                poly[count].scale(0.9,0.9); // setHidden(true);
                System.out.print("polygon"+(count+1)+".scale(0.9,0.9);\n"); 
            }

            if (fenster.keyLeftPressed()) {
                fenster.wait(50);
                poly[count].move(-3,0); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(-3,0);\n"); 
            }

            if (fenster.keyRightPressed()) {
                fenster.wait(50);
                poly[count].move(3,0); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(3,0);\n"); 
            }

            if (fenster.keyUpPressed()) {
                fenster.wait(50);
                poly[count].move(0,-3); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(0,-3);\n"); 
            }

            if (fenster.keyDownPressed()) {
                fenster.wait(50);
                poly[count].move(0,3); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(0,3);\n"); 
            }

            if (fenster.keyPressed('a')) {
                fenster.wait(50);
                poly[count].move(-1,0); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(-1,0);\n"); 
            }

            if (fenster.keyPressed('w')) {
                fenster.wait(50);
                poly[count].move(0,-1); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(0,-1);\n"); 
            }

            if (fenster.keyPressed('s')) {
                fenster.wait(50);
                poly[count].move(1,0); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(1,0);\n"); 
            }

            if (fenster.keyPressed('y')) {
                fenster.wait(50);
                poly[count].move(0,1); // setHidden(true);
                System.out.print("polygon"+(count+1)+".move(0,1);\n"); 
            }

            if (fenster.keyPressed('d')) {
                fenster.wait(500);
                poly[count].setHidden(true);
                System.out.print("polygon"+(count+1)+".setHidden(true);\n"); //+");\n");
                count++;
                isFirst = true;
                startX = 0;
                startY = 0;

            }

            if (fenster.keyPressed('c')) {
                fenster.wait(500);
                count++;
                isFirst = true;
                poly[count] = new Polygon(150,0,color[count]);     
                System.out.print("\n\npolygon"+(count+1)+" = new Polygon(-150,-200);\n\n");

                String s = "polygon"+(count+1)+".add(42.0,6.0);\n";
                s += "polygon"+(count+1)+".add(79.0,23.0);\n";
                s += "polygon"+(count+1)+".add(114.0,52.0);\n";
                s += "polygon"+(count+1)+".add(134.0,81.0);\n";
                s += "polygon"+(count+1)+".add(149.0,122.0);\n";
                s += "polygon"+(count+1)+".add(152.0,163.0);\n";
                s += "polygon"+(count+1)+".add(144.0,194.0);\n";
                s += "polygon"+(count+1)+".add(131.0,228.0);\n";
                s += "polygon"+(count+1)+".add(109.0,254.0);\n";
                s += "polygon"+(count+1)+".add(84.0,277.0);\n";
                s += "polygon"+(count+1)+".add(56.0,290.0);\n";
                s += "polygon"+(count+1)+".add(23.0,300.0);\n";
                s += "polygon"+(count+1)+".add(-15.0,300.0);\n";
                s += "polygon"+(count+1)+".add(-55.0,289.0);\n";
                s += "polygon"+(count+1)+".add(-90.0,269.0);\n";
                s += "polygon"+(count+1)+".add(-113.0,247.0);\n";
                s += "polygon"+(count+1)+".add(-131.0,219.0);\n";
                s += "polygon"+(count+1)+".add(-144.0,188.0);\n";
                s += "polygon"+(count+1)+".add(-148.0,150.0);\n";
                s += "polygon"+(count+1)+".add(-144.0,109.0);\n";
                s += "polygon"+(count+1)+".add(-125.0,69.0);\n";
                s += "polygon"+(count+1)+".add(-103.0,41.0);\n";
                s += "polygon"+(count+1)+".add(-76.0,20.0);\n";
                s += "polygon"+(count+1)+".add(-38.0,4.0);\n";

                System.out.print (s);

                poly[count].add(42.0,6.0);
                poly[count].add(79.0,23.0);
                poly[count].add(114.0,52.0);
                poly[count].add(134.0,81.0);
                poly[count].add(149.0,122.0);
                poly[count].add(152.0,163.0);
                poly[count].add(144.0,194.0);
                poly[count].add(131.0,228.0);
                poly[count].add(109.0,254.0);
                poly[count].add(84.0,277.0);
                poly[count].add(56.0,290.0);
                poly[count].add(23.0,300.0);
                poly[count].add(-15.0,300.0);
                poly[count].add(-55.0,289.0);
                poly[count].add(-90.0,269.0);
                poly[count].add(-113.0,247.0);
                poly[count].add(-131.0,219.0);
                poly[count].add(-144.0,188.0);
                poly[count].add(-148.0,150.0);  
                poly[count].add(-144.0,109.0);
                poly[count].add(-125.0,69.0);
                poly[count].add(-103.0,41.0);
                poly[count].add(-76.0,20.0);
                poly[count].add(-38.0,4.0);

                //      new Circle(viewport.getMouseX()-2,viewport.getMouseY()-2,2,Color.RED);
                startX = 150; // viewport.getMouseX();
                startY = 0; // sdfsdf viewport.getMouseY();               
                isFirst = false;
            }

            if ((viewport.mouseClicked() || viewport.mouseDragged()) && viewport.getMouseX() < 945) {
                if (isFirst == true) {
                    poly[count] = new Polygon(viewport.getMouseX(),viewport.getMouseY(),color[count]);
                    new Circle(viewport.getMouseX()-2,viewport.getMouseY()-2,2,Color.RED);
                    System.out.print("\n\npolygon"+(count+1)+" = new Polygon("+(viewport.getMouseX()-300)+","+(viewport.getMouseY()-200)+");\n\n");
                    isFirst = false;
                    startX = viewport.getMouseX();
                    startY = viewport.getMouseY();
                    xPos.setText("X = " + (viewport.getMouseX()-300));
                    yPos.setText("Y = " + (viewport.getMouseY()-200));                    
                }
                else {

                    xPos.setText("X = " + (viewport.getMouseX()-300));
                    yPos.setText("Y = " + (viewport.getMouseY()-200));
                    //xxPos.setText("X2 = " + box.getMouseX());
                    //yyPos.setText("Y2 = " + box.getMouseY());             
                    poly[count].add(viewport.getMouseX()-startX,viewport.getMouseY()-startY);
                    new Circle(viewport.getMouseX()-2,viewport.getMouseY()-2,2,Color.RED);
                    System.out.print("polygon"+(count+1)+".add("+(viewport.getMouseX()-startX)+","+(viewport.getMouseY()-startY)+");\n");
                }
            } else {
                for (int i = 0; i < 18; i++) {                
                    if (poly[count] != null && rect[i].mouseClicked()) {                    
                        poly[count].setColor(color[i]);
                        String tempStr;
                        switch (i) {
                            case 0  : tempStr = "Color.BLACK"; break;
                            case 1  : tempStr = "Color.GREEN"; break;
                            case 2  : tempStr = "Color.BLUE"; break;
                            case 3  : tempStr = "Color.YELLOW"; break;
                            case 4  : tempStr = "Color.LIGHT_GRAY"; break;
                            case 5  : tempStr = "Color.ORANGE"; break;
                            case 6  : tempStr = "new Color(100,100,100)"; break;
                            case 7  : tempStr = "Color.MAGENTA"; break;
                            case 8  : tempStr = "new Color(20,200,100)"; break;
                            case 9  : tempStr = "new Color(200,70,10)"; break;
                            case 10 : tempStr = "new Color(100,200,150)"; break;
                            case 11 : tempStr = "new Color(190,3,70)"; break;
                            case 12 : tempStr = "new Color(0,200,50)"; break;
                            case 13 : tempStr = "new Color(10,250,200)"; break;
                            case 14 : tempStr = "new Color(50,0,250)"; break;
                            case 15 : tempStr = "new Color(50,10,150)"; break;
                            case 16 : tempStr = "Color.RED"; break;
                            case 17 : tempStr = "new Color(255,255,255)"; break;

                            default : tempStr = "Color.BLACK)";

                        }
                        System.out.print("polygon"+(count+1)+".setColor("+tempStr+");\n");  
                        break;
                    }
                    // String a = Color.RED.toString();
                }// setting Colors
            }

        }
    }
    // kugel1 animieren. Beenden mit Tastendruck
}
