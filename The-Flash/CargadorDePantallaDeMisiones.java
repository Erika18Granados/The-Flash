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
        obtenPantalla().setPaintOrder(Flash.class, FlashReverso.class, HUD.class);
        Personaje flash = new Flash(obtenPantalla());
        Personaje flashReverso = new FlashReverso(obtenPantalla(), flash);
        HUD hud = new HUD(flash, flashReverso, obtenPantalla());
        
    }
}
