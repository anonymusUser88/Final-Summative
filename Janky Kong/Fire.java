import greenfoot.*;

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor {

    String currentFireImage = "Fire.png";
    int ySpeed = 0;
    long lastFireTime = 0;
    int xSpeed = 0;
    int movement = 0;
    int randomNum = Greenfoot.getRandomNumber(15) + 1;

    public Fire() {
        setImageScaled(currentFireImage);
    }

    public void act() {
        ySpeed += 1;
        xSpeed = 20;

        if (ySpeed > 5) {
            ySpeed = 5;
        }

        if (isTouching(Ladder.class)) {
            setLocation(getX(), getY()); 
            ySpeed = -10;
            xSpeed = 0;
        }

        setLocation(getX(), getY() + ySpeed);

        if (isTouching(Floor.class)) {
            setLocation(getX(), getY() - 1);
            ySpeed = -15;
        }

        Floor f = (Floor)getOneIntersectingObject(Floor.class);
        if (f != null) {
            if(randomNum < 11) {
                movement = xSpeed * (-f.direction);
                setLocation(getX() + movement , getY());
            } else {
                movement = xSpeed * (f.direction);
                setLocation(getX() + movement , getY());
            }
            randomNum = Greenfoot.getRandomNumber(15) + 1;
            if (isTouching(Mario.class) || isTouching(DK.class)) {
                getWorld().removeObject(this);
            }
        }
    }

    private void setImageScaled(String image) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / 14, img.getHeight() / 14);
        setImage(img);
    }
}
