import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World {

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2() {    
        super(1050, 900, 1);

        addObject(new DK(), 200, 150 - 75); // DK

        // top left
        addObject(new Floor(1, -20), 125, 150);
        addObject(new Floor(1, -20), 25, 150);
        addObject(new Floor(1, -20), 225, 150);
        addObject(new Floor(1, -20), 325, 150 + 10);
        addObject(new Floor(1, -20), 425, 150 + 15);
        addObject(new Floor(1, -20), 525, 150 + 20);
        addObject(new Floor(1, -20), 625, 150 + 25);
        addObject(new Floor(1, -20), 725, 150 + 30);
        addObject(new Floor(1, -20), 825, 150 + 35);

        // top right
        addObject(new Floor(-1, -27), 1000, 425);
        addObject(new Floor(-1, -20), 900, 425 + 5);
        addObject(new Floor(-1, -20), 800, 425 + 10);
        addObject(new Floor(-1, -20), 700, 425 + 15);
        addObject(new Floor(-1, -20), 600, 425 + 20);
        addObject(new Floor(-1, -20), 500, 425 + 25);
        addObject(new Floor(-1, -20), 400, 425 + 30);
        addObject(new Floor(-1, -20), 300, 425 + 35);
        addObject(new Floor(-1, -20), 200, 425 + 40);

        // 3rd row
        addObject(new Floor(1, -27), 50, 700 + 5);
        addObject(new Floor(1, -20), 150, 700 + 10);
        addObject(new Floor(1, -20), 250, 700 + 15);
        addObject(new Floor(1, -20), 350, 700 + 20);
        addObject(new Floor(1, -20), 450, 700 + 25);
        addObject(new Floor(1, -20), 550, 700 + 30);
        addObject(new Floor(1, -20), 650, 700 + 35);
        addObject(new Floor(1, -20), 750, 700 + 40);
        addObject(new Floor(1, -20), 850, 700 + 45);

        // bottom left
        addObject(new Floor(-1, -27), 50, 910);
        addObject(new Floor(-1, -20), 150, 910);
        addObject(new Floor(-1, -20), 250, 910);
        addObject(new Floor(-1, -20), 350, 910);
        addObject(new Floor(-1, -20), 450, 910);
        addObject(new Floor(-1, -20), 550, 910);
        addObject(new Floor(-1, -20), 650, 910);
        addObject(new Floor(-1, -20), 750, 910);
        addObject(new Floor(-1, -20), 850, 910);
        addObject(new Floor(-1, -20), 950, 910);
        addObject(new Floor(-1, -20), 1050, 910);

        //First Ladder
        addObject(new Ladder(), 700, 830);

        //Second Ladder
        addObject(new Ladder(), 200, 560);
        addObject(new Ladder(), 200, 592);

        //Third Ladder
        addObject(new Ladder(), 800, 280);
        addObject(new Ladder(), 800, 312);

        addObject(new OilBarrel(), 850, 640); // mario
        addObject(new Mario(), 125, 850); // mario
        addObject(new Princess(), 60, 170 - 75); // princess
        addObject(new Luigi(), 150, 850); // luigi
    }
}
