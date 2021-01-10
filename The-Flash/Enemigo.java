import java.util.*;

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Personaje
{
    public static final int POS_X_INI = 700;
    public static final int POS_Y_INI = 190;
    /**
     * Constructor for objects of class Enemigo
     */
    public Enemigo()
    {
    }
    
    public void mueveEnemigo() {
        Random aleatorio = new Random();
        int direccionAleatoria = aleatorio.nextInt(9)+1;
        //System.out.println(direccionAleatoria);
        switch(direccionAleatoria)
        {
            case 1:
            muevePersonaje(DireccionDePersonaje.ARRIBA);
            break;
            case 2:
            muevePersonaje(DireccionDePersonaje.ABAJO);
            break;
            case 3:
            muevePersonaje(DireccionDePersonaje.IZQUIERDA);
            break;
            case 4:
            muevePersonaje(DireccionDePersonaje.DERECHA);
            break;
            case 5:
            muevePersonaje(DireccionDePersonaje.DIAG_SUP_IZQ);
            break;
            case 6:
            muevePersonaje(DireccionDePersonaje.DIAG_SUP_DER);
            break;
            case 7:
            muevePersonaje(DireccionDePersonaje.DIAG_INF_IZQ);
            break;
            case 8:
            muevePersonaje(DireccionDePersonaje.DIAG_INF_DER);
            break;
            case 9:
            muevePersonaje(DireccionDePersonaje.ESTATICO);
            break;
        }
    }
    
    @Override
    public void colisiona() {
        if(isTouching(Rayo.class))
        {
            System.out.println("Colision con Rayo!!");
        }
    }
}
