import greenfoot.*;

/**
 * OilBarrel Class
 * June 17, 2024
 */
public class OilBarrel extends Actor {
    private String currentOilBarrel = "OilBarrel1.png";
    private long lastAnimationTime = 0;

    public OilBarrel() {
        this.setImageScaled(currentOilBarrel);
    }

    public void act() {
        this.setImageScaled(currentOilBarrel); // Sets the current image
        if (System.currentTimeMillis() - this.lastAnimationTime > 50) { // Adds animation, the pic changes every 50 milliseconds
            this.updateCurrentOilBarrel();
            this.lastAnimationTime = System.currentTimeMillis();
        }

        if (this.isTouching(Barrel.class)) { // Checks if any barrel touches the oil barrel
            Barrel b = (Barrel) getOneIntersectingObject(Barrel.class); // Get the barrel object that is touching

            if (b.getBarrelImage().equals("barrel2.png")) { // Checks if it is the special barrel that is touching
                getWorld().addObject(new Fire(), this.getX(), this.getY()); // If it is then the fire is spawned on top of the barrel
            }
        }
    }

    private void updateCurrentOilBarrel() {
        if (this.currentOilBarrel.equals("OilBarrel1.png")) {
            this.currentOilBarrel = "OilBarrel2.png";
        } else if (this.currentOilBarrel.equals("OilBarrel2.png")) {
            this.currentOilBarrel = "OilBarrel3.png";
        } else if (this.currentOilBarrel.equals("OilBarrel3.png")) {
            this.currentOilBarrel = "OilBarrel4.png";
        } else if (this.currentOilBarrel.equals("OilBarrel4.png")) {
            this.currentOilBarrel = "OilBarrel5.png";
        } else if (this.currentOilBarrel.equals("OilBarrel5.png")) {
            this.currentOilBarrel = "OilBarrel2.png";
        }
    }

    private void setImageScaled(String image) { // Takes in an image and spits out the image resized
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / 4, img.getHeight() / 4);
        setImage(img);
    }

    // Getters and Setters
    public String getCurrentOilBarrel() {
        return currentOilBarrel;
    }

    public void setCurrentOilBarrel(String currentOilBarrel) {
        this.currentOilBarrel = currentOilBarrel;
    }

    public long getLastAnimationTime() {
        return lastAnimationTime;
    }

    public void setLastAnimationTime(long lastAnimationTime) {
        this.lastAnimationTime = lastAnimationTime;
    }
}

