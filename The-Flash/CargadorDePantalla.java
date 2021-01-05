import java.util.ArrayList;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;
/**
 * Esta clase abstracta funciona de intermediaria entre cualquier clase que cree un nuevo mundo, de manera que se van a hacer varios
 * CargadoresDePantalla para cada clase que herede de World y en estos cargadores se añadiran los actores y archivos de fondo
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CargadorDePantalla
{   
    private Pantalla pantalla;
    
    // preparaPantalla anade todos los objetos a la pantalla, estos objetos pueden tener enlaces/CargadoresDePantalla a otras Pantalla(s)
    public abstract void preparaPantalla(ArrayList<CargadorDePantalla> cargadorDePantalla);
    
    public void agregaSonido(GreenfootSound sonido) {
        pantalla.estableceSonido(sonido);
    }
    
    // Carga una nueva pantalla con una cinematica
    public Pantalla cargaPantallaConCinematica(GifImage cinematica, GreenfootSound sonido) {
        return pantalla = new Pantalla(cinematica, sonido);
    }
    
    // Carga una nueva pantalla con una sola imagen de fondo
    public Pantalla cargaPantallaConImagen(GreenfootImage imagen) {
        return pantalla = new Pantalla(imagen);
    }

    // Carga una nueva pantalla con sprites
    public Pantalla cargaPantallaConSprite(ArrayList<String> nombresDeArchivosDePantalla, int delay) {
        return pantalla = new Pantalla(nombresDeArchivosDePantalla, nombresDeArchivosDePantalla.size(), delay);
    }

    // Carga una nueva pantalla en blanco
    public Pantalla cargaPantallaEnBlanco() {
        return pantalla = new Pantalla();
    }

    // Obten la pantalla del cargador
    public Pantalla obtenPantalla() {
        return pantalla;
    }
}

