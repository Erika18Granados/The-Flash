import java.util.ArrayList;
import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

/**
 * Write a description of class Pantalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pantalla extends World
{
    private Sprite spriteDeMundo;
    private GreenfootImage imagen;
    private GifImage cinematica;
    private boolean reproductor;
    private GreenfootSound sonido;
    
    // Una cinematica
    public Pantalla(GifImage cinematica, GreenfootSound sonido) {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        this.sonido = sonido;
        sonido.pause();
        this.cinematica = cinematica;
        reproductor = false;
        this.cinematica.pause();
        setBackground(this.cinematica.getCurrentImage());
        establecePantalla(this);
    }

    // Una sola imagen de fondo
    public Pantalla(GreenfootImage imagen) {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        this.imagen = imagen;
        setBackground(this.imagen);
        establecePantalla(this);
    }

    // Un sprite de fondo
    public Pantalla(ArrayList<String> nombresDeArchivos, int frames, int delay) {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        spriteDeMundo = new SpriteDeMundo(nombresDeArchivos, frames, delay, this);
        establecePantalla(this);
    }

    // Pantalla en blanco
    public Pantalla()
    {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
    }
    
    public GifImage obtenCinematica() {
        return cinematica;
    }
    
    public boolean finDeCinematica() {
        return false;
    }
    
    public void estableceReproductor(boolean startStop) {
        reproductor = startStop;
    }

    // Un mundo ya definido y preparado
    public void establecePantalla(Pantalla pantalla) {
        Greenfoot.setWorld(pantalla);
    }
    
    public void estableceSonido(GreenfootSound sonido) {
        this.sonido = sonido;
    }
    
    public GreenfootSound obtenSonido() {
        return sonido;
    }
    
    public void reproduceSonido() {
        reproductor = true;
        sonido.play();
    }
    
    public void reproduceCinematica() {
        reproductor = true;
        cinematica.resume();
        reproduceSonido();
    }

    // Animacion del spriteDeMundo (si hay)
    @Override
    public void act() {
        // Si hay un spriteDeMundo
        if(spriteDeMundo != null)
        {
            spriteDeMundo.animaSprite();
        } else
            // Si hay una cinematica y se dio play
            if(reproductor == true) 
            {
                if(cinematica != null)
                {
                    setBackground(cinematica.getCurrentImage());
                }
                
                if(sonido != null)
                {
                    reproduceSonido();
                }
            }
    }
}
