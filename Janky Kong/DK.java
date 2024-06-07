import greenfoot.*;
public class DK extends Actor
{
    long lastTimeSinceBarrelThrown; // for actually throwing the barrel
    long lastTimeSinceDKMoves; // for the animation
    
    public void act() 
    {
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTimeSinceDKMoves > 2000)
        {
            lastTimeSinceDKMoves = System.currentTimeMillis();
            setImage("donkey-kong_standing.png");
        }
        if(System.currentTimeMillis() - lastTimeSinceBarrelThrown > 2500)
        {
            setImage("Donkey_Kong_Throwing.png");
            lastTimeSinceBarrelThrown = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
            
        }   
    }
}
