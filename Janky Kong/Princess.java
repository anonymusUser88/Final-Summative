import greenfoot.*;

/**
 * Princess Class
 * June 17, 2024
 */
public class Princess extends Actor
{
    private long timeSinceLastAnimation = 0;
    private long timeSinceHelpAnimation = 0;

    public void act() 
    {
        DK d = getDK();

        if(!d.getPlayersWon())
        {
            this.handleAnimation();
        }
    }

    private DK getDK()
    {
        return getWorld().getObjects(DK.class).get(0); // gets the DK object
    }

    private void handleAnimation()
    {
        if(System.currentTimeMillis() - timeSinceLastAnimation > 1000)
        {
            this.setImageScaled("Princess_Peach_.png", 17);
            this.updateLocation();

            if(System.currentTimeMillis() - this.timeSinceHelpAnimation > 1500)
            {
                this.timeSinceHelpAnimation = System.currentTimeMillis();
                this.timeSinceLastAnimation = System.currentTimeMillis();
                this.updateHelpLocation();
                this.setImage("princess_peach_help.png");
            }
        }
        else
        {
            this.setImageScaled("Princess_Peach_.png", 17);
            this.updateLocation();
        }
    }

    private void updateLocation()
    {
        if(DK.getLevel() == 1) 
        {
            this.setLocation(60, 168);
        } 
        else if(DK.getLevel() == 2) 
        {
            this.setLocation(60, 168 - 75);
        }
    }

    private void updateHelpLocation()
    {
        if(DK.getLevel() == 1) 
        {
            this.setLocation(98, 152);
        } 
        else if(DK.getLevel() == 2) 
        {
            this.setLocation(98, 152 - 75);
        }
    }

    private void setImageScaled(String image, int scaleValue) 
    {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / scaleValue, img.getHeight() / scaleValue);
        setImage(img);
    }

    // Getters and Setters
    public long getTimeSinceLastAnimation() 
    {
        return timeSinceLastAnimation;
    }

    public void setTimeSinceLastAnimation(long timeSinceLastAnimation) 
    {
        this.timeSinceLastAnimation = timeSinceLastAnimation;
    }

    public long getTimeSinceHelpAnimation() 
    {
        return timeSinceHelpAnimation;
    }

    public void setTimeSinceHelpAnimation(long timeSinceHelpAnimation) 
    {
        this.timeSinceHelpAnimation = timeSinceHelpAnimation;
    }
}
