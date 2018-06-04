import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     *  
     */
   int[][] spaceLeft = new int[14][14];
   private int xPos;
   private int yPos;
   health hp1;
   health hp2;
   ammo ammo1;
   ammo ammo2;
    public MyWorld()
    {    
         
    
       super(700, 700, 1); 
       //makes square playing feild(700x700)
       for(int row = 0; row<spaceLeft.length; row++)
       {
           for(int col = 0; col<spaceLeft[0].length; col++)
           {
               spaceLeft[row][col]=0;
           }       //end of inner for loop
       }//end of for loop, gives all of 2D array value of 0
       player P1= new P1(5, 5, false); 
       player P2 = new P2(5, 5, false);//creates players
       hp1= new hp1(P1.getLives(), P1);
       hp2 = new hp1(P2.getLives(), P2);//creates hp bars
       ammo1 = new ammo1(P1.getMagazineSize(), P1);
       ammo2=new ammo1(P2.getMagazineSize(), P2);//creates ammo bars
       border b = new border();//creates the border
       
       addObject(b, 350, 270);//adds the border
       
       xPos = Greenfoot.getRandomNumber(13);
       yPos = Greenfoot.getRandomNumber(10);
       spaceLeft[xPos][yPos]=1;
       addObject(P1, (xPos+1)*50, (yPos+1)*50);//sets pos and adds player 1
       while(spaceLeft[xPos][yPos]==1)
           {
               xPos = Greenfoot.getRandomNumber(13);
               yPos = Greenfoot.getRandomNumber(10);
           }//makes sure players don't same spot
           
       spaceLeft[xPos][yPos]=1;
       addObject(P2, (xPos+1)*50, (yPos+1)*50);//sets pos and adds player 2
       for(int i = 1; i<Greenfoot.getRandomNumber(80)+20;i++)
       {
            xPos = Greenfoot.getRandomNumber(13);
            yPos = Greenfoot.getRandomNumber(10);
           destroyable crate = new crate();
           while(spaceLeft[xPos][yPos]==1)
           {
               xPos = Greenfoot.getRandomNumber(13);
               yPos = Greenfoot.getRandomNumber(10);
           }//males sure no two obstacles share the same spot
           spaceLeft[xPos][yPos]=1;
           addObject(crate, (xPos+1)*50, (yPos+1)*50);
       }//creates and adds random number of crates without overlapping
       
       addObject(hp1, 170, 600);
       addObject(hp2, 570, 600);
       addObject(ammo1, 145, 617);
       addObject(ammo2, 545, 617);  
       addObject(new P1(true), 40, 600);
       addObject(new P2(true), 440, 600);//adds the hp and ammo bars, also adds players icons.
       
       
    }
   
}




