import java.util.ArrayList;

/**
 * Write a description of class MenuSTARLABS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuSTARLABS extends Menu
{
    /**
     * Constructor for objects of class MenuSTARLABS
     */
    public MenuSTARLABS()
    {
        ArrayList<CargadorDePantalla> cargadoresDePantallaDeBotones = new ArrayList<CargadorDePantalla>();
        cargadoresDePantallaDeBotones.add(new CargadorDePantallaDeMision());
        cargadoresDePantallaDeBotones.add(new CargadorDePantallaDeRecursos());
        cargadoresDePantallaDeBotones.add(new CargadorDePantallaDeEstadisticas());

        cargaMenu(new CargadorDeMenuSTARLABS(), cargadoresDePantallaDeBotones);
    }
}
