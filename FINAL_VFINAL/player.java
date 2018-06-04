import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class destroyable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
   public int lives = 0;
   public int magazineSize=5;
   private int speed=0;
   private int turning = 6;
   private int delay = 15;
   private int fireSpeed=delay;
   private int reloadTime=0;
   private int maxSpeed=0;
   private boolean forward = true;
   private int mag = 5;
   private boolean icon;
   public player (boolean icon)
   {
      GreenfootImage player = getImage();
      turning = 0;
      player.scale(50, 50);
      setImage(player);
      this.icon=icon;
   }//constructor for the idle tanks
   public player (int lives, int speed, boolean icon)
   {
       this.lives = lives;
       this.icon = icon;
       maxSpeed = speed;
       turning = 6;
       this.speed=maxSpeed;
       turn(Greenfoot.getRandomNumber(359));
   }//constructor for the players
   public void movement()
    {      
            speed=maxSpeed;
            collisions();
            
            if(Greenfoot.isKeyDown("Up"))
            {   
                move(speed);
                forward=true;
                touchingObs();
            }//checks for up button
            else if(Greenfoot.isKeyDown("Down"))
            {
                move(speed*-1);
                forward=false;
                touchingObs();
            }//checks for down button
            if(Greenfoot.isKeyDown("right"))
            {
                turn(turning);
            }//checks for right button
            if(Greenfoot.isKeyDown("left"))
            {
                turn(-turning);
            }//checks for left button
    }//end of movement method
   public void collisions()
   {
       
       //Actor obstacle = null;
       //obstacle = isTouching(destroy)
       if(icon ==true)
       {}//DOES NOTHING IF IT IS JUST AN ICON
       else
       {
           if(getY()<=30)
            {
                setLocation(getX(), 30);
            }//checks for collision on top wall
           else if(getY()>=505)    
           {
                setLocation(getX(), 505);
           }//checks for bottom wall collision
           else
           {
               if(getX()<=25)
               {
                    setLocation(25, getY());
               }//checks for left wall collision
               if(getX()>=665)
                {
                    setLocation(665, getY());
                }//checks for right wall collision
            }//checks to see if hiting the right or left walls
        }//if it is not an icon check for collisiosn.
   }// cecks collsiions
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
          }//makes sure player is stoped by obstacles
      }//chcks to see if touching an obstacle
    }
   public void shoot()
   {
        if(fireSpeed>=delay&&Greenfoot.isKeyDown("m")&& magazineSize>0)
        {
            fireSpeed=0;
            World myWorld;
            myWorld = getWorld();
            bullet projectile = new bullet(getRotation(), this, 1);            
            myWorld.addObject(projectile, getX(), getY());
            reloadTime=0;
            magazineSize--;
            
        }//checks to see if all conditions necessary to shoot are met
        if(magazineSize<=0||(Greenfoot.isKeyDown("n")&&Greenfoot.isKeyDown("m")==false))
        {
            reloadTime++;
            if(reloadTime>150)
            {
                magazineSize=mag;
                reloadTime=0;
            }//makeshift timer to make sure it takes time to reload
        }//reloads
        fireSpeed++;
   }//END OF SHOOT METHOD

   public int getSpeed()
   {
       return speed;
   }//end of get Speed
   public int getDelay()
   {
       return delay;
   }//end of get delay
   public int getReloadTime()
   {
       return reloadTime;
   }//end of getReload time
   public int getMagazineSize()
   {
       return magazineSize;
   }//end of getMagazineSize
   public void setMagazineSize(int s)
   {
      mag=s;
   }//end of set magazine size
   public int getMaxSpeed()
   {
       return maxSpeed;
   }//end of getMaxSpeed
   public int getLives()
   {
       return lives;
    }//end of getLives
    public void takeHealth()
   {
       lives--;
    }//end of takeHealth
   public int getMagSize()
   {
       return magazineSize;
   }//end of getMagSize(I relize that i repeated this code, but still have not fixed that)
}



