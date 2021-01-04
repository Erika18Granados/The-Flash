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
        this.cargadorDePantalla = cargadorDePantalla;
        muestraBoton(0);
    }

    public void cambiaPantalla() {
        Greenfoot.setWorld(cargadorDePantalla.obtenPantalla());
    }

    @Override
    public void act() {
        if(estaClickeado())
        {
            if(cargadorDePantalla != null)
            {
                //System.out.println("Boton de menu # " + numeroDeBoton + " presionado!");
                cambiaPantalla();
                if(cargadorDePantalla.obtenPantalla().obtenCinematica() != null)
                {
                    cargadorDePantalla.obtenPantalla().reproduceCinematica();
                }
            }
        }
    }
}
