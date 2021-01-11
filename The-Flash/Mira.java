import greenfoot.GreenfootImage;

/**
 * Write a description of class Mira here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mira extends Item
{
    public static final int X_INI_MIRA = 50;
    public static final int Y_INI_MIRA = 40;
    public static final int X_INI_RAYO = X_INI_MIRA*3;
    public static final int Y_INI_RAYO = Y_INI_MIRA;
    
    public Item rayo;
    
    private InterfazDeJugador interfazDeJugador;
    
    private boolean click;
    private int xClick;
    private int yClick;
    
    
    /**
     * Constructor for objects of class Mira
     */
    public Mira(Pantalla pantalla, InterfazDeJugador interfazDeJugador)
    {
        this.interfazDeJugador = interfazDeJugador;
        
        click = false;
        
        cargaItem(pantalla, X_INI_MIRA, Y_INI_MIRA, new GreenfootImage("images/items/mira.png"));
        rayo = new Rayo(pantalla, X_INI_MIRA*3, Y_INI_MIRA);
    }
    
    @Override
    public boolean colisiona() {
        return false;
    }
    
    @Override
    public void efecto() {
        if(interfazDeJugador.pideInfoDeMouse().getButton() != 1 && !click)
        {
            setLocation(interfazDeJugador.pideInfoDeMouse().getX(), interfazDeJugador.pideInfoDeMouse().getY());
        } else
        if(!click)
        {
            click = true;
            // Reestablece la posicion de la Mira
            setLocation(X_INI_MIRA, Y_INI_MIRA);
            
            // Establece la posicion del rayo
            rayo.setLocation(interfazDeJugador.obtenPersonaje().getX(), interfazDeJugador.obtenPersonaje().getY());
            xClick = interfazDeJugador.pideInfoDeMouse().getX();
            yClick = interfazDeJugador.pideInfoDeMouse().getY();
        }
            /*else
            //if(distanciaPorCubrir == 0 && click != true)
            {
                setLocation(interfazDeJugador.obtenPersonaje().getX(), interfazDeJugador.obtenPersonaje().getY());
                xClick = interfazDeJugador.pideInfoDeMouse().getX();
                yClick = interfazDeJugador.pideInfoDeMouse().getY();
                turnTowards(xClick, yClick);
                
                setImage(rayo);
                click = true;
            }*/
    }
    
    @Override
    public void act() {
        if(click && !rayo.colisiona() && rayo.getX() != xClick && rayo.getY() != yClick)
        {
            rayo.turnTowards(xClick, yClick);
            rayo.efecto();
        }
        else
        {
            click = false;
            rayo.setLocation(X_INI_RAYO, Y_INI_RAYO);
            rayo.turnTowards(X_INI_RAYO, Y_INI_RAYO);
        }
        
        
        /*
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
        }*/
    }
}
