import greenfoot.GreenfootSound;

/**
 * Write a description of class CinematicaDeInicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CinematicaDeInicio extends CargadorDeCinematica
{
    /**
     * Constructor for objects of class CinematicaDeInicio
     */
    public CinematicaDeInicio()
    {
        cargaCinematica(new GifImage("images/cinematicas/intro.gif"), new GreenfootSound("sounds/cinematicas/intro.mp3"));
    }
}
