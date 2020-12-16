import java.util.ArrayList;
import greenfoot.World;

public class Menu extends World
{
    //private ArrayList<Boton> botones;
    private ArrayList<String> nombresDeArchivosDeSprite;
    private Sprite spriteMenu;

    public Menu() {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        //this.botones = new ArrayList<Boton>();
        this.nombresDeArchivosDeSprite = new ArrayList<String>();
        for (int iterador = 1; iterador <= 15; ++iterador) {
            this.nombresDeArchivosDeSprite.add("images/menu/principal/flash/flash-" + iterador + ".png");
        }

        this.spriteMenu = new SpriteDeMundo((ArrayList)this.nombresDeArchivosDeSprite, 15, 5, (World)this);
        this.preparaMenu();
    }

    private void preparaMenu() {
    }

    public void act() {
        this.spriteMenu.animaSprite();
    }
}