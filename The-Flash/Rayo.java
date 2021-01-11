import java.util.*;
import greenfoot.*;

/**
 * Write a description of class Rayo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rayo extends Item
{
    public static final int IMPACTO = 100;

    private int xInicial, yInicial;

    /**
     * Constructor for objects of class Rayo
     */
    public Rayo(Pantalla pantalla, int xInicial, int yInicial)
    {
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        cargaItem(pantalla, this.xInicial, this.yInicial, new GreenfootImage("images/items/rayo.png"));
    }

    
    @Override
    public boolean colisiona() {
        if(isTouching(FlashReverso.class))
        // Baja vida a flash reverso
            return true;
        else
        if(isAtEdge())
            return true;
        else
            return false;
    }

    @Override
    public void efecto() {
        move(Velocidades.VELOCIDAD_RAYO);
    }

    @Override
    public void act() {
    }
}
