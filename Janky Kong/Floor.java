import greenfoot.*;

/**
 * Floor class
 * June 12, 2024
 */
public class Floor extends Actor
{
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int direction; // direction that the barrel rolls
    int jumpHeight; // the height that mario can jump
    
    public Floor(int direction, int jumpHeight)
    {
        this.direction = direction;
        this.jumpHeight = jumpHeight;
        scaleImage();
    }
    
    public void act() 
    {
        
    }    
    
    public void scaleImage() 
    {
        GreenfootImage image = getImage();  
        image.scale(100, 30);
        setImage(image);
    }
}
