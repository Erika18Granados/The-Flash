import java.util.ArrayList;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Personaje extends Actor
{
    // VELOCIDAD CONSTANTE EN CASO DE NO TENER VELOCIDAD INICIAL
    private static final int VELOCIDAD = 5;
    
    private InterfazDeJugador interfazDeJugador;
    private DireccionDePersonaje direccion;
    private int velocidadDeMovimiento;
    private int movimientoEnX;
    private int movimientoEnY;
    private ArrayList<GifImage> spritesDePersonaje;
    private GreenfootImage imagenDePersonaje;
    
    private Pantalla pantalla;
    /*
    // Cronometro
    private Counter contador;
    
    public void agregaContador(Counter contador) {
        
    }*/

    /**
     * Constructor for objects of class Personaje
     */
    public void creaPersonaje(Pantalla pantalla, int x, int y)
    {
        movimientoEnX = 0;
        movimientoEnY = 0;
        velocidadDeMovimiento = VELOCIDAD;
        pantalla.addObject(this, x, y);
        pantalla = pantalla;
    }
    
    // Personaje sin interfaz de jugador
    public void creaPersonaje(int velocidad, GreenfootImage imagenDePersonaje, Pantalla pantalla,int x, int y)
    {
        movimientoEnX = 0;
        movimientoEnY = 0;
        velocidadDeMovimiento = velocidad;
        this.imagenDePersonaje = imagenDePersonaje;
        pantalla.addObject(this, x, y);
        pantalla = pantalla;
    }
    
    // Personaje con imagen
    public void creaPersonaje(int velocidad, InterfazDeJugador interfazDeJugador, GreenfootImage imagenDePersonaje, Pantalla pantalla ,int x, int y)
    {
        movimientoEnX = 0;
        movimientoEnY = 0;
        velocidadDeMovimiento = velocidad;
        this.interfazDeJugador = interfazDeJugador; // Este atributo solo se usara en algunas subclases de Personaje
        this.imagenDePersonaje = imagenDePersonaje;
        pantalla.addObject(this, x, y);
        pantalla = pantalla;
    }

    // Personaje con animacion
    public void creaPersonaje(int velocidad, InterfazDeJugador interfazDeJugador, ArrayList<GifImage> spritesDePersonaje, Pantalla pantalla, int x, int y)
    {
        movimientoEnX = 0;
        movimientoEnY = 0;
        velocidadDeMovimiento = velocidad;
        this.interfazDeJugador = interfazDeJugador; // Este atributo solo se usara en algunas subclases de Personaje
        this.spritesDePersonaje = spritesDePersonaje;
        estableceSprite(0);
        this.spritesDePersonaje.forEach(sprite -> sprite.pause());
        pantalla.addObject(this, x, y);
        pantalla = pantalla;
    }

    public void muevePersonaje(DireccionDePersonaje direccionDeMovimiento) {
        if(getY() >= ResolucionDePantalla.LIM_AREA_JUEGO)
        {
            switch(direccionDeMovimiento)
            {
                // DIRECCIONES BASICAS
                case ARRIBA:
                movimientoEnY = -velocidadDeMovimiento;
                turnTowards(getX(), 0);
                direccion = DireccionDePersonaje.ARRIBA;
                break;
                case ABAJO:
                movimientoEnY = velocidadDeMovimiento;
                turnTowards(getX(), getWorld().getHeight());
                direccion = DireccionDePersonaje.ABAJO;
                break;
                case IZQUIERDA:
                movimientoEnX = -velocidadDeMovimiento;
                turnTowards(0, getY());
                direccion = DireccionDePersonaje.IZQUIERDA;
                break;
                case DERECHA:
                movimientoEnX = velocidadDeMovimiento;
                turnTowards(getWorld().getWidth(), getY());
                direccion = DireccionDePersonaje.DERECHA;
                break;
    
                // DIAGONALES
                case DIAG_SUP_IZQ:
                movimientoEnX = -velocidadDeMovimiento;
                movimientoEnY = -velocidadDeMovimiento;
                turnTowards(0, getY());
                direccion = DireccionDePersonaje.DIAG_SUP_IZQ;
                break;
                case DIAG_SUP_DER:
                movimientoEnX = velocidadDeMovimiento;
                movimientoEnY = -velocidadDeMovimiento;
                turnTowards(getWorld().getWidth(), getY());
                direccion = DireccionDePersonaje.DIAG_SUP_DER;
                break;
                case DIAG_INF_IZQ:
                movimientoEnX = -velocidadDeMovimiento;
                movimientoEnY = velocidadDeMovimiento;
                turnTowards(getX(), getWorld().getHeight());
                direccion = DireccionDePersonaje.DIAG_INF_IZQ;
                break;
                case DIAG_INF_DER:
                movimientoEnX = velocidadDeMovimiento;
                movimientoEnY = velocidadDeMovimiento;
                turnTowards(getWorld().getWidth(), getY());
                direccion = DireccionDePersonaje.DIAG_INF_DER;
                break;
    
                default:
                movimientoEnX = 0;
                movimientoEnY = 0;
                direccion = DireccionDePersonaje.ESTATICO;
                break;
            }
            setLocation(getX() + movimientoEnX, getY() + movimientoEnY);
        } else setLocation(getX(), getY()+1);
        //spritesDePersonaje.get(0).animaSprite(); <<<---- PARA LOS DEMAS PERSONAJES LLAMAR ESTA FUNCION DENTRO DEL SWITCH O EN OTRO LUGAR
    }
    
    abstract void colisiona();

    public InterfazDeJugador obtenInterfazDeJugador() {
        return interfazDeJugador;
    }
    
    public void estableceSprite(int numeroDeSprite) {
        setImage(obtenSprite(numeroDeSprite).getCurrentImage());
    }
    
    public void cambiaVelocidad(int nuevaVelocidad) {
        velocidadDeMovimiento = nuevaVelocidad;
    }
    
    public int obtenVelocidad() {
        return velocidadDeMovimiento;
    }
    
    public Pantalla obtenPantalla() {
        return pantalla;
    }
    
    public GifImage obtenSprite(int numeroDeSprite) {
        return spritesDePersonaje.get(numeroDeSprite);
    }
    
    public void animaSprite(int numeroDeSprite) {
        estableceSprite(numeroDeSprite);
        obtenSprite(numeroDeSprite).resume();
    }
    /*
    @Override
    public void act() {
    // PRUEBA DE INTERFAZ DE JUGADOR
    if(interfazDeJugador.preguntaSiMeClickearon(this))
    {
    interfazDeJugador.pideTexto();
    }
    }*/
}
