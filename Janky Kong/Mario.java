import greenfoot.*;

/**
 * Mario Class
 * June 15, 2024
 */
public class Mario extends Actor 
{
    int ySpeed = 9; // gravity
    int lives = 3; // lives
    long lastXInputTime = 0; // last time a key was pressed
    boolean isJumping = false; // whether Mario is jumping
    String[] images = {"mario_idle_left.png", "mario_idle_right.png", "mario_jump_left.png",
            "mario_jump_right.png", "mario_left.png", "mario_left_2.png", "mario_left_3.png", "mario_right.png",
            "mario_right_2.png", "mario_right_3.png"};
    String currentImage = images[0]; 
    boolean isAlive = true; // tracks whether the player is alive

    public Mario() 
    {
        this.setImageScaled(currentImage);
    }

    public void act() 
    {
        this.checkLives();
        if (isAlive)
        {
            this.otherActions();
            this.animation(this.images, "up", "right", "left");
        }
    }

    public void otherActions()
    {
        Luigi l = getWorld().getObjects(Luigi.class).get(0); // gets the luigi object

        setImageScaled(this.currentImage);
        this.ySpeed = this.ySpeed + 1;
        setLocation(getX(), getY() + this.ySpeed);
        getWorld().showText("Luigi Lives : "+ l.lives, 950, 150);
    }

    public void checkLives() 
    {
        Luigi l = getWorld().getObjects(Luigi.class).get(0); // gets the luigi object

        if (isTouching(Barrel.class) && this.isAlive) // touching a barrel
        {
            removeTouching(Barrel.class);
            this.lives-=1; 
        }

        if (this.lives <= 0)
        {
            setImage("death_image.png"); // they 'disappear'
            this.isAlive = false;
        }

        if (!this.isAlive && !l.isAlive) // if neither player is alive
        {
            getWorld().showText("GAME OVER", 750, 600);
        }
    }

    public void animation(String[] i, String u, String r, String l) // images + keys used to move mario
    {
        if(ySpeed > 0) // is in the air
        {
            while(isTouching(Floor.class)) 
            {
                Floor f = (Floor)getOneIntersectingObject(Floor.class);
                this.ySpeed = 0;
                setLocation(getX(), getY() - 1);
                this.isJumping = false;
                if(Greenfoot.isKeyDown(u) && !this.isJumping) 
                {
                    this.isJumping = true;
                    this.ySpeed = f.jumpHeight;

                    // Determine jump direction based on current image
                    if (this.currentImage.contains("left")) 
                    {
                        this.currentImage = i[2];
                    }
                    else 
                    {
                        this.currentImage = i[3];
                    }
                }
            }
        }

        if(this.ySpeed <= 0) 
        {
            while(isTouching(Floor.class)) 
            {
                this.ySpeed = 0;
                setLocation(getX(), getY() + 1);
                this.isJumping = false;
                if (this.currentImage.contains("left")) 
                {
                    this.currentImage = i[0];
                } 
                else 
                {
                    this.currentImage = i[1];
                }
            }
        }    

        if (Greenfoot.isKeyDown(l)) // when pressing left key
        {
            move(-5);

            // animation
            if(!this.isJumping)
            {
                if (System.currentTimeMillis() - this.lastXInputTime > 50)
                {
                    if (this.currentImage.equals(i[1]) || this.currentImage.equals(i[0])) 
                    {
                        this.currentImage = i[4];
                    } 
                    else if (this.currentImage.equals(i[4])) 
                    {
                        this.currentImage = i[5];
                    } 
                    else if (this.currentImage.equals(i[5])) 
                    {
                        this.currentImage = i[6];
                    } 
                    else if (this.currentImage.equals(i[6])) 
                    {
                        this.currentImage = i[4];
                    }
                    this.lastXInputTime = System.currentTimeMillis();
                    setImageScaled(this.currentImage);
                }
            }
        } 

        else if (Greenfoot.isKeyDown(r)) 
        {
            move(5);
            // animation
            if(!this.isJumping) 
            {
                if (System.currentTimeMillis() - this.lastXInputTime > 50) 
                {
                    if (this.currentImage.equals(i[1]) || this.currentImage.equals(i[0])) 
                    {
                        currentImage = i[7];
                    }
                    else if (this.currentImage.equals(i[7])) 
                    {
                        this.currentImage = i[8];
                    } 
                    else if (this.currentImage.equals(i[8])) 
                    {
                        this.currentImage = i[9];
                    } 
                    else if (this.currentImage.equals(i[9])) 
                    {
                        this.currentImage = i[7];
                    }
                    this.lastXInputTime = System.currentTimeMillis();
                    setImageScaled(this.currentImage);
                }
            }
        }  

        // no keys are being pressed
        else if(this.currentImage.contains("left")) 
        {
            this.currentImage = i[0];
        }
        else 
        {
            this.currentImage = i[1];
        }
    }

    protected void setImageScaled(String image) 
    {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() * 4, img.getHeight() * 4);
        setImage(img);
    }
}
