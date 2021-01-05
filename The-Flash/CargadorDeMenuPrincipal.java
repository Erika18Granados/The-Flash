import java.util.ArrayList;
import java.util.Arrays;
import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;

/**
 * Write a description of class CargadorDeMenuPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDeMenuPrincipal extends CargadorDePantallaDeMenu
{
    public CargadorDeMenuPrincipal() {
        ArrayList<String> nombresDeArchivosDeBoton = new ArrayList<String>();
        ArrayList<Integer> coordenadasDeBotones = new ArrayList<Integer>();
        ArrayList<String> nombresDeArchivosDeMenu = new ArrayList<String>();

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
        }

        cargaMenu(nombresDeArchivosDeBoton, coordenadasDeBotones, 4, nombresDeArchivosDeMenu, 5);
        agregaSonido(new GreenfootSound("sounds/menu/principal/the-flash-theme.mp3"));
    }
    /*
    @Override
    public void preparaPantalla(ArrayList<CargadorDePantalla> cargadorDePantalla) {
    preparaMenu(cargadorDePantalla);
    }*/
}
