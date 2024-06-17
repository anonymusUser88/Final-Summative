import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
  
    public void act()
    {

setImageScaled("Heart.png",4);

}
 private void setImageScaled(String image,int ScaleValue) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / ScaleValue, img.getHeight() / ScaleValue);
        setImage(img);
    }
}
