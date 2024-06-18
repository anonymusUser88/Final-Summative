import greenfoot.*;
<<<<<<< Updated upstream
=======

/**
 * DK Class
 * June 17, 2024
 */
>>>>>>> Stashed changes
public class DK extends Actor
{
    long lastTimeSinceBarrelThrown; // throwing the barrel
    long lastTimeSinceDKMoves; // animation
    int randomNum = Greenfoot.getRandomNumber(15) + 1;
<<<<<<< Updated upstream
    public DK() {
        scaleImage();
    }

    public void act() {
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

=======
    int Yshift = 50; // used in gameover screen to shift dk
    Boolean playersWon = false;
    long TimeofDeath;
    static int level = 1;

    public DK()
    {
        setImageScaled("Donkey_Kong_Standing.png");
    }

    public void act() 
    {
        System.out.println(level);

        Mario m = getWorld().getObjects(Mario.class).get(0); // gets the mario object
        Luigi l = getWorld().getObjects(Luigi.class).get(0); // gets the luigi object

        if((isTouching(Mario.class) || isTouching(Luigi.class)) && level == 1) // if either of the players reach donkey kong
        {
            Level2 level2 = new Level2();
            Greenfoot.setWorld(level2);
            level++;
        }  else if ((isTouching(Mario.class) || isTouching(Luigi.class)) && level == 2) {
            TimeofDeath = System.currentTimeMillis();
            playersWon = true;
            getWorld().showText("YOU WIN", 750, 600);
            GreenfootSound music = new GreenfootSound("Donkey Kong Arcade Music - Round Clear.mp3");
            music.play();
        }

        if(getY()>770)
        {
>>>>>>> Stashed changes
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
