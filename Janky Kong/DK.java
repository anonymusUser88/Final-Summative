import greenfoot.*;
public class DK extends Actor
{
    long lastTimeSinceBarrelThrown; // throwing the barrel
    long lastTimeSinceDKMoves; // animation
    int randomNum = Greenfoot.getRandomNumber(15) + 1;
    public DK() {
        scaleImage();
    }

    public void act() {
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
        if(System.currentTimeMillis() - lastTimeSinceBarrelThrown > 2500) {
            setImage("Donkey_Kong_Throwing.png");
            scaleImage();
            lastTimeSinceBarrelThrown = System.currentTimeMillis();
            lastTimeSinceDKMoves = System.currentTimeMillis();
            if(randomNum > 1) {
                getWorld().addObject(new Barrel("barrel.png"), getX(), getY());
                randomNum = Greenfoot.getRandomNumber(15) + 1;
            }   else {
                getWorld().addObject(new Barrel("barrel2.png"), getX(), getY());
                randomNum = Greenfoot.getRandomNumber(15) + 1;
            }
        }    
    }

    public void scaleImage() {
        GreenfootImage image = getImage();
        image.scale(143, 100);
        setImage(image);
    }
}
