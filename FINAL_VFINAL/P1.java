import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P1 extends player implements movables
{
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int lives = getLives(); 
    private int speed=getSpeed();
    private int delay = getDelay();
    private int fireSpeed=delay;
    private int magazineSize=getMagazineSize();
    private int reloadTime=getReloadTime();
    public P1(boolean icon)
    {
        super(icon);
    }//icon constructor
    public P1(int lives, int speed, boolean icon) 
    {
        super(lives, speed, icon);
        this.lives=lives;
        GreenfootImage player = getImage();
        player.scale(50, 50);
        setImage(player);
    }//end of tri-constructo
    public void act() 
    {
        movement();
        shoot();
    } //end of act
}//end of p1 class





