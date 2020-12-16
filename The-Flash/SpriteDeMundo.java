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
        this.cargaSprite(nombresDeArchivos,frames, delay, mundo);
        this.mundo = mundo;
        fijaFrame(0);
    }

    @Override
    public void fijaFrame (int frame) {
        this.cambiaIterador(frame);
        mundo.setBackground(this.obtenFrame(this.obtenIterador()));
    }

    public void animaSprite() {
        if(this.obtenIteradorDeListaDeSprite(this.obtenIterador()).hasNext()) {
            mundo.setBackground(this.obtenFrame(this.obtenIterador()));
            this.cambiaIterador(this.obtenIterador()+1);
        } else {
            this.cambiaIterador(0);
        }
        Greenfoot.delay(this.obtenDelay());
    }
}
