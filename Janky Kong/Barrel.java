import greenfoot.*;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor {

    String barrelImage;
    boolean isTouching = false;
    long timeTouching = 0;    

    public Barrel(String barrelImage) {
        this.barrelImage = barrelImage;
        setImageScaled(barrelImage);
    }

    public void act() {
        if(isAtEdge()) {
            getWorld().removeObject(this);
        } else {
            setLocation(getX(), getY() + 3);
            while(isTouching(Floor.class))
            {
                Floor f = (Floor)getOneIntersectingObject(Floor.class);
                setLocation(getX() + 2*(f.direction), getY() - 3);
                turn(3*f.direction);
            }
        }

        if (isTouching(OilBarrel.class)) {
            isTouching = true;
            if (timeTouching == 0) {
                timeTouching = System.currentTimeMillis();
            }

            if (System.currentTimeMillis() - timeTouching > 0.5) {
                getWorld().removeObject(this);
                timeTouching = 0;
            }
        }
    }

    private void setImageScaled(String image) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / 6, img.getHeight() / 5); // Adjust scaling factors appropriately
        setImage(img);
    }
}
