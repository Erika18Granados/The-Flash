import java.util.ArrayList;
import greenfoot.GreenfootImage;
/**
 * Write a description of class CargadorDePantalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CargadorDePantalla
{   
    private ArrayList<String> nombresDeArchivosDePantalla;
    private int delay;
    
    public abstract Pantalla cargaPantalla();
    
    // Carga una nueva pantalla con sprites
    public Pantalla cargaPantallaConSprite(int delay, ArrayList<String> nombresDeArchivosDePantalla) {
        Pantalla pantallaConSprite;
        if(nombresDeArchivosDePantalla != null) {
            if(nombresDeArchivosDePantalla.size() > 1)
            {
                this.delay = delay;
                pantallaConSprite = new Pantalla(nombresDeArchivosDePantalla, nombresDeArchivosDePantalla.size(), delay);
            }
            else
                pantallaConSprite = new Pantalla(new GreenfootImage(nombresDeArchivosDePantalla.get(0)));
        } else
            pantallaConSprite = new Pantalla();
        return pantallaConSprite;
    }
    
    public void cargaArchivosDePantalla(ArrayList<String> nombresDeArchivosDePantalla) {
        this.nombresDeArchivosDePantalla = nombresDeArchivosDePantalla;
    }
    
    public void estableceDelay(int delay) {
        this.delay = delay;
    }
    
    public int obtenDelay() {
        return delay;
    }
    
    public ArrayList obtenNombresDeArchivosDePantalla() {
        return nombresDeArchivosDePantalla;
    }
}

