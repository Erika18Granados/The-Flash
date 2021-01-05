import java.util.ArrayList;
import greenfoot.GreenfootSound;

/**
 * Write a description of class CargadorDeCinematica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CargadorDeCinematica extends CargadorDePantalla
{
    // Carga la cinematica en la pantalla
    public Pantalla cargaCinematica(GifImage cinematica, GreenfootSound sonido)
    {
        return cargaPantallaConCinematica(cinematica, sonido);
    }
    
    // Detener el mundo para que inicie solo al presionar el boton
    @Override
    public void preparaPantalla(ArrayList<CargadorDePantalla> cargadorDePantalla) {
    }
}
