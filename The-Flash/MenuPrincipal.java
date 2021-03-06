import java.util.ArrayList;

/**
 * Write a description of class MenuPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPrincipal extends Menu
{
    CargadorDePantalla cargadorDeMenuPrincipal;
    /**
     * Constructor for objects of class MenuPrincipal
     */
    public MenuPrincipal()
    {
        ArrayList<CargadorDePantalla> cargadoresDePantallaDeBotones = new ArrayList<CargadorDePantalla>();
        cargadoresDePantallaDeBotones.add(new CinematicaDeInicio());
        cargadoresDePantallaDeBotones.add(new CargadorDePantallaDeInstrucciones());
        cargadoresDePantallaDeBotones.add(new CargadorDePantallaDeRecords());
        cargadoresDePantallaDeBotones.add(new CargadorDePantallaDeSalir());
        
        cargaMenu(new CargadorDeMenuPrincipal(), cargadoresDePantallaDeBotones);
    }
}
