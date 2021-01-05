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
public abstract class Menu extends Pantalla
{   
    /*
    CargadorDePantallaDeMenu cargadorDePantallaDeMenu;
    ArrayList<CargadorDePantalla> cargadorDePantallaInstrucciones;*/
    // Submenu
    public void cargaSubMenu(CargadorDePantallaDeMenu cargadorDeMenu, CargadorDePantallaDeMenu cargadorDeSubmenu) {
        
    }
    
    // Botones de regreso
    public void cargaMenu(CargadorDePantallaDeMenu cargadorDePantallaDeMenu, ArrayList<CargadorDePantalla> cargadoresDePantallaDeBotones) {
        // Prepara la pantalla del menu
        cargadorDePantallaDeMenu.preparaPantalla(cargadoresDePantallaDeBotones);
        // Prepara la pantalla de los botones
        cargadoresDePantallaDeBotones.forEach(cargadorDePantalla -> cargadorDePantalla.preparaPantalla(new ArrayList<CargadorDePantalla>(Arrays.asList(cargadorDePantallaDeMenu)))); 
    }
}