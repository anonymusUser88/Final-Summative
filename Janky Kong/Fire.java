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

    public Fire() {
        setImageScaled(currentFireImage);
    }

    public void act() {
        ySpeed += 1;
        if(ySpeed > 5) {
            ySpeed = 5;
        }

        if (isTouching(Ladder.class)) {
            setLocation(getX(), getY() - 2);
            ySpeed = -1;
        }

        setLocation(getX(), getY() + ySpeed);

        while (isTouching(Floor.class)) {
            setLocation(getX(), getY() - 1);
            if(System.currentTimeMillis() - lastFireTime > 100) {
                Floor f = (Floor)getOneIntersectingObject(Floor.class);
                setLocation(getX() - f.direction, getY());
                lastFireTime = System.currentTimeMillis();
            }
        }
    }

    private void setImageScaled(String image) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / 14, img.getHeight() / 14);
        setImage(img);
    }
}
