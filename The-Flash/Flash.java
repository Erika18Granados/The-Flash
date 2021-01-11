import greenfoot.GreenfootImage;
import java.util.ArrayList;

/**
 * Write a description of class Flash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flash extends Personaje
{
    public static final int SPRITE_STATIC = 0;
    public static final int SPRITE_STATIC_SUPER = 1;
    public static final int SPRITE_CORRIENDO = 2;
    public static final int SPRITE_IMPACTADO = 3;
    public static final int SPRITE_CARGANDO_RAYO = 4;
    private static final int VIDA_FLASH = 4000;
    
    private Item mira;
    private boolean cargandoRayo;
    private int vida;
    
    private Counter vidaFlash;


    /**
     * Constructor for objects of class Flash
     */
    public Flash(Pantalla pantalla)
    {
        ArrayList<GifImage> spritesDePersonaje = new ArrayList<GifImage>();
        cargandoRayo = false;
        
        vidaFlash = new Counter("VIDA FLASH: ");
        vida = VIDA_FLASH;
        pantalla.addObject(vidaFlash, 120, 100);
        vidaFlash.setValue(vida);
        
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-static-der/flash-static.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-static-der/flash-static-super.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-corriendo-der/flash-corriendo-der.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-impactado-der/flash-impactado.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/cargando-rayo/flash-rayo.gif"));    
        //spritesDePersonaje.add(new GifImage("images/personajes/flash/cargando-rayo/flash-rayo.gif"));

        creaPersonaje(Velocidades.VELOCIDAD_FLASH, new Jugador(this), spritesDePersonaje, pantalla, 100, 400, VIDA_FLASH);
        
        // Tamano original 18 x 33
        ajustaSprite(18*ESCALAR_SPRITES, 33*ESCALAR_SPRITES, SPRITE_STATIC);
        ajustaSprite(18*ESCALAR_SPRITES, 33*ESCALAR_SPRITES, SPRITE_STATIC_SUPER);
        // Tamano original 23 x 29
        ajustaSprite(23*ESCALAR_SPRITES, 29*ESCALAR_SPRITES, SPRITE_CORRIENDO);
        // Tamano original 64 x 65
        ajustaSprite(64*ESCALAR_SPRITES, 65*ESCALAR_SPRITES, SPRITE_CARGANDO_RAYO);
        
        mira = new Mira(pantalla, obtenInterfazDeJugador());
    }

    @Override
    public boolean colisiona() {
        if(isTouching(FlashReverso.class))
        {
            animaSprite(SPRITE_IMPACTADO);
            vida-=20;
            vidaFlash.setValue(vida);
            return true;
        }
        if(isTouching(Rayo.class))
        {
            vida-=30;
            vidaFlash.setValue(vida);
            return true;
        }
        return false;
    }

    @Override
    public void act() {
        obtenInterfazDeJugador().muevePersonaje();
        colisiona();
        if(obtenInterfazDeJugador().pideTecla("1"))
        {
            if(cronometro.millisElapsed() > 5000)
            {
                cambiaVelocidad(Velocidades.VELOCIDAD_9);
                cronometro.mark();
            }
        } else 
            if(obtenVelocidad() == Velocidades.VELOCIDAD_9 && cronometro.millisElapsed() > 5000)
            {
                cambiaVelocidad(Velocidades.VELOCIDAD_FLASH);
                cronometro.mark();
            }
        if(obtenInterfazDeJugador().pideTecla("2"))
        {
            animaSprite(SPRITE_CARGANDO_RAYO);
            if(obtenInterfazDeJugador().pideInfoDeMouse() != null)
            {
                mira.efecto();
            }
        } else {
            cargandoRayo = false;
            mira.setLocation(Mira.X_INI_MIRA, Mira.Y_INI_MIRA);
        }
    }
}
