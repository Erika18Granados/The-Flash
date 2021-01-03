import java.util.ArrayList;
import java.util.Arrays;
import greenfoot.World;
import greenfoot.MouseInfo;
import greenfoot.GreenfootImage;

/**
 * Esta clase es un menu que contiene un arreglo de BotonDeMenu, los cuales realizan una accion dependiendo del Boton
 * Tiene un arreglo de World's por si alguno de esos BotonDeMenu's requiere crear otra pantalla y de esta manera queden guardados los
 * World's por si se requiere regresar a alguno de ellos.
 * 
 * @Angel Maldonado (your name) 
 * @12/16/20
 */
public class Menu extends Pantalla
{   
    private ArrayList<String> nombresDeArchivosDeBoton = new ArrayList<String>();
    private ArrayList<Integer> coordenadasDeBotones = new ArrayList<Integer>();
    private CargadorDePantalla cargadorDePantalla;
    private ArrayList<CargadorDePantalla> cargadoresDePantallaDeBotones = new ArrayList<CargadorDePantalla>();
    private ArrayList<String> nombresDeArchivosDeMenu = new ArrayList<String>();
    public Menu() {
        for(int archivoDeMenu = 1; archivoDeMenu <= 15; archivoDeMenu++)
        {
            nombresDeArchivosDeMenu.add("images/menu/principal/flash/flash-" + archivoDeMenu + ".png");
        }

        for(int boton = 1; boton <= 4; boton++)
        {
            switch(boton)
            {
                case 1:
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/jugar/" + "[normal]jugar" + ".png");
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/jugar/" + "[hover]jugar" + ".png");
                break;
                case 2:
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/instrucciones/" + "[normal]instrucciones" + ".png");
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/instrucciones/" + "[hover]instrucciones" + ".png");
                break;
                case 3:
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/records/" + "[normal]records" + ".png");
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/records/" + "[hover]records" + ".png");
                break;
                case 4:
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/salir/" + "[normal]salir" + ".png");
                nombresDeArchivosDeBoton.add("images/menu/principal/botones/salir/" + "[hover]salir" + ".png");
                break;
            }
            coordenadasDeBotones.add(100);
            coordenadasDeBotones.add(100*boton); //100, 80
            cargadoresDePantallaDeBotones.add(new CargadorDePantallaDeInstrucciones());
            //pantallasDeBoton.add(new Pantalla(new GreenfootImage("images/menu/principal/flash/flash-15.png")));
        }
        
        
        CargadorDePantalla cargadorDePantalla = new CargadorDePantallaDeMenu(nombresDeArchivosDeBoton, coordenadasDeBotones,
                                                                                nombresDeArchivosDeMenu, 5, cargadoresDePantallaDeBotones);
        establecePantalla(cargadorDePantalla.cargaPantalla());
        //establecePantalla(pantallasDeBoton.get(0));
        //Greenfoot.setWorld(pantallasDeBoton.get(0));
    }
}