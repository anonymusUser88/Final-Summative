import greenfoot.*;

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int direction;
    
    public Floor(int direction)
    {
        this.direction = direction;
        scaleImage();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void scaleImage() {
        GreenfootImage image = getImage();  
        image.scale(100, 30);
        setImage(image);
    }
}
