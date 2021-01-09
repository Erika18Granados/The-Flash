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
    private GreenfootImage imagen;

    public void cargaItem(Pantalla pantalla, int x, int y, GreenfootImage imagen)
    {
        this.imagen = imagen;
        pantalla.addObject(this, x, y);
        setImage(this.imagen);
    }
    
    public abstract void efecto();
    public abstract boolean colisiona();
}
