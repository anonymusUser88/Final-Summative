import greenfoot.*;
/**
 * DK Class
 * June 12, 2024
 */
public class DK extends Actor
{
    long lastTimeSinceBarrelThrown; // throwing the barrel
    long lastTimeSinceDKMoves; // animation
    
    public DK()
    {
        setImageScaled("Donkey_Kong_Standing.png");
    }
    public void act() 
    {
        Mario m = getWorld().getObjects(Mario.class).get(0); // gets the mario object
        
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        
        else if (m.marioLives > 0)
        {
            if(System.currentTimeMillis() - lastTimeSinceDKMoves > 1750)
            {
                setImageScaled("Donkey_Kong_Standing.png");
            }
            if(System.currentTimeMillis() - lastTimeSinceBarrelThrown > 2500)
            {
                setImageScaled("Donkey_Kong_Throwing.png");
                lastTimeSinceBarrelThrown = System.currentTimeMillis();
                lastTimeSinceDKMoves = System.currentTimeMillis();
                getWorld().addObject(new Barrel(), getX(), getY());
            }
        }
    }    
    
    public void setImageScaled(String img)
    {
        GreenfootImage image = new GreenfootImage(img);
        image.scale(143, 100);
        setImage(image);
    }
}
