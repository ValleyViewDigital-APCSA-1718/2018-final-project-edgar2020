import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends Actor
{
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int delay = 0;
    player shooter;
    World myWorld;
    private int p;
    public bullet(int rotation, player shooter, int p)
    {
        GreenfootImage b1 = getImage();
        b1.scale(20, 20);
        setImage(b1);
        this.shooter = shooter;
        this.p=p;
        turn(rotation);   
    }//creates bullet at rotation of player
    public void act() 
    {
        myWorld=  getWorld();
        boolean contact = hit();
        boolean destroyBox = destroy();
        move(15);
        if(getY()<=10||getY()>=535||contact==true||getX()<=10||getX()>=690||destroyBox==true)
        {
            myWorld.removeObject(this);
        }//deleates if it collides with something
 
    } //end of act
    public boolean hit()
    {
        Actor dead = null;
        dead = getOneObjectAtOffset(3, 3, player.class);
        MyWorld theWorld = (MyWorld)myWorld;
        player damaged = theWorld.getObjects(P1.class).get(0);
        player damaged1 = theWorld.getObjects(P2.class).get(0);
        delay++;
        
        boolean hit = false;
        if(dead!=null&&dead!=shooter)
        {
            //myWorld.removeObject(dead);
            if(p==1)
            {
                damaged1.takeHealth(); 
                if(damaged1.lives<=0)     
                {
                    //myWorld.removeObject(dead);
                    damaged1.setMagazineSize(0); 
                    damaged.setMagazineSize(0); 
                    myWorld.addObject(new P1Wins(), 350, 270);
                }//shows a game over if a player life below 0
            }//checks to see which player is losing health
            if(p==2)
            {
                damaged.takeHealth();
                if(damaged.lives<=0)     
                {
                   // myWorld.removeObject(dead);
                   damaged.setMagazineSize(0); 
                   damaged1.setMagazineSize(0); 
                   myWorld.addObject(new P2Wins(), 350, 270);
                }//shows game over if lives reaches 0
            }//runs if player 2 is the one shooting
            hit = true;  
        }//runs to see if there is a correcct colision
        return hit;
    }//returns if the bullet indeed hit a proper target
    public boolean destroy()
    {
        Actor box = null;
        box = getOneObjectAtOffset(3, 3, destroyable.class);
        delay++;
        boolean hit = false;
        if(box!=null)
        {
            
            myWorld.removeObject(box);
            hit = true;  
        }//deletes obstacle andreturns true so that the bullet also gets earased.
        return hit;
    }//destroys obstacle if collision with buller
}//end of bullet class