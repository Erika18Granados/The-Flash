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
    public static final int SUPER_VELOCIDAD = 4;
    public static final int VELOCIDAD_9 = 10;
    
    private SimpleTimer cronometro;
    private Item mira;
    private boolean cargandoRayo;

    /**
     * Constructor for objects of class Flash
     */
    public Flash(Pantalla pantalla)
    {
        ArrayList<GifImage> spritesDePersonaje = new ArrayList<GifImage>();
        cronometro = new SimpleTimer();
        cargandoRayo = false;
        
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-static-der/flash-static.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-static-der/flash-static-super.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-corriendo-der/flash-corriendo-der.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-impactado-der/flash-impactado.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/cargando-rayo/flash-rayo.gif"));

        creaPersonaje(SUPER_VELOCIDAD, new Jugador(this), spritesDePersonaje, pantalla, 100, 400);
        
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
    public void colisiona() {
        if(isTouching(FlashReverso.class))
        {
            System.out.println("Colision con flash reverso");
            animaSprite(SPRITE_IMPACTADO);
        }
    }

    @Override
    public void act() {
        
        //animaSprite(0);
        obtenInterfazDeJugador().muevePersonaje();
        colisiona();
        if(obtenInterfazDeJugador().pideTecla("1"))
        {
            if(cronometro.millisElapsed() > 5000)
            {
                System.out.println("Velocidad 9 activada");
                cambiaVelocidad(VELOCIDAD_9);
                cronometro.mark();
            }
        } else 
            if(obtenVelocidad() == VELOCIDAD_9 && cronometro.millisElapsed() > 5000)
            {
                cambiaVelocidad(SUPER_VELOCIDAD);
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
