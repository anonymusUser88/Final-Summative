import greenfoot.*;

public class Mario extends Actor {
    int speed = 9;
    int Lives = 3;
    String Marioimage = "mario_idle_right.png";
    long lastTime;

    public Mario() {
        setImageScaled(Marioimage);
    }

    public void act() {
        setImageScaled(Marioimage);
        speed = speed + 1;
        setLocation(getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives, 1450, 50);

        if (isTouching(Barrel.class)) {
            removeTouching(Barrel.class);
            Lives = Lives - 1;
        }
        if (Lives == 0) {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }
        if(speed > 0) {
            while(isTouching(Floor.class)) {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up")) {
                    speed = - 27;
                }
            }
        }
        if(speed <= 0) {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
            }
        }    

        if (Greenfoot.isKeyDown("left")) {
            move(-5);
            if (System.currentTimeMillis() - lastTime > 50) {
                if (Marioimage.equals("mario_idle_right.png") ||
                    Marioimage.equals("mario_idle_left.png")) {
                    Marioimage = "mario_left.png";
                } else if (Marioimage.equals("mario_left.png")) {
                    Marioimage = "mario_left_2.png";
                }  else if (Marioimage.equals("mario_left_2.png")) {
                    Marioimage = "mario_left_3.png";
                } else if (Marioimage.equals("mario_left_3.png")) {
                    Marioimage = "mario_left.png";
                }
                lastTime = System.currentTimeMillis();
            }
        } else if (Greenfoot.isKeyDown("right")) {
            move(5);
            if (System.currentTimeMillis() - lastTime > 50) {
                if (Marioimage.equals("mario_idle_right.png") ||
                    Marioimage.equals("mario_idle_left.png")) {
                    Marioimage = "mario_right.png";
                } else if (Marioimage.equals("mario_right.png")) {
                    Marioimage = "mario_right_2.png";
                }  else if (Marioimage.equals("mario_right_2.png")) {
                    Marioimage = "mario_right_3.png";
                } else if (Marioimage.equals("mario_right_3.png")) {
                    Marioimage = "mario_right.png";
                }
                lastTime = System.currentTimeMillis();
                }
            } else if(Marioimage.equals("mario_left.png") || 
            Marioimage.equals("mario_left_2.png") || 
            Marioimage.equals("mario_left_3.png")) {
            Marioimage = "mario_idle_left.png";
            } else if (Marioimage.equals("mario_right.png") || 
            Marioimage.equals("mario_right_2.png") || 
            Marioimage.equals("mario_right_3.png")) {
            Marioimage = "mario_idle_right.png";
        }
        if (Greenfoot.isKeyDown("down")) {
            speed = 50;
            }
    }
    
    private void setBoundries() {
            getWorld().removeObject(this);
    }
    
    private void setImageScaled(String image) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(img.getWidth() * 4, img.getHeight() * 4);
        setImage(img);
    }
}
