import java.util.ArrayList;

/**
 * Write a description of class FlashReverso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlashReverso extends Enemigo
{
    public static final int SPRITE_FLAS_REV_STAT = 0;
    
    /**
     * Constructor for objects of class FlashReverso
     */
    public FlashReverso(Pantalla pantalla)
    {
        ArrayList<GifImage> spritesDePersonaje = new ArrayList<GifImage>();
        spritesDePersonaje.add(new GifImage("images/personajes/flashreverso/static/flash-reverso-static-der.gif"));
        
        creaPersonaje(Flash.SUPER_VELOCIDAD, new Jugador(this), spritesDePersonaje, pantalla, POS_X_INI, POS_Y_INI);
        // Tamano original: 15 x 32
        ajustaSprite(15*ESCALAR_SPRITES, 32*ESCALAR_SPRITES, SPRITE_FLAS_REV_STAT);
    }
    
    
    @Override
    public void act() {
        animaSprite(0);
        colisiona();
        mueveEnemigo();
    }
}
