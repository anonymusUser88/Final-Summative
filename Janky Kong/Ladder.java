import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ladder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ladder extends Actor {

    //All the ladder is, is simply just a scaled image, it doesn't do anything

    public Ladder() {
        this.setImageScaled("Ladder.png");
    }

    public void act() {

    }

    private void setImageScaled(String image) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() /3, img.getHeight() /2);
        setImage(img);
    }
}
