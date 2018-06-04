 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class health extends meter
{
    /**
     * Act - do whatever the healthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.A
     */
    int hp;
    int changePer;
    
    player p;
    public health(int hp, player p, int width, int height)
    {
        super(width,height,hp, Color.GREEN);
        this.p=p; 
        this.hp=hp;
    }//4 arg constructor
    public void setUnit(int units)
    {
        setUnits(units);
    }//sets the health(units) and sends the, to meter
    
}//end of health class
