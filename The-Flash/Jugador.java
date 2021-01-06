
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
    private Personaje personaje;
    private MouseInfo infoDeMouseDeJugador;
    private String ultimaTeclaPresionada;
    /**
     * Constructor for objects of class Jugador
     */
    public Jugador()
    {

    }
    
    // Este constructor es utilizado por el personaje principal
    public Jugador(Personaje personajeQueControla) {
        personaje = personajeQueControla;
    }

    @Override
    public String pideTexto() {
        return Greenfoot.ask("Introduce texto");
    }

    @Override
    public boolean pideTecla(String tecla) {
        return Greenfoot.isKeyDown(tecla);
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
    
    @Override() 
    public Personaje obtenPersonaje(){
        return personaje;
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
    public void muevePersonaje() {
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            personaje.muevePersonaje(DireccionDePersonaje.ARRIBA);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        else
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            personaje.muevePersonaje(DireccionDePersonaje.ABAJO);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        else
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            personaje.muevePersonaje(DireccionDePersonaje.IZQUIERDA);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        else
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            personaje.muevePersonaje(DireccionDePersonaje.DERECHA);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        else
        // ARRIBA IZQUIERDA
        if(Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")) {
            personaje.muevePersonaje(DireccionDePersonaje.DIAG_SUP_IZQ);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        else
        // ARRIBA DERECHA
        if(Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d")) {
            personaje.muevePersonaje(DireccionDePersonaje.DIAG_SUP_DER);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        else
        // ABAJO IZQUIERDA
        if(Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a")) {
            personaje.muevePersonaje(DireccionDePersonaje.DIAG_INF_IZQ);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        else
        // ABAJO DERECHA
        if(Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d")) {
            personaje.muevePersonaje(DireccionDePersonaje.DIAG_INF_DER);
            personaje.animaSprite(Flash.SPRITE_CORRIENDO);
        }
        // ESTATICO
        else
        {
            if(personaje.obtenVelocidad() == Flash.SUPER_VELOCIDAD)
            {
                personaje.muevePersonaje(DireccionDePersonaje.ESTATICO);
                personaje.animaSprite(Flash.SPRITE_STATIC);
            } else
            {
                personaje.muevePersonaje(DireccionDePersonaje.ESTATICO);
                personaje.animaSprite(Flash.SPRITE_STATIC_SUPER);
            }
            
            /*
            personaje.estableceSprite(1);
            personaje.obtenSprite(1).resume();*/
        }
    }
}
