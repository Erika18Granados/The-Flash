/**
 * Write a description of class CargadorDePantallaDeInstrucciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDePantallaDeInstrucciones extends CargadorDePantalla
{
    /**
     * Constructor for objects of class CargadorDePantallaDeInstrucciones
     */
    public CargadorDePantallaDeInstrucciones()
    {
    }
    
    @Override
    public Pantalla cargaPantalla() {
        return new Pantalla();
    }
}
