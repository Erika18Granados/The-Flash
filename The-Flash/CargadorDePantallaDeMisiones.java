import java.util.ArrayList;
import greenfoot.GreenfootImage;

/**
 * Write a description of class CargadorDePantallaDeMisiones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDePantallaDeMisiones extends CargadorDePantalla
{
    public CargadorDePantallaDeMisiones() {
        cargaPantallaConImagen(new GreenfootImage("images/misiones/Mision1.png"));
        preparaPantalla(null);
    }
    
    @Override
    public void preparaPantalla(ArrayList<CargadorDePantalla> cargadorDePantalla) {
        new FlashReverso(obtenPantalla());
        new Flash(obtenPantalla());
    }
}
