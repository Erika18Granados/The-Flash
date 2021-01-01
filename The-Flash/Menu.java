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
public class Menu extends World
{   
    private Boton boton;
    //private ArrayList<Boton> botones;
    private ArrayList<String> nombresDeArchivosDeSprite;
    private Sprite spriteMenu;
    // Crear atributo para la generalizacion de input-jugador

    public Menu() {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        //this.botones = new ArrayList<Boton>();
        preparaMenu();
    }

    private void preparaMenu() {
        nombresDeArchivosDeSprite = new ArrayList<String>();
        for (int iterador = 1; iterador <= 15; ++iterador) {
            nombresDeArchivosDeSprite.add("images/menu/principal/flash/flash-" + iterador + ".png");
        }
        spriteMenu = new SpriteDeMundo(nombresDeArchivosDeSprite, 15, 5, this);
        
        nombresDeArchivosDeSprite.clear();
        nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[normal]jugar.png");
        nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[hover]jugar.png");
        
        boton = new BotonDeMenu(nombresDeArchivosDeSprite, 100, 50, this, 1);
        addObject(boton, boton.getX(), boton.getY());
    }

    public void act() {
        spriteMenu.animaSprite();
    }
}