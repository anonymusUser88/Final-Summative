import greenfoot.*;

/**
 * Write a description of class Finish here.
 * June 4, 2024
 */
public class Finish extends World
{

    /**
     * Constructor for objects of class Finish.
     * 
     */
    public Finish()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 900, 1); 
        addObject(new Floor(1), 125, 1000);
        addObject(new Floor(1), 375, 1000);
        addObject(new Floor(1), 625, 1000);
        addObject(new Floor(1), 875, 1000);
        addObject(new Floor(1), 1125, 1000);
        addObject(new Floor(1), 1375, 1000);
        addObject(new Princess(), 145, 940);
        addObject(new Mario(), 85, 940);
        showText("YOU WIN", 750, 600);
    }
    
    public void WinScreen()
    {
    
    }
    
    public void LoseScreen()
    {
    
    }
}
