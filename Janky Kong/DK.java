import greenfoot.*;
/**
 * DK Class
 * June 17, 2024
 */
public class DK extends Actor
{
    long lastTimeSinceBarrelThrown; // throwing the barrel
    long lastTimeSinceDKMoves; // animation
    int randomNum = Greenfoot.getRandomNumber(15) + 1;

    public DK()
    {
        setImageScaled("Donkey_Kong_Standing.png");
    }

    public void act() 
    {
        Mario m = getWorld().getObjects(Mario.class).get(0); // gets the mario object
        Luigi l = getWorld().getObjects(Luigi.class).get(0); // gets the luigi object

        if(isTouching(Mario.class) || isTouching(Luigi.class)) // if either of the players reach donkey kong
        {
            Greenfoot.setWorld(new Finish()); // the game ends
        }

        else if (m.isAlive || l.isAlive) // if either player is alive
        {
            // animation + throwing barrel
            if(System.currentTimeMillis() - lastTimeSinceDKMoves > 1750)
            {
                setImageScaled("Donkey_Kong_Standing.png");
            }
            if(System.currentTimeMillis() - lastTimeSinceBarrelThrown > 2500)
            {
                setImageScaled("Donkey_Kong_Throwing.png");
                lastTimeSinceBarrelThrown = System.currentTimeMillis();
                lastTimeSinceDKMoves = System.currentTimeMillis();

                if(randomNum > 1) 
                {
                    getWorld().addObject(new Barrel("barrel.png"), getX(), getY());
                    randomNum = Greenfoot.getRandomNumber(15) + 1;
                }  
                else 
                {
                    getWorld().addObject(new Barrel("barrel2.png"), getX(), getY());
                    randomNum = Greenfoot.getRandomNumber(15) + 1;
                }
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
