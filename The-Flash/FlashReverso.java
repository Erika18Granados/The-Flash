import java.util.ArrayList;

/**
 * Write a description of class FlashReverso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlashReverso extends Enemigo
{
    /**
     * Constructor for objects of class FlashReverso
     */
    public FlashReverso(Pantalla pantalla)
    {
        ArrayList<GifImage> spritesDePersonaje = new ArrayList<GifImage>();
        spritesDePersonaje.add(new GifImage("images/personajes/flashreverso/static/flash-reverso-static-der.gif"));
       
        creaPersonaje(Flash.SUPER_VELOCIDAD, new Jugador(this), spritesDePersonaje, pantalla, 100, 350);
    }
    
    
    @Override
    public void act() {
        animaSprite(0);
        colisiona();
    }
}
