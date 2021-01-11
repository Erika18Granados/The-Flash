import greenfoot.*;

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    Personaje flashReverso;
    Personaje flash;

    /**
     * Constructor for objects of class HUD
     */
    public HUD(Personaje flash, Personaje flashReverso, Pantalla pantalla)
    {
        this.flash = flash;
        this.flashReverso = flashReverso;
        pantalla.addObject(this, 400, 37);
        setImage(new GreenfootImage("images/HUD.png"));
    }
}
