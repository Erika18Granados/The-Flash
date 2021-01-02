import java.util.ArrayList;
import greenfoot.World;
import greenfoot.MouseInfo;
import greenfoot.Actor; // PRUEBA

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
    private ArrayList<Boton> botones;
    private Sprite spriteMenu;
    public Menu() {
        botones = new ArrayList<Boton>();
        CargadorDePantalla cargadorDePantalla = new CargadorDePantallaDeMenu(botones);
        cargadorDePantalla.cargaPantallaDeMenu(botones,spriteMenu);
    }


    public void act() {
        spriteMenu.animaSprite();
    }
}