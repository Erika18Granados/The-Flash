import java.util.ArrayList;
/**
 * Write a description of class CargadorDePantalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CargadorDePantalla  
{
    public Pantalla cargaPantalla() {
        return (new Pantalla());
    }
    public abstract Pantalla cargaPantallaDeMenu(ArrayList<Boton> botones,Sprite spriteMenu);
}

