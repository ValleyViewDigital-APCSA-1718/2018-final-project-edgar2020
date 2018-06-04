import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P2 extends player implements movables
{
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed=getSpeed();
    private int delay = getDelay();
    private int turning = 6;
    private int fireSpeed=delay;
    public int magazineSize=getMagazineSize();
    private int reloadTime=getReloadTime();
    private int maxSpeed=getMaxSpeed();
    private boolean forward = true;
    public P2(boolean icon)
    {
        super(icon);
        GreenfootImage player = getImage();
        turning =0;
        player.scale(50, 50);
        setImage(player);
    }
    public P2(int lives, int speed, boolean icon) 
    {
        super(lives, speed, icon);
        this.lives=lives;
        GreenfootImage player = getImage();
        player.scale(50, 50);
        turning=6;
        setImage(player);
    }
    public void act() 
    {
        movement();
        shoot();
        
    }   
    
    public void movement()
    {
           speed=maxSpeed;
            collisions();
            
            if(Greenfoot.isKeyDown("w"))
            {
                //setRotation(10);
                //collisions();
                move(speed);
                forward=true;
                touchingObs();
            }//end of Up
            if(Greenfoot.isKeyDown("s"))
            {
                move(speed*-1);
                forward=false;
                touchingObs();
            }
            if(Greenfoot.isKeyDown("d"))
            {
                turn(turning);
            }
            if(Greenfoot.isKeyDown("a"))
            {
                turn(-turning);
            }
            
    }
    public void shoot()
    {
        if(fireSpeed>=delay&&Greenfoot.isKeyDown("q")&&magazineSize>0)
        {
            fireSpeed=0;
            World myWorld;
            myWorld = getWorld();
            bullet projectile = new bullet(getRotation(), this, 2);
            
            myWorld.addObject(projectile, getX(), getY());
            reloadTime=0;
            magazineSize--;

        }
        reload();//reload
        fireSpeed++;
    }//end of shoot
    public void reload()
    {
        if(magazineSize<=0||(Greenfoot.isKeyDown("1")&&Greenfoot.isKeyDown("q")==false))
        {
            reloadTime++;
            if(reloadTime>150)
            {
                magazineSize=5;
                reloadTime=0;
            }//reload timer
        }//reloads if out of ammo
    }//end of reload
    public void touchingObs()
    {
      if(isTouching(destroyable.class))
      {
          Actor obs = getOneObjectAtOffset(-5, -5, destroyable.class);
            if(isTouching(destroyable.class))
            {
                if(forward==true)
                    move((speed+1)*-1);
                if(forward==false)
                    move((speed+1));
            }//makes sure p2 does not go through an obstacle
        }//checks if p2 is touching an obstacle

    }//end of thouchingObbs
  
    public int getMagSize()
    {
        return magazineSize;
    }//return magazine
   
}//end of P2 class





