import greenfoot.Actor;
import greenfoot.World;
import greenfoot.Greenfoot;
import java.util.ArrayList;

/**
 * Esta clase es un boton que puede ser presionado dentro de un Menu o cualquier parte del juego
 * 
 * @Angel Maldonado (your name) 
 * @12/16/20
 */
public abstract class Boton extends Actor
{
    /**
     * DEFINIR CONSTANTES PARA EL DELAY Y LOS FRAMES DE SPRITEBOTON
     */
    private static final int framesBoton = 2;
    private static final int delayBoton = 1;

    private Sprite spriteBoton;
    private int x;
    private int y;
    private boolean presionado;

    public void cargaBoton(ArrayList<String> nombresDeArchivos, int x, int y, World mundo)
    {
        this.x = x;
        this.y = y;
        presionado = false;
        mundo.addObject(this, this.x, this.y);

        spriteBoton = new SpriteDeActor(nombresDeArchivos, framesBoton, delayBoton, this);
    }

    public void muestraBoton(int frame) {
        spriteBoton.fijaFrame(frame);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean estaClickeado() {
        if(Greenfoot.mouseClicked(this))
        {
            spriteBoton.fijaFrame(1);
            System.out.println("Boton presionado!");
            presionado = true;
        }
        return presionado;
    }
}
