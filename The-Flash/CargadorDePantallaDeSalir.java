import java.util.ArrayList;
import greenfoot.GreenfootImage;

/**
 * Pantalla de salir, agregar botones de confirmacion
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDePantallaDeSalir extends CargadorDePantallaDeMenu
{
    /**
     * Constructor for objects of class CargadorDePantallaDeSalir
     */
    public CargadorDePantallaDeSalir()
    {
        ArrayList<String> nombresDeArchivosDeBoton = new ArrayList<String>();
        ArrayList<Integer> coordenadasDeBotones = new ArrayList<Integer>();

        nombresDeArchivosDeBoton.add("images/menu/principal/botones/regresar/[normal]Regresar.png");
        nombresDeArchivosDeBoton.add("images/menu/principal/botones/regresar/[hover]Regresar.png");
        coordenadasDeBotones.add(117);
        coordenadasDeBotones.add(58); //100, 100

        cargaMenu(nombresDeArchivosDeBoton, coordenadasDeBotones, 1, new GreenfootImage("images/menu/principal/pantallas/salir/salir.png"));

    }
}
