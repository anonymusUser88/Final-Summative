import greenfoot.*;

/**
 * Driver Class / Background Class
 * 
 * Sethumi Hapuarachchi
 * June 4, 2024
 * ICS 4U1
 * Donkey Kong Game
 * 
 * What have I done
 * - Slightly changed some positions
 * 
 * What to fix
 * - Speed of the barrels 
 * - Jankiness of the animation
 */
public class BackGround1 extends World
{

    /**
     * Constructor for objects of class BackGround1.
     * 
     */
    public BackGround1()
    {    
        super(1050, 900, 1); // creating a canvas
        // initializing objects 
        addObject(new DK(), 200, 150); // donkey kong
        // floor blocks
        addObject(new Floor(), 125, 219);
        addObject(new Floor(), 375, 219);
        addObject(new Floor(), 625, 219);
        
        addObject(new Floor2(), 625, 475);
        addObject(new Floor2(), 875, 475);
        addObject(new Floor2(), 1125, 475);
        addObject(new Floor2(), 1375, 475);
        
        addObject(new Floor(), 125, 700);
        addObject(new Floor(), 375, 700);
        addObject(new Floor(), 625, 700);
        
        addObject(new Floor2(), 125, 1000);
        addObject(new Floor2(), 375, 1000);
        addObject(new Floor2(), 625, 1000);
        addObject(new Floor2(), 875, 1000);
        addObject(new Floor2(), 1125, 1000);
        addObject(new Floor2(), 1375, 1000);
        
        addObject(new Mario(), 125, 850); // mario
    }
}
