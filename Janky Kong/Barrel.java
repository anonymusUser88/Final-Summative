import greenfoot.*;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{
    
    public Barrel() {
        scaleImage();
    }
    public void act() 
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        } 
        else
        {
          setLocation(getX(), getY() + 3);
          while(isTouching(Floor.class))
          {
            Floor f = (Floor)getOneIntersectingObject(Floor.class);
            setLocation(getX() + 2*(f.direction), getY() - 3);
            turn(3*f.direction);
          }

       }
    }
    
    public void scaleImage() {
        GreenfootImage image = getImage();  
        image.scale(65, 65);
        setImage(image);
    }
}
 