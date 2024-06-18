import greenfoot.*;

/**
 * Write a description of class Princess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Princess extends Actor
{
    /**
     * Act - do whatever the Princess wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        long TimeSinceLastAnimation = 0;
        long TimeSinceHelpAnimation = 0;
        
        DK d = getWorld().getObjects(DK.class).get(0); // gets the DK object

        if(d.playersWon == false)
        {
            if(System.currentTimeMillis() - TimeSinceLastAnimation > 1000)
            {
                setImageScaled("Princess_Peach_.png",17);
                if(DK.level == 1) {
                    setLocation(60, 168);
                } else if(DK.level == 2) {
                    setLocation(60, 168 - 75);
                }
                if(System.currentTimeMillis() - TimeSinceHelpAnimation > 1500){
                    TimeSinceHelpAnimation = System.currentTimeMillis();
                    TimeSinceLastAnimation = System.currentTimeMillis();
                    if(DK.level == 1) {
                        setLocation(98, 152);
                    } else if(DK.level == 2) {
                        setLocation(98, 152 - 75);
                    }
                    setImage("princess_peach_help.png");

                }

            } else{
                setImageScaled("Princess_Peach_.png",17);
                if(DK.level == 1) {
                    setLocation(60, 168);
                } else if(DK.level == 2) {
                    setLocation(60, 168 - 75);
                }

            }

        }
    }

    private void setImageScaled(String image,int ScaleValue) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / ScaleValue, img.getHeight() / ScaleValue);
        setImage(img);

    }
}