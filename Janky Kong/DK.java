import greenfoot.*;
public class DK extends Actor
{
    long lastTimeSinceBarrelThrown; // for actually throwing the barrel
    long lastTimeSinceDKMoves; // for the animation
    
    public DK()
    {
    }
    
    public void act() 
    {
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());
        
            Greenfoot.stop();
        }
        
        if(System.currentTimeMillis() - lastTimeSinceDKMoves > 2000)
        {
            setImage("Donkey_Kong_Standing.png");
            scaleImage();
            lastTimeSinceDKMoves = System.currentTimeMillis();
        }
        
        if(System.currentTimeMillis() - lastTimeSinceBarrelThrown > 2500)
        {
            setImage("Donkey_Kong_Throwing.png");
            scaleImage();
            lastTimeSinceBarrelThrown = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
            
        }   
    }
    
    public void scaleImage()
    {
        GreenfootImage image = getImage();
        image.scale(143, 100);
        setImage(image);
    }
}
