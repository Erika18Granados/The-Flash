import greenfoot.MouseInfo;
import greenfoot.Actor;

/**
 * Esta interfaz funciona como intermediario entre los Personaje(s) del juego,
 * para que tanto Enemigo(s), como Personaje(s) principales o secundarios utilicen
 * La informacion del jugador para modificarla o simplemente utilizar los valores
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface InterfazDeJugador  
{
    String pideTexto();
    boolean pideTecla(String tecla);
    MouseInfo pideInfoDeMouse();
    Personaje obtenPersonaje();
    boolean preguntaSiMeClickearon(Actor actor);
    void muevePersonaje();
}
