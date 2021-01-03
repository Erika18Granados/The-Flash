
import greenfoot.MouseInfo;
import greenfoot.Greenfoot;
import greenfoot.Actor;

/**
 * El control de esta clase es tomado por el usuario del juego, toda la informacion
 * que entre o salga de aqui el responsable sera el mismo usuario o cualquier clase
 * que implemente la InterfazDeJugador dentro del juego
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador implements InterfazDeJugador
{
    Personaje personaje;
    MouseInfo infoDeMouseDeJugador;
    private String ultimaTeclaPresionada;
    /**
     * Constructor for objects of class Jugador
     */
    public Jugador()
    {

    }

    public Jugador(Personaje personajeQueControla) {
        personaje = personajeQueControla;
    }

    @Override
    public String pideTexto() {
        return Greenfoot.ask("Introduce texto");
    }

    @Override
    public String pideTecla() {
        ultimaTeclaPresionada = Greenfoot.getKey();
        return ultimaTeclaPresionada;
    }

    @Override
    public MouseInfo pideInfoDeMouse() {
        infoDeMouseDeJugador = Greenfoot.getMouseInfo();
        // Si se presiono algun boton (VERSION DE PRUEBA ----> COMENTAR CONDICIONAL)
        if(infoDeMouseDeJugador != null)
        {
            if(infoDeMouseDeJugador.getButton() > 0)
            {
                switch(infoDeMouseDeJugador.getButton())
                {
                    // Click izquierdo
                    case 1:
                    System.out.println("RATON: boton izquierdo!");
                    break;
                    // Rueda de raton
                    case 2:
                    System.out.println("RATON: boton rueda!");
                    break;
                    // Click derecho
                    case 3:
                    System.out.println("RATON: boton derecho!");
                    break;
                }
                System.out.println("click: (" + infoDeMouseDeJugador.getX() + ", " + infoDeMouseDeJugador.getY() + ")");
            }
        }
        return infoDeMouseDeJugador;
    }

    @Override
    public boolean preguntaSiMeClickearon(Actor actor) {
        /* CLICK SIMPLE (SIN DRAGG)
        if(Greenfoot.mousePressed(actor))
        {
            System.out.println("Actor clickeado! -> " + actor);
            return true;
        } else
            return false;
        */
        
        if(pideInfoDeMouse() != null)
        {
            // Si el cursor esta encima del actor
            if(infoDeMouseDeJugador.getActor() == actor)
            {
                System.out.print("RATON: encima de actor -> " + actor);
                
                // Si se presiono el click derecho encima del actor
                if(infoDeMouseDeJugador.getButton() == 1)
                {
                    System.out.println(" -> Clickeado!");
                    return true;
                } else {
                    System.out.println("");
                    return false;
                }
            } else
            return false;
        }else return false;
    }

    @Override
    public void mueveme(int velocidad) {
        // Estas variables deben ser del Personaje
        int movimientoEnY = 0;
        int movimientoEnX = 0;

        pideTecla();

        if(ultimaTeclaPresionada != null)
        {
            System.out.println("JUGADOR PRESIONO: " + ultimaTeclaPresionada);
            switch(ultimaTeclaPresionada)
            {
                case "up":
                movimientoEnY = -velocidad;
                personaje.turnTowards(personaje.getX(), 0);
                /*
                 * personaje.direccion = CharacterDirection.UP <--- Hacer esto para todas las direcciones
                 */

                break;
                case "down":
                movimientoEnY = velocidad;
                personaje.turnTowards(personaje.getX(), personaje.getWorld().getHeight());
                break;
                case "left":
                movimientoEnX = -velocidad;
                personaje.turnTowards(0, personaje.getY());
                break;
                case "right":
                movimientoEnX = velocidad;
                personaje.turnTowards(personaje.getWorld().getWidth(), personaje.getY());
                break;
            }
            personaje.setLocation(personaje.getX() + movimientoEnX, personaje.getY() + movimientoEnY);
        }
    }
}
