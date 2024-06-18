import greenfoot.*;

/**
 * DK Class
 * June 17, 2024
 */
public class DK extends Actor
{
    private long lastTimeSinceBarrelThrown; // throwing the barrel
    private long lastTimeSinceDKMoves; // animation
    private int randomNum = Greenfoot.getRandomNumber(15) + 1;
    private int Yshift = 50; // used in gameover screen to shift dk
    private Boolean playersWon = false;
    private long timeOfDeath;
    private static int level = 1;

    public DK()
    {
        setImageScaled("Donkey_Kong_Standing.png");
    }

    public void act() 
    {
        Mario m = getMario();
        Luigi l = getLuigi();

        checkPlayerWin(m, l);
        checkFallOffScreen();
        moveIfPlayersWon();
        performActionsIfPlayersAlive(m, l);
    }

    private Mario getMario()
    {
        return getWorld().getObjects(Mario.class).get(0); // gets the mario object
    }

    private Luigi getLuigi()
    {
        return getWorld().getObjects(Luigi.class).get(0); // gets the luigi object
    }

    private void checkPlayerWin(Mario m, Luigi l)
    {
        if((isTouching(Mario.class) || isTouching(Luigi.class)) && level == 1) // if either of the players reach donkey kong
        {
            Level2 level2 = new Level2();
            Greenfoot.setWorld(level2);
            level++;
        } 

        if ((isTouching(Mario.class) || isTouching(Luigi.class)) && level == 2) 
        {
            timeOfDeath = System.currentTimeMillis();
            playersWon = true;
            getWorld().showText("YOU WIN", 750, 600);
            GreenfootSound music = new GreenfootSound("Donkey Kong Arcade Music - Round Clear.mp3");
            music.play();
        }
    }

    private void checkFallOffScreen()
    {
        if(getY() > 770)
        {
            Greenfoot.stop();
        }
    }

    private void moveIfPlayersWon()
    {
        if(playersWon)
        {
            setLocation(getX(), getY() + Yshift);
        }
    }

    private void performActionsIfPlayersAlive(Mario m, Luigi l)
    {
        if(m.isAlive || l.isAlive) 
        {
            performAnimation();
            throwBarrel();
        }
    }

    private void performAnimation()
    {
        if(System.currentTimeMillis() - lastTimeSinceDKMoves > 1750)
        {
            setImageScaled("Donkey_Kong_Standing.png");
        }
    }

    private void throwBarrel()
    {
        if(System.currentTimeMillis() - lastTimeSinceBarrelThrown > 2500)
        {
            setImageScaled("Donkey_Kong_Throwing.png");
            lastTimeSinceBarrelThrown = System.currentTimeMillis();
            lastTimeSinceDKMoves = System.currentTimeMillis();

            if(randomNum > 1) 
            {
                getWorld().addObject(new Barrel("barrel.png"), getX(), getY());
            }  
            else 
            {
                getWorld().addObject(new Barrel("barrel2.png"), getX(), getY());
            }
            randomNum = Greenfoot.getRandomNumber(15) + 1;
        }
    }

    public void setImageScaled(String img)
    {
        GreenfootImage image = new GreenfootImage(img);
        image.scale(143, 100);
        setImage(image);
    }

    // Getters and Setters
    public long getLastTimeSinceBarrelThrown() 
    {
        return lastTimeSinceBarrelThrown;
    }

    public void setLastTimeSinceBarrelThrown(long lastTimeSinceBarrelThrown) 
    {
        this.lastTimeSinceBarrelThrown = lastTimeSinceBarrelThrown;
    }

    public long getLastTimeSinceDKMoves() 
    {
        return lastTimeSinceDKMoves;
    }

    public void setLastTimeSinceDKMoves(long lastTimeSinceDKMoves) 
    {
        this.lastTimeSinceDKMoves = lastTimeSinceDKMoves;
    }

    public int getRandomNum() 
    {
        return randomNum;
    }

    public void setRandomNum(int randomNum) 
    {
        this.randomNum = randomNum;
    }

    public int getYshift() 
    {
        return Yshift;
    }

    public void setYshift(int yShift) 
    {
        this.Yshift = yShift;
    }

    public Boolean getPlayersWon() 
    {
        return playersWon;
    }

    public void setPlayersWon(Boolean playersWon) 
    {
        this.playersWon = playersWon;
    }

    public long getTimeOfDeath() 
    {
        return timeOfDeath;
    }

    public void setTimeOfDeath(long timeOfDeath) 
    {
        this.timeOfDeath = timeOfDeath;
    }

    public static int getLevel() 
    {
        return level;
    }

    public static void setLevel(int level) 
    {
        DK.level = level;
    }
}

