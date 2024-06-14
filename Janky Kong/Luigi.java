import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A second player (Luigi)
 * June 13, 2024
 */


public class Luigi extends Mario
{
    String[] images = {"luigi_idle_left.png", "luigi_idle_right.png", "luigi_jump_left.png",
    "luigi_jump_right.png", "luigi_left.png", "luigi_left_2.png", "luigi_left_3.png", "luigi_right.png",
    "luigi_right_2.png", "luigi_right_3.png"};
    String currentImage = images[0];
    
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
        super.animation(this.images);
    }
}
