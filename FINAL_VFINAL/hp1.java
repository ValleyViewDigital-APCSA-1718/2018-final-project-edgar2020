 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hp1 extends health
{
    /**
     * Act - do whatever the healthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.A
     */ 
    player p1;
    public hp1(int health, player p1)
    {
        super(health,p1,200, 20);
        this.p1=p1;
    }//end of 2-ar constructor
    public void act() 
    {
        setUnit(p1.lives);
        update();
    }    //end of act(updates the meter
    
}//end of hp1 class



