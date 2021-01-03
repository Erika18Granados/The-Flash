import java.util.ArrayList;
import greenfoot.World;
import greenfoot.Greenfoot;

/**
 * Write a description of class BotonDeMenu here.
 * 
 * @ERIKA Y ANGEL; 
 * @version (a version number or a date)
 */
public class BotonDeMenu extends Boton
{
    private int numeroDeBoton;
    private CargadorDePantalla cargadorDePantalla;
    // Se le podria pasar la pantalla de records, nuevo nivel, etc...
    public BotonDeMenu(ArrayList<String> nombresDeArchivos, int x, int y, Pantalla pantalla, int numeroDeBoton, CargadorDePantalla cargadorDePantalla) {
        cargaBoton(nombresDeArchivos, x, y, pantalla);
        this.numeroDeBoton = numeroDeBoton;
        muestraBoton(0);
        this.cargadorDePantalla = cargadorDePantalla;
        //pantalla = nuevaPantalla;
        //Greenfoot.setWorld(pantalla);
    }
    
    public BotonDeMenu(ArrayList<String> nombresDeArchivos, int x, int y, Pantalla pantalla, int numeroDeBoton) {
        cargaBoton(nombresDeArchivos, x, y, pantalla);
        this.numeroDeBoton = numeroDeBoton;
        muestraBoton(0);
    }
    
    public void cambiaPantalla() {
        Greenfoot.setWorld(cargadorDePantalla.cargaPantalla());
    }
    
    @Override
    public void act() {
        if(estaClickeado())
        {
            //System.out.println("Boton de menu # " + numeroDeBoton + " presionado!");
            cambiaPantalla();
        }
    }
}
