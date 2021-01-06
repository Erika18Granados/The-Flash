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
    private Rayo rayo;
    private boolean cargandoRayo;

    /**
     * Constructor for objects of class Flash
     */
    public Flash(Pantalla pantalla)
    {
        ArrayList<GifImage> spritesDePersonaje = new ArrayList<GifImage>();
        cronometro = new SimpleTimer();
        cargandoRayo = false;
        //cronometro = new Counter("Supervelocidad: ");
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-static-der/flash-static.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-static-der/flash-static-super.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-corriendo-der/flash-corriendo-der.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/flash-impactado-der/flash-impactado.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flash/cargando-rayo/flash-rayo.gif"));

        creaPersonaje(SUPER_VELOCIDAD, new Jugador(this), spritesDePersonaje, pantalla, 100, 400);
        rayo = new Rayo(pantalla, obtenInterfazDeJugador());
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
                rayo.efecto();
            }
        } else {
            cargandoRayo = false;
            //rayo.move(rayo.distanciaPorCubrir);
        }
    }
}
