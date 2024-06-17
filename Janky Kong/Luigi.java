import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A second player (Luigi)
 * June 15, 2024
 */


public class Luigi extends Mario
{
    String[] images = {"luigi_idle_left.png", "luigi_idle_right.png", "luigi_jump_left.png",
    "luigi_jump_right.png", "luigi_left.png", "luigi_left_2.png", "luigi_left_3.png", "luigi_right.png",
    "luigi_right_2.png", "luigi_right_3.png"};
    String currentImage = images[0];
    int lives = 3;
    boolean isAlive = true; // tracks whether the player is alive
    
    /**
     * Act - do whatever the Luigi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Luigi()
    {
        super.setImageScaled(currentImage);
    }
    
    public void act()
    {        
        this.checkLives();
        if (this.isAlive) // is the player is alive
        {
            super.otherActions();
            super.animation(this.images, "w", "d", "a"); // up, right, left
        }
    }
    
    public void checkLives() 
    {
        Mario m = getWorld().getObjects(Mario.class).get(0); // gets the luigi object
        getWorld().showText("Mario Lives : "+ m.lives, 950, 100);
        
        if ((isTouching(Barrel.class) || isTouching(Fire.class)) && this.isAlive) // touching a barrel
        {
            removeTouching(Barrel.class);
            this.lives = this.lives - 1; 
        }
        
        if (this.lives <= 0) // if all lives are gone
        {
            setImage("death_image.png"); // they 'disappear'
            this.isAlive = false; // they are not longer alive
        }
    }
}
