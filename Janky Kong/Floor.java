import greenfoot.*;

/**
 * Floor class
 * June 12, 2024
 */
public class Floor extends Actor
{
    private int direction; // direction that the barrel rolls
    private int jumpHeight; // the height that mario can jump
    
    public Floor(int direction, int jumpHeight)
    {
        this.direction = direction;
        this.jumpHeight = jumpHeight;
        scaleImage();
    }
    
    public void scaleImage() 
    {
        GreenfootImage image = getImage();  
        image.scale(100, 30);
        setImage(image);
    }

    // Getters and Setters
    public int getDirection() 
    {
        return direction;
    }

    public void setDirection(int direction) 
    {
        this.direction = direction;
    }

    public int getJumpHeight() 
    {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) 
    {
        this.jumpHeight = jumpHeight;
    }
}

