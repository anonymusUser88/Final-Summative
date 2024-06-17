import greenfoot.*;

public class Mario extends Actor {
    int ySpeed = 9;
    int marioLives = 3;
    String currentMarioImage = "mario_idle_right.png";
    long lastXInputTime = 0;
    boolean isJumping = false;
    long lastUpTime = 0;
    
    public Mario() {
        setImageScaled(currentMarioImage);
    }

    public void act() {
        setImageScaled(currentMarioImage);
        ySpeed = ySpeed + 1;
        setLocation(getX(), getY() + ySpeed);
        getWorld().showText("mariomarioLives : "+ marioLives, 1450, 50);

        if (isTouching(Barrel.class)) {
            removeTouching(Barrel.class);
            marioLives = marioLives - 1;
        }
        
        if (marioLives == 0) {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }

        if(isTouching(Fire.class)) {
            marioLives = marioLives - 1;
        }
        
        if (isTouching(Ladder.class) && Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 2);

            ySpeed = 0;
        }

        if (ySpeed > 0) {
            while (isTouching(Floor.class)) {
                Floor f = (Floor)getOneIntersectingObject(Floor.class);
                ySpeed = 0;
                setLocation(getX(), getY() - 1);
                isJumping = false;
                if (Greenfoot.isKeyDown("up") && !isJumping) {
                    isJumping = true;
                    ySpeed = f.jumpHeight;
                    if (currentMarioImage.contains("left")) {
                        currentMarioImage = "mario_jump_left.png";
                    } else {
                        currentMarioImage = "mario_jump_right.png";
                    }
                }
            }
        }

        if (ySpeed <= 0) {
            while (isTouching(Floor.class)) {
                ySpeed = 0;
                setLocation(getX(), getY() - 1);
                isJumping = false;
                if (currentMarioImage.contains("left")) {
                    currentMarioImage = "mario_idle_left.png";
                } else {
                    currentMarioImage = "mario_idle_right.png";
                }
            }
        }

        if(!isJumping) {
            if(isTouching(Floor.class)) {
                if (currentMarioImage.contains("left")) {
                    currentMarioImage = "mario_idle_left.png";
                } else {
                    currentMarioImage = "mario_idle_right.png";
                }
            }
        }
        if (Greenfoot.isKeyDown("left")) {
            move(-5);
            if(!isJumping) {
                if (System.currentTimeMillis() - lastXInputTime > 50) {
                    if (currentMarioImage.equals("mario_idle_right.png") || currentMarioImage.equals("mario_idle_left.png")) {
                        currentMarioImage = "mario_left.png";
                    } else if (currentMarioImage.equals("mario_left.png")) {
                        currentMarioImage = "mario_left_2.png";
                    } else if (currentMarioImage.equals("mario_left_2.png")) {
                        currentMarioImage = "mario_left_3.png";
                    } else if (currentMarioImage.equals("mario_left_3.png")) {
                        currentMarioImage = "mario_left.png";
                    }
                    lastXInputTime = System.currentTimeMillis();
                    setImageScaled(currentMarioImage);
                }
            }
        } else if (Greenfoot.isKeyDown("right")) {
            move(5);
            if(!isJumping) {
                if (System.currentTimeMillis() - lastXInputTime > 50) {
                    if (currentMarioImage.equals("mario_idle_right.png") || currentMarioImage.equals("mario_idle_left.png")) {
                        currentMarioImage = "mario_right.png";
                    } else if (currentMarioImage.equals("mario_right.png")) {
                        currentMarioImage = "mario_right_2.png";
                    } else if (currentMarioImage.equals("mario_right_2.png")) {
                        currentMarioImage = "mario_right_3.png";
                    } else if (currentMarioImage.equals("mario_right_3.png")) {
                        currentMarioImage = "mario_right.png";
                    }
                    lastXInputTime = System.currentTimeMillis();
                    setImageScaled(currentMarioImage);
                }
            }
        }  else if(currentMarioImage.contains("left")) {
            currentMarioImage = "mario_idle_left.png";
        } else {
            currentMarioImage = "mario_idle_right.png";
        }

        if (Greenfoot.isKeyDown("down")) {
            ySpeed = 50;
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
