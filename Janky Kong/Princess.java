import greenfoot.*;

/**
 * Write a description of class Princess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Princess extends Actor
{
    long TimeSinceHelpAnimation;
    long TimeSinceLastAnimation;
    public Princess()
    {
        setImageScaled("Princess_Peach_.png",17);
    }

    public void act() 
    {
        DK d = getWorld().getObjects(DK.class).get(0); // gets the DK object

        if(d.playersWon == false)
        {
            if(System.currentTimeMillis() - TimeSinceLastAnimation > 1000)
            {
                setImageScaled("Princess_Peach_.png",17);
                setLocation(60, 168);
            }
            if(System.currentTimeMillis() - TimeSinceHelpAnimation > 1500){
                TimeSinceHelpAnimation = System.currentTimeMillis();
                TimeSinceLastAnimation = System.currentTimeMillis();
                setLocation(98, 152);

                setImage("princess_peach_help.png");

            }

        } 

        else{
            setImageScaled("Princess_Peach_.png",17);
            setLocation(60, 168);

        }

    }

    private void setImageScaled(String image,int ScaleValue) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / ScaleValue, img.getHeight() / ScaleValue);
        setImage(img);

    }
}
