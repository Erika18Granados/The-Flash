import java.util.ArrayList;
import greenfoot.World;

/**
 * Write a description of class CargadorDePantallaDeMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDePantallaDeMenu extends CargadorDePantalla  
{
    private ArrayList<Boton> botones;
    private ArrayList<String> nombresDeArchivosDeSprite;
    private Sprite spriteMenu;
    public CargadorDePantallaDeMenu(ArrayList<Boton> botones) {
        nombresDeArchivosDeSprite = new ArrayList<String>();
        this.botones = botones;
    }

    @Override
    public Pantalla cargaPantallaDeMenu(ArrayList<Boton> botones,Sprite spriteMenu) {
        Pantalla pantallaDeMenu =cargaPantalla();
        preparaMenu(pantallaDeMenu,botones,spriteMenu);
        return (pantallaDeMenu);
    }

    private void preparaMenu(Pantalla pantallaDeMenu,ArrayList<Boton> botonesDeMenu,Sprite spriteMenu) {
        for (int iterador = 1; iterador <= 15; ++iterador) {
            nombresDeArchivosDeSprite.add("images/menu/principal/flash/flash-" + iterador + ".png");
        }
        spriteMenu = new SpriteDeMundo(nombresDeArchivosDeSprite, 15, 5, pantallaDeMenu);
        spriteMenu = this.spriteMenu;

        nombresDeArchivosDeSprite.clear();
        for(int iterador = 1; iterador <= 4; ++iterador) {

            switch(iterador)
            {
                case 1://jugar
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[normal]jugar.png");
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/jugar/[hover]jugar.png");
                break;

                case 2://instrucciones
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/instrucciones/[normal]instrucciones.png");
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/instrucciones/[hover]instrucciones.png");
                break;

                case 3://records
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/records/[normal]records.png");
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/records/[hover]records.png");
                break;

                case 4://salir
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/salir/[normal]salir.png");
                nombresDeArchivosDeSprite.add("images/menu/principal/botones/salir/[hover]salir.png");
                break;
            }
            botones.add(new BotonDeMenu(nombresDeArchivosDeSprite, 100, 80*(iterador) , pantallaDeMenu, iterador, pantallaDeMenu));
            nombresDeArchivosDeSprite.clear();
            pantallaDeMenu.addObject(botones.get(iterador-1), botones.get(iterador-1).getX(), botones.get(iterador-1).getY());

        }
        botonesDeMenu = botones;
    }
}
