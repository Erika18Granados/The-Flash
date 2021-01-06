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
    public static final int IMPACTO = 10;
    public static final int VELOCIDAD_RAYO = 2;
    public static final int X = 50;
    public static final int Y = 50;
    
    private GreenfootImage mira;
    private GreenfootImage rayo;
    private InterfazDeJugador interfazDeJugador;
    private boolean click;
    public int xClick;
    public int yClick;
    /**
     * Constructor for objects of class Rayo
     */
    public Rayo(Pantalla pantalla, InterfazDeJugador interfazDeJugador)
    {
        mira = new GreenfootImage("images/items/mira.png");
        rayo = new GreenfootImage("images/items/rayo.png");
        click = false;
        xClick = -1;
        yClick = -1;
        this.interfazDeJugador = interfazDeJugador;
        cargaItem(pantalla, X, Y, mira);
    }
    
    @Override
    public void efecto() {
        if(interfazDeJugador.pideInfoDeMouse().getButton() != 1 && click == false)
        {
            setImage(mira);
            setLocation(interfazDeJugador.pideInfoDeMouse().getX(), interfazDeJugador.pideInfoDeMouse().getY());
        } else
            //if(distanciaPorCubrir == 0 && click != true)
            {
                setLocation(interfazDeJugador.obtenPersonaje().getX(), interfazDeJugador.obtenPersonaje().getY());
                xClick = interfazDeJugador.pideInfoDeMouse().getX();
                yClick = interfazDeJugador.pideInfoDeMouse().getY();
                turnTowards(xClick, yClick);
                
                setImage(rayo);
                click = true;
            }
    }
    
    @Override
    public void act() {
        if(xClick != -1 && yClick != -1)
        {
            if(getX() != xClick && getY() != yClick)
            {
                move(VELOCIDAD_RAYO);
            } else  {
                System.out.println("El rayo ya llego");
                click = false;
                xClick = -1;
                yClick = -1;
                setImage(mira);
                setLocation(X, Y);
            }
        }
    }
}
