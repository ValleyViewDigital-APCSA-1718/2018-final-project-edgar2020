import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class border here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class border extends Actor
{
    /**
     * Act - do whatever the border wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public border()
    {
        GreenfootImage border = getImage();
        border.scale(700, 550);
        setImage(border);
    }//end of border resizes and sets image
}//end of border class




