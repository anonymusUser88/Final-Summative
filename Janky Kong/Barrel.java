import greenfoot.*;

/**
 * Barrel Class
 * June 17, 2024
 */
public class Barrel extends Actor
{
    private String barrelImage;
    private long timeTouching = 0;

    public Barrel(String barrelImage) 
    {
        this.barrelImage = barrelImage; //There are two diff types of barrels, one is special the other one is normal
        this.setImageScaled(barrelImage);
    }

    public void act() 
    {
        Mario m = getMario();
        Luigi l = getLuigi();

        if(this.isAtEdge()) 
        {
            removeBarrel();
        } 
        else if (m.isAlive || l.isAlive) 
        {
            this.moveBarrel();
        }

        if (this.isTouching(OilBarrel.class))  
        {
            this.handleOilBarrelTouch();
        }
    }

    private Mario getMario()
    {
        return getWorld().getObjects(Mario.class).get(0); // gets the mario object
    }

    private Luigi getLuigi()
    {
        return getWorld().getObjects(Luigi.class).get(0); // gets the luigi object
    }

    private void removeBarrel()
    {
        getWorld().removeObject(this); //Removes barrel
    }

    private void moveBarrel()
    {
        setLocation(this.getX(), this.getY() + 3); //Sets barrel to move
        while(this.isTouching(Floor.class))
        {
            this.handleFloorTouch();
        }
    }

    private void handleFloorTouch()
    {
        //It gets the floor direction variable present in the floor that the barrel is currently on
        //Helps to ensure the barrel travels the correct direction
        Floor f = (Floor)getOneIntersectingObject(Floor.class); //Gets the var
        setLocation(this.getX() + 2* f.getDirection(), this.getY() - 3); //Moves according to the var
        this.turn(3*f.getDirection()); //Rotates according to the var
    }

    private void handleOilBarrelTouch()
    {
        if (this.timeTouching == 0)  
        {
            this.timeTouching = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - this.timeTouching > 1) 
        {
            removeBarrel();
            this.timeTouching = 0;
        }
    }

    private void setImageScaled(String image) //Takes in an image and spits out that image scaled appropriately
    {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() / 6, img.getHeight() / 5); // Adjust scaling factors appropriately
        setImage(img);
    }

    // Getters and Setters
    public String getBarrelImage() 
    {
        return barrelImage;
    }

    public void setBarrelImage(String barrelImage) 
    {
        this.barrelImage = barrelImage;
        setImageScaled(barrelImage);
    }

    public long getTimeTouching() 
    {
        return timeTouching;
    }

    public void setTimeTouching(long timeTouching) 
    {
        this.timeTouching = timeTouching;
    }
}
