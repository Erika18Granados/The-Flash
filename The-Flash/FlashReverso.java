import java.util.ArrayList;

/**
 * Write a description of class FlashReverso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlashReverso extends Enemigo
{
    public static final int SPRITE_FLAS_REV_STAT = 0;
    public static final int SPRITE_FLAS_REV_CORRIENDO = 1;
    public static final int SPRITE_FLAS_REV_RAYO = 2;
    public static final int X_INI_RAYO = Mira.X_INI_MIRA*9;
    public static final int Y_INI_RAYO = Mira.Y_INI_MIRA;
    private static final int VIDA_FLASH_REVERSO = 10000;

    private boolean cargandoRayo;
    private Item rayo;
    private int xSuperheroe;
    private int ySuperheroe;
    private int vida;
    private Counter vidaFlashReverso;

    /**
     * Constructor for objects of class FlashReverso
     */
    public FlashReverso(Pantalla pantalla, Personaje superHeroe)
    {
        ArrayList<GifImage> spritesDePersonaje = new ArrayList<GifImage>();
        cargandoRayo = false;
        rayo = new Rayo(pantalla, X_INI_RAYO, Y_INI_RAYO);
        vidaFlashReverso = new Counter("VIDA FLASH REVERSO: ");
        pantalla.addObject(vidaFlashReverso, 600, 100);
        xSuperheroe = ySuperheroe = -1;

        vida = VIDA_FLASH_REVERSO;
        vidaFlashReverso.setValue(vida);

        spritesDePersonaje.add(new GifImage("images/personajes/flashreverso/static/flash-r-static.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flashreverso/flash-r-corriendo/flash-r-corriendo-der.gif"));
        spritesDePersonaje.add(new GifImage("images/personajes/flashreverso/flash-r-cargandorayo/flash-r-rayo.gif"));

        creaPersonaje(Velocidades.VELOCIDAD_FLASH_REVERSO, spritesDePersonaje, pantalla, POS_X_INI, POS_Y_INI, VIDA_FLASH_REVERSO);
        creaEnemigo(superHeroe);
        // Tamano original: 15 x 32
        ajustaSprite(15*ESCALAR_SPRITES, 32*ESCALAR_SPRITES, SPRITE_FLAS_REV_STAT);
        // Tamano original 23 x 29
        ajustaSprite(23*ESCALAR_SPRITES, 29*ESCALAR_SPRITES, SPRITE_FLAS_REV_CORRIENDO);
        // Tamano original 64 x 65
        ajustaSprite(64*ESCALAR_SPRITES, 65*ESCALAR_SPRITES, SPRITE_FLAS_REV_RAYO);
    }

    @Override
    public void ataque() {

        if(cronometro.millisElapsed() > 5000 && cronometro.millisElapsed() < 10000)
        {
            animaSprite(SPRITE_FLAS_REV_RAYO);
            cargandoRayo = true;
        } else
        if(cargandoRayo = true && cronometro.millisElapsed() > 10000)
        {
            cargandoRayo = false;
            rayo.setLocation(getX(), getY());
            xSuperheroe = superHeroe.getX();
            ySuperheroe = superHeroe.getY();
            rayo.turnTowards(xSuperheroe, ySuperheroe);
            cronometro.mark();
        }
        else
        if(rayo.getX() != xSuperheroe && rayo.getY() != ySuperheroe && xSuperheroe != -1 && ySuperheroe != -1)
        {
            rayo.turnTowards(xSuperheroe, ySuperheroe);
            rayo.efecto();
        }
        else
        {
            rayo.setLocation(X_INI_RAYO, Y_INI_RAYO);
            rayo.turnTowards(X_INI_RAYO, Y_INI_RAYO);
            xSuperheroe = ySuperheroe = -1;
        }
    }

    @Override
    public void act() {
        if(colisiona()) {
            vida-=Rayo.IMPACTO;
            vidaFlashReverso.setValue(vida);
        }
        if(!cargandoRayo)
            mueveEnemigo();
        ataque();
    }
}
