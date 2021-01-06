import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Item extends Actor
{
    /**
     * Constructor for objects of class Item
     */
    public void cargaItem(Pantalla pantalla, int x, int y, GreenfootImage imagen)
    {
        pantalla.addObject(this, x, y);
        setImage(imagen);
    }
    
    public abstract void efecto();
}
