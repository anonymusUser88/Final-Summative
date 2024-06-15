import greenfoot.*;

/**
 * Barrel Class
 * June 14, 2024
 */
public class Barrel extends Actor
{

    public Barrel() 
    {
        scaleImage();
    }

    public void act() 
    {
        Mario m = getWorld().getObjects(Mario.class).get(0); // gets the mario object
        Luigi l = getWorld().getObjects(Luigi.class).get(0); // gets the luigi object

        if(isAtEdge()) // if it touches the edge
        {
            getWorld().removeObject(this);
        } 
        else if (m.lives > 0 || l.lives > 0) // if mario is alive
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

    public void scaleImage() 
    {
        GreenfootImage image = getImage();  
        image.scale(65, 65);
        setImage(image);
    }
}
 