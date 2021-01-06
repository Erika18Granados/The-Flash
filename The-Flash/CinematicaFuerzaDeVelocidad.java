import greenfoot.GreenfootSound;

/**
 * Write a description of class CinematicaFuerzaDeVelocidad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CinematicaFuerzaDeVelocidad extends CargadorDeCinematica
{
    /**
     * Constructor for objects of class CinematicaFuerzaDeVelocidad
     */
    public CinematicaFuerzaDeVelocidad()
    {
        cargaCinematica(new GifImage("images/cinematicas/fuerza-de-velocidad.gif"), new GreenfootSound("sounds/cinematicas/mama.mp3"));
    }
}
