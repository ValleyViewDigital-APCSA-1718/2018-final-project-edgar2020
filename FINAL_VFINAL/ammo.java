 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ammo extends meter
{
    /**
     * Act - do whatever the healthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.A
     */
    int mag;
    int changePer;
    player p;
    public ammo(int mag, player p, int width, int height)
    {
        super(width,height,mag, Color.ORANGE);
        this.p=p;
        this.mag=mag;
    }//4-arg constructor
    public void setUnit(int units)
    {
        setUnits(units);
    }//sends units up to meter
    
}//end of ammo class
