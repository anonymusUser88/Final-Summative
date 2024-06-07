import greenfoot.*;
public class Mario extends Actor
{
    int speed = 9;
    int xSpeed = 0;
    String Marioimage = "mario-standing.png";
    long lastTime;
    int Lives = 3;
    public void act() 
    {
        speed = speed + 1;
        setLocation(getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives +"",900, 50);
        if(isTouching(Barrel.class))
        {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
        }
        if(Lives == 0)
        {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }
        if(speed > 0)
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
            if(System.currentTimeMillis() - lastTime > 500 && Marioimage.equals("mariopixelCopy.png"))
            {
                Marioimage = "mario-left.png";
                setImage("mario-left.png");
                lastTime = System.currentTimeMillis();
            } else {
                if(System.currentTimeMillis() - lastTime > 500)
                {
                    Marioimage = "mario-right.png";
                    setImage("mario-right.png");
                    lastTime = System.currentTimeMillis();
                }
            } 
            
           
            setImage("mario-left.png");
            while(isTouching(Floor.class))
            {
               move(1);
            } 
        } else {
            if(Greenfoot.isKeyDown("right"))
            {
               move(5);
               setImage("mario-right.png");
                while(isTouching(Floor.class))
                {
                  move(-1);
               }
            } else{
                setImage("mario-standing.png");
            }
        }
        if(Greenfoot.isKeyDown("down"))
        {
            speed = 50;
        }
    } 
}
