import greenfoot.*;
public class Mario extends Actor
{
    int speed = 9;
    int xSpeed = 0;
    String Marioimage = "Mario_Standing_Right.png";
    long lastTime;
    int Lives = 3;
    
    public Mario()
    {
        scaleImage();
    }
    public void act() 
    {
        speed = speed + 1;
        setLocation(getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives +"",900, 50);
        if(isTouching(Barrel.class)) // touching a barrel
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
        }
        if(Lives == 0) // run out of lives
        {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }
        if(speed > 0) // if mario is falling(?)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                
                if(Greenfoot.isKeyDown("up"))
                {
                    speed = - 27;
                }
            }
        }
        if(speed <= 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
            }
        } 
        
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
            if(System.currentTimeMillis() - lastTime > 500 && Marioimage.equals("Mario_Standing_Right.png"))
            {
                Marioimage = "Mario_Jumping_Left.png";
                setImage("Mario_Jumping_Left.png");
                scaleImage();
                lastTime = System.currentTimeMillis();
            } 
            else if (System.currentTimeMillis() - lastTime > 500)

            {
                Marioimage = "Mario_Jumping_Right.png";
                setImage("Mario_Jumping_Right.png");
                scaleImage();
                lastTime = System.currentTimeMillis();
            }
            
            setImage("Mario_Jumping_Left.png");
            scaleImage();
            while(isTouching(Floor.class))
            {
               move(1);
            } 
        } 
        
        else if(Greenfoot.isKeyDown("right"))
        {
            move(5);
            setImage("Mario_Jumping_Right.png");
            scaleImage();
               
            while(isTouching(Floor.class))
            {
                move(-1);
            }
        } 
        else
        {
            setImage("Mario_Standing_Right.png");
            scaleImage();
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            speed = 50;
        }
    } 
    
    public void scaleImage()
    {
        GreenfootImage image = getImage();
        image.scale(49, 65);
        setImage(image);
    }
}