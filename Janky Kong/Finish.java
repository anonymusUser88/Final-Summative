import greenfoot.*;

/**
 * Write a description of class Finish here.
 * June 15, 2024
 */
public class Finish extends World
{

    /**
     * Constructor for objects of class Finish.
     */
    public Finish()  // REPLACE THIS WITH SOMETHING ELSE IF NEEDED
    {    
        super(1050, 900, 1); 
        
        // top left
        addObject(new Floor(1, -20), 125, 219);
        addObject(new Floor(1, -20), 25, 219);
        addObject(new Floor(1, -20), 225, 219);
        addObject(new Floor(1, -20), 325, 219 + 10);
        addObject(new Floor(1, -20), 425, 219 + 15);
        addObject(new Floor(1, -20), 525, 219 + 20);
        addObject(new Floor(1, -20), 625, 219 + 25);
        addObject(new Floor(1, -20), 725, 219 + 30);
        addObject(new Floor(1, -20), 825, 219 + 35);

        // top right
        addObject(new Floor(-1, -27), 1000, 525);
        addObject(new Floor(-1, -20), 900, 525 + 5);
        addObject(new Floor(-1, -20), 800, 525 + 10);
        addObject(new Floor(-1, -20), 700, 525 + 15);
        addObject(new Floor(-1, -20), 600, 525 + 20);
        addObject(new Floor(-1, -20), 500, 525 + 25);
        addObject(new Floor(-1, -20), 400, 525 + 30);
        addObject(new Floor(-1, -20), 300, 525 + 35);
        addObject(new Floor(-1, -20), 200, 525 + 40);

        // bottom left
        addObject(new Floor(1, -27), 50, 850 + 5);
        addObject(new Floor(1, -20), 150, 850 + 10);
        addObject(new Floor(1, -20), 250, 850 + 15);
        addObject(new Floor(1, -20), 350, 850 + 20);
        addObject(new Floor(1, -20), 450, 850 + 25);
        addObject(new Floor(1, -20), 550, 850 + 30);
        addObject(new Floor(1, -20), 650, 850 + 35);
        addObject(new Floor(1, -20), 750, 850 + 40);
        addObject(new Floor(1, -20), 850, 850 + 45);
        addObject(new Floor(1, -20), 950, 850 + 50);
        addObject(new Floor(1, -20), 1050, 850 + 55);

        // there are different conditions depending on who got to the top
        addObject(new Princess(), 100, 170); // princess
        addObject(new Mario(), 150, 170); // mario
        addObject(new Luigi(), 175, 170); // luigi
        
        showText("YOU WIN", 750, 170);
        
        Greenfoot.stop();
    }
}
