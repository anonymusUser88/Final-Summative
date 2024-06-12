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
    int jumpHeight;
    
    public Floor(int direction, int jumpHeight)
    {
        this.direction = direction;
        this.jumpHeight = jumpHeight;
        scaleImage();
    }
    
    public void act() 
    {
        
    }    
    
    public void scaleImage() {
        GreenfootImage image = getImage();  
        image.scale(100, 30);
        setImage(image);
    }
}
