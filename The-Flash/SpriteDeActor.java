import java.util.*;
import greenfoot.Actor;
import greenfoot.Greenfoot;

/**
 * Clase para cargar y manipular sprite de Actor
 * NOTA: EL ACTOR YA DEBE ESTAR AGREGADO AL MUNDO
 * 
 * @Angel Maldonado
 * @12/16/20
 */
public class SpriteDeActor extends Sprite
{
    private Actor actor;
    public SpriteDeActor(ArrayList<String> nombresDeArchivos, int frames, int delay, Actor actor) {
        this.cargaSprite(nombresDeArchivos, frames, delay);
        this.actor = actor;
        fijaFrame(0);
    }

    @Override
    public void fijaFrame (int frame) {
        this.cambiaIterador(frame);
        actor.setImage(this.obtenFrame(this.obtenIterador()));
    }

    public void animaSprite() {
        if(this.obtenIteradorDeListaDeSprite(this.obtenIterador()).hasNext()) {
            actor.setImage(this.obtenFrame(this.obtenIterador()));
            this.cambiaIterador(this.obtenIterador()+1);
        } else {
            this.cambiaIterador(0);
        }
        Greenfoot.delay(this.obtenDelay());
    }
}
