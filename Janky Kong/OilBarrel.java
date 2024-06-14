import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OilBarrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OilBarrel extends Actor
{
    /**
     * Act - do whatever the OilBarrel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    String currentOilBarrel = "OilBarrel1.png";
    long lastAnimationTime = 0;
    
    public OilBarrel() {
    setImageScaled(currentOilBarrel);
    }

    public void act() {
        setImageScaled(currentOilBarrel);
        System.out.println(System.currentTimeMillis() - lastAnimationTime > 30);
        if(System.currentTimeMillis() - lastAnimationTime > 50) {
            if(currentOilBarrel.equals("OilBarrel1.png")) {
                currentOilBarrel = "OilBarrel2.png";
            }  else if(currentOilBarrel.equals("OilBarrel2.png")) {
                currentOilBarrel = "OilBarrel3.png";
            }  else if(currentOilBarrel.equals("OilBarrel3.png")) {
                currentOilBarrel = "OilBarrel4.png";
            } else if(currentOilBarrel.equals("OilBarrel4.png")) {
                currentOilBarrel = "OilBarrel5.png";
            } else if(currentOilBarrel.equals("OilBarrel5.png")) {
                currentOilBarrel = "OilBarrel2.png";
            }
            lastAnimationTime = System.currentTimeMillis();
        }
    }

    private void setImageScaled(String image) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / 4, img.getHeight() / 4);
        setImage(img);
    }
}
