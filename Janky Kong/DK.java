import greenfoot.*;
public class DK extends Actor
{
    long lastTimeSinceBarrelThrown; // throwing the barrel
    long lastTimeSinceDKMoves; // animation
    
    public DK()
    {
        scaleImage();
    }
    public void act() 
    {
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        
        if(System.currentTimeMillis() - lastTimeSinceDKMoves > 1750)
        {
            setImage("Donkey_Kong_Standing.png");
            scaleImage();
        }
        if(System.currentTimeMillis() - lastTimeSinceBarrelThrown > 2500)
        {
            setImage("Donkey_Kong_Throwing.png");
            scaleImage();
            lastTimeSinceBarrelThrown = System.currentTimeMillis();
            lastTimeSinceDKMoves = System.currentTimeMillis();
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
