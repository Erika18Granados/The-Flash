import greenfoot.World;
import java.util.ArrayList;

/**
 * Write a description of class BotonDeMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotonDeMenu extends Boton
{
    private int numeroDeBoton;
    // Se le podria pasar la pantalla de records, nuevo nivel, etc...
    public BotonDeMenu(ArrayList<String> nombresDeArchivos, int x, int y, World mundo, int numeroDeBoton) {
        cargaBoton(nombresDeArchivos, x, y, mundo);
        
        this.numeroDeBoton = numeroDeBoton;
    }
    
    @Override
    public void act() {
        muestraBoton(1);
        //estaPresionado();
    }
}
