import java.util.ArrayList;
import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Write a description of class Pantalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pantalla extends World
{
    private Sprite spriteDeMundo;
    
    public Pantalla(GreenfootImage imagen) {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        super.setBackground(imagen);
    }
    
    public Pantalla(ArrayList<String> nombresDeArchivos, int frames, int delay) {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        spriteDeMundo = new SpriteDeMundo(nombresDeArchivos, frames, delay, this);
    }
    
    public Pantalla()
    {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
    }
    
    public void establecePantalla(Pantalla pantalla) {
        Greenfoot.setWorld(pantalla);
    }
    
    @Override
    public void act() {
        if(spriteDeMundo != null)
        {
            spriteDeMundo.animaSprite();
        }
    }
}
