import java.util.ArrayList;
import greenfoot.World;
import greenfoot.Actor; // PRUEBA

public class Menu extends World
{
    //private ArrayList<Boton> botones;
    private ArrayList<String> nombresDeArchivosDeSprite;
    private Sprite spriteMenu;
    // Estos 2 atributos es de prueba solo para la generalizacion de SpriteDeActor BORRAR
    private Boton boton = new Boton(); // PRUEBA -> CAMBIAR POR IMPLEMENTACION DE BOTON
    private Sprite spriteBoton; // PRUEBA -> CAMBIAR POR IMPLEMENTACION DE BOTON

    public Menu() {
        super(ResolucionDePantalla.ANCHO_PX, ResolucionDePantalla.ALTO_PX, 1);
        //this.botones = new ArrayList<Boton>();
        nombresDeArchivosDeSprite = new ArrayList<String>();
        for (int iterador = 1; iterador <= 15; ++iterador) {
            nombresDeArchivosDeSprite.add("images/menu/principal/flash/flash-" + iterador + ".png");
        }
        
        spriteMenu = new SpriteDeMundo(nombresDeArchivosDeSprite, 15, 5, this);
        
        this.addObject(boton, 100, 50); // PRUEBA -> CAMBIAR POR IMPLEMENTACION DE BOTON
        pruebaSpriteActor(nombresDeArchivosDeSprite); // PRUEBA -> CAMBIAR POR IMPLEMENTACION DE BOTON
        
        preparaMenu();
    }

    private void preparaMenu() {
    }

    public void act() {
        spriteMenu.animaSprite();
        spriteBoton.animaSprite(); // PRUEBA -> CAMBIAR POR IMPLEMENTACION DE BOTON
    }
    
    /**
     * Este codigo es de prueba, debera cambiarse por la implementacion de los botones
     */
    public void pruebaSpriteActor(ArrayList<String> nombresDeArchivosDeSprite) {
        nombresDeArchivosDeSprite.clear();
        nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[hover]jugar.png");
        nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[normal]jugar.png");
        spriteBoton = new SpriteDeActor(nombresDeArchivosDeSprite, 15, 3, boton);
    }
}