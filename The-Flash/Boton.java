import greenfoot.Actor;
import greenfoot.World;
import greenfoot.MouseInfo;
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

    public void cargaBoton(ArrayList<String> nombresDeArchivos, int x, int y, World mundo)
    {
        this.x = x;
        this.y = y;
        mundo.addObject(this, this.x, this.y);

        spriteBoton = new SpriteDeActor(nombresDeArchivos, framesBoton, delayBoton, this);
    }

    public void muestraBoton(int frame) {
        if(frame == 1) {
            spriteBoton.fijaFrame(0);
        } else {
            spriteBoton.fijaFrame(1);
        }
    }

    public boolean estaPresionado(MouseInfo infoDeMouse) {
        if(infoDeMouse.getButton() == 1 &&
            infoDeMouse.getX() > x && infoDeMouse.getX() < x + spriteBoton.obtenFrame(spriteBoton.obtenIterador()).getWidth() &&
            infoDeMouse.getY() > y && infoDeMouse.getY() < y + spriteBoton.obtenFrame(spriteBoton.obtenIterador()).getHeight()) {
            System.out.println("Boton presionado!");
            return true;
        } else {
            return false;
        }
    }
}
