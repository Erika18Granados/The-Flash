import java.util.ArrayList;
import java.util.Arrays;
import greenfoot.GreenfootImage;

/**
 * Write a description of class CargadorDePantallaDeEstadisticas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDePantallaDeEstadisticas extends CargadorDePantallaDeMenu
{
    /**
     * Constructor for objects of class CargadorDePantallaDeEstadisticas
     */
    public CargadorDePantallaDeEstadisticas()
    {
        ArrayList<String> nombresDeArchivosDeBoton = new ArrayList<String>();
        ArrayList<Integer> coordenadasDeBotones = new ArrayList<Integer>();

        nombresDeArchivosDeBoton.add("images/menu/principal/botones/regresar/[normal]Regresar.png");
        nombresDeArchivosDeBoton.add("images/menu/principal/botones/regresar/[hover]Regresar.png");
        coordenadasDeBotones.add(117);
        coordenadasDeBotones.add(58); //100, 100

        cargaMenu(nombresDeArchivosDeBoton, coordenadasDeBotones, 1, new GreenfootImage("images/menu/STAR/pantallas/estadisticas.png"));
    }
}
