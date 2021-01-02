import greenfoot.World;
import java.util.ArrayList;

/**
 * Write a description of class BotonDeMenu here.
 * 
 * @ERIKA Y ANGEL; 
 * @version (a version number or a date)
 */
public class BotonDeMenu extends Boton
{
    private int numeroDeBoton;
    private World pantalla;
    // Se le podria pasar la pantalla de records, nuevo nivel, etc...
    public BotonDeMenu(ArrayList<String> nombresDeArchivos, int x, int y, World mundo, int numeroDeBoton, World pantallaDeBoton) {
        cargaBoton(nombresDeArchivos, x, y, mundo);
        this.numeroDeBoton = numeroDeBoton;
        muestraBoton(0);
        pantalla = pantallaDeBoton;
    }
    
    public void cambiaPantalla() {
        //World.setWorld(pantalla);
    }
    
    @Override
    public void act() {
        if(estaClickeado())
        {
            System.out.println("Boton de menu #" + numeroDeBoton + "presionado!");
            cambiaPantalla();
        }
    }
}
