import java.util.*;

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemigo extends Personaje
{
    public static final int POS_X_INI = 700;
    public static final int POS_Y_INI = 190;

    int direccionAleatoria;

    Personaje superHeroe;

    /**
     * Constructor for objects of class Enemigo
     */
    public void creaEnemigo(Personaje superHeroe)
    {
        this.superHeroe = superHeroe;
        direccionAleatoria = 0;
    }

    public int eligeDireccion() {
        if(direccionAleatoria == 0 || isAtEdge() || getY() <= ResolucionDePantalla.LIM_AREA_JUEGO)
        {
            Random aleatorio = new Random();
            direccionAleatoria = aleatorio.nextInt(9)+1;
        }
        return direccionAleatoria;
    }

    public void mueveEnemigo() {
        eligeDireccion();
        switch(direccionAleatoria)
        {
            case 1:
            muevePersonaje(DireccionDePersonaje.ARRIBA);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 2:
            muevePersonaje(DireccionDePersonaje.ABAJO);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 3:
            muevePersonaje(DireccionDePersonaje.IZQUIERDA);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 4:
            muevePersonaje(DireccionDePersonaje.DERECHA);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 5:
            muevePersonaje(DireccionDePersonaje.DIAG_SUP_IZQ);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 6:
            muevePersonaje(DireccionDePersonaje.DIAG_SUP_DER);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 7:
            muevePersonaje(DireccionDePersonaje.DIAG_INF_IZQ);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 8:
            muevePersonaje(DireccionDePersonaje.DIAG_INF_DER);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_CORRIENDO);
            break;
            case 9:
            muevePersonaje(DireccionDePersonaje.ESTATICO);
            animaSprite(FlashReverso.SPRITE_FLAS_REV_STAT);
            break;
        }
    }

    public abstract void ataque();

    @Override
    public boolean colisiona() {
        if(isTouching(Rayo.class))
        {
            return true;
        }
        return false;
    }
}
