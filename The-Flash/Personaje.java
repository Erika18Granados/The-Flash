import greenfoot.Actor;

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personaje extends Actor
{
    private DireccionDePersonaje direccionDePersonaje;
    private InterfazDeJugador interfazDeJugador;
    
    /**
     * Constructor for objects of class Personaje
     */
    public Personaje()
    {
        interfazDeJugador = new Jugador(this);
    }
    
    @Override
    public void act() {
        // PRUEBA DE INTERFAZ DE JUGADOR
        interfazDeJugador.mueveme(5);
        if(interfazDeJugador.preguntaSiMeClickearon(this))
        {
            interfazDeJugador.pideTexto();
        }
    }
}
