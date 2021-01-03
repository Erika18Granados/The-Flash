import java.util.ArrayList;
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
        cargaSprite(nombresDeArchivos, frames, delay);
        this.actor = actor;
        fijaFrame(0);
    }

    @Override
    public void fijaFrame (int frame) {
        cambiaIterador(frame);
        actor.setImage(obtenFrame(obtenIterador()));
    }

    public void animaSprite() {
        if(obtenIteradorDeListaDeSprite(obtenIterador()).hasNext()) {
            actor.setImage(obtenFrame(obtenIterador()));
            cambiaIterador(obtenIterador()+1);
        } else {
            cambiaIterador(0);
        }
        Greenfoot.delay(obtenDelay());
    }
}
