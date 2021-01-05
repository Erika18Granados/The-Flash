import java.util.*;
import greenfoot.World;
import greenfoot.Greenfoot;

/**
 * Write a description of class SpriteDeMundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpriteDeMundo extends Sprite
{
    private World mundo;

    public SpriteDeMundo(ArrayList<String> nombresDeArchivos, int frames, int delay, World mundo) {
        cargaSprite(nombresDeArchivos,frames, delay);
        this.mundo = mundo;
        fijaFrame(0);
    }

    @Override
    public void fijaFrame (int frame) {
        cambiaIterador(frame);
        mundo.setBackground(obtenFrame(obtenIterador()));
    }

    @Override
    public void animaSprite() {
        if(obtenIteradorDeListaDeSprite(obtenIterador()).hasNext()) {
            mundo.setBackground(obtenFrame(obtenIterador()));
            cambiaIterador(obtenIterador()+1);
        } else {
            cambiaIterador(0);
        }
        Greenfoot.delay(obtenDelay());
    }
}
