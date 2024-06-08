import greenfoot.*;

/**
 * June 6, 2024
 * ICS 4U1
 * Janky Kong
 */
public class BackGround1 extends World
{

    /**
     * Constructor for objects of class BackGround1.
     */
    


    public BackGround1()
    {    
        super(1050, 900, 1);
        
        addObject(new DK(), 200, 150); // donkey kong
        
        // top left
        addObject(new Floor(1), 125, 219);
        addObject(new Floor(1), 25, 219);
        addObject(new Floor(1), 225, 219);
        addObject(new Floor(1), 325, 219 + 10);
        addObject(new Floor(1), 425, 219 + 15);
        addObject(new Floor(1), 525, 219 + 20);
        addObject(new Floor(1), 625, 219 + 25);
        addObject(new Floor(1), 725, 219 + 30);
        addObject(new Floor(1), 825, 219 + 35);
        
        
        // top right

        addObject(new Floor(-1), 1000, 525);
        addObject(new Floor(-1), 900, 525 + 5);
        addObject(new Floor(-1), 800, 525 + 10);
        addObject(new Floor(-1), 700, 525 + 15);
        addObject(new Floor(-1), 600, 525 + 20);
        addObject(new Floor(-1), 500, 525 + 25);
        addObject(new Floor(-1), 400, 525 + 30);
        addObject(new Floor(-1), 300, 525 + 35);
        addObject(new Floor(-1), 200, 525 + 40);

        
        // bottom left
        addObject(new Floor(1), 50, 850 + 5);
        addObject(new Floor(1), 150, 850 + 10);
        addObject(new Floor(1), 250, 850 + 15);
        addObject(new Floor(1), 350, 850 + 20);
        addObject(new Floor(1), 450, 850 + 25);
        addObject(new Floor(1), 550, 850 + 30);
        addObject(new Floor(1), 650, 850 + 35);
        addObject(new Floor(1), 750, 850 + 40);
        addObject(new Floor(1), 850, 850 + 45);
        addObject(new Floor(1), 950, 850 + 50);
        addObject(new Floor(1), 1050, 850 + 55);

        
        addObject(new Mario(), 950, 850); // mario
    }
}
