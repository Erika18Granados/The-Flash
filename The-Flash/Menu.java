import java.util.ArrayList;
import greenfoot.World;
import greenfoot.MouseInfo;
import greenfoot.Actor; // PRUEBA

public class Menu extends World
{   //0E9B0598DXDc3r5A
    private Boton boton;
    //private ArrayList<Boton> botones;
    private ArrayList<String> nombresDeArchivosDeSprite;
    private Sprite spriteMenu;

    public Menu() {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        //this.botones = new ArrayList<Boton>();
        nombresDeArchivosDeSprite = new ArrayList<String>();
        for (int iterador = 1; iterador <= 15; ++iterador) {
            nombresDeArchivosDeSprite.add("images/menu/principal/flash/flash-" + iterador + ".png");
        }
        spriteMenu = new SpriteDeMundo(nombresDeArchivosDeSprite, 15, 5, this);
        
        nombresDeArchivosDeSprite.clear();
        nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[hover]jugar.png");
        nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[normal]jugar.png");
        
        boton = new BotonDeMenu(nombresDeArchivosDeSprite, 100, 50, this, 1);
    }

    private void preparaMenu() {
    }

    public void act() {
        spriteMenu.animaSprite();
        //boton.estaPresionado(new MouseInfo());
    }
}