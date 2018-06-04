import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ammo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ammo1 extends ammo
{
    player p1;
    public ammo1(int ammo, player p1)
    {
        super(ammo,p1,150, 13);
        this.p1=p1;
    }//2-arg constructor  
    public void act() 
    {
        setUnit(p1.getMagSize()); 
        update();
    }//end of the act method
    
}//end of ammo1 class