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
        addObject(new Floor(-1), 625, 475);
        addObject(new Floor(-1), 875, 475);
        addObject(new Floor(-1), 1125, 475);
        addObject(new Floor(-1), 1375, 475);
        
        // bottom left
        addObject(new Floor(1), 125, 700);
        addObject(new Floor(1), 375, 700);
        addObject(new Floor(1), 625, 700);
        
        // ground floor
        addObject(new Floor(-1), 125, 1000);
        addObject(new Floor(-1), 375, 1000);
        addObject(new Floor(-1), 625, 1000);
        addObject(new Floor(-1), 875, 1000);
        addObject(new Floor(-1), 1125, 1000);
        addObject(new Floor(-1), 1375, 1000);
        
        addObject(new Mario(), 125, 850); // mario
    }
}
