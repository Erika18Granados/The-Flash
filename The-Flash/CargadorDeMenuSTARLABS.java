import java.util.ArrayList;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;

/**
 * Write a description of class CargadorDeMenuSTARLABS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDeMenuSTARLABS extends CargadorDePantallaDeMenu
{
    /**
     * Constructor for objects of class CargadorDeMenuSTARLABS
     */
    public CargadorDeMenuSTARLABS()
    {
        ArrayList<String> nombresDeArchivosDeBoton = new ArrayList<String>();
        ArrayList<Integer> coordenadasDeBotones = new ArrayList<Integer>();
        
        nombresDeArchivosDeBoton.add("images/menu/STAR/botones/Recursos/" + "[normal]Recursos" + ".png");
        nombresDeArchivosDeBoton.add("images/menu/STAR/botones/Recursos/" + "[hover]Recursos" + ".png");
        nombresDeArchivosDeBoton.add("images/menu/STAR/botones/Estadisticas/" + "[normal]Estadisticas" + ".png");
        nombresDeArchivosDeBoton.add("images/menu/STAR/botones/Estadisticas/" + "[hover]Estadisticas" + ".png");
        nombresDeArchivosDeBoton.add("images/menu/STAR/botones/Mision/" + "[normal]Mision" + ".png");
        nombresDeArchivosDeBoton.add("images/menu/STAR/botones/Mision/" + "[hover]Mision" + ".png");
        
        coordenadasDeBotones.add(100);
        coordenadasDeBotones.add(100); //100, 80
        coordenadasDeBotones.add(300);
        coordenadasDeBotones.add(100);
        coordenadasDeBotones.add(500);
        coordenadasDeBotones.add(100);

        cargaMenu(nombresDeArchivosDeBoton, coordenadasDeBotones, 5, new GreenfootImage("images/menu/STAR/STAR/starlabs.png"));
        //agregaSonido(new GreenfootSound("sounds/menu/principal/the-flash-theme.mp3"));
    }
}
