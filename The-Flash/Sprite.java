import java.util.*;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Greenfoot;

/**
 * Write a description of class Sprite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Sprite implements CargadorDeSprite, AnimadorDeSprite
{
    private LinkedList<GreenfootImage> sprite;
    private int frames;
    private int delay;
    private int iterador;

    @Override
    public void cargaSprite(ArrayList<String> nombresDeArchivos, int frames, int delay, World mundo) {
        sprite = new LinkedList<>();
        nombresDeArchivos.forEach(nombre -> sprite.add(new GreenfootImage(nombre)));
        this.delay = delay;
        this.frames = frames;
        iterador = 0;
    }
    
    public void agregaFrame(GreenfootImage frame) {
        sprite.add(frame);
    }
    
    public GreenfootImage obtenFrame(int frame) {
        return sprite.get(frame);
    }
    
    public int obtenDelay() {
        return delay;
    }
    
    public void cambiaDelay(int nuevoDelay) {
        delay = nuevoDelay;
    }
    
    public void cambiaIterador(int nuevoIterador) {
        iterador = nuevoIterador;
    }
    
    public int obtenIterador() {
        return iterador;
    }
    
    public Iterator obtenIteradorDeListaDeSprite(int frame) {
        return sprite.listIterator(frame);
    }

}
