import java.util.ArrayList;
import java.util.Arrays;
import greenfoot.GreenfootImage;

/**
 * Write a description of class CargadorDePantallaDeMision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDePantallaDeMision extends CargadorDePantallaDeMenu
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CargadorDePantallaDeMision
     */
    public CargadorDePantallaDeMision()
    {
        ArrayList<String> nombresDeArchivosDeBoton = new ArrayList<String>();
        ArrayList<Integer> coordenadasDeBotones = new ArrayList<Integer>();

        nombresDeArchivosDeBoton.add("images/menu/principal/botones/regresar/[normal]Regresar.png");
        nombresDeArchivosDeBoton.add("images/menu/principal/botones/regresar/[hover]Regresar.png");
        coordenadasDeBotones.add(117);
        coordenadasDeBotones.add(58); //100, 100

        cargaMenu(nombresDeArchivosDeBoton, coordenadasDeBotones, 1, new GreenfootImage("images/menu/STAR/pantallas/mision.png"));

    }
}
