import java.util.ArrayList;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

/**
 * Clase para crear instancias de CargadorDePantalla y utilizarlas en los cargadores de menu
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CargadorDePantallaDeMenu extends CargadorDePantalla
{
    public ArrayList<String> nombresDeArchivosDeBoton;
    public ArrayList<Integer> coordenadasDeBotones;
    public int numeroDeBotones;

    // Una sola imagen de fondo
    public Pantalla cargaMenu(ArrayList<String> nombresDeArchivosDeBoton, ArrayList<Integer> coordenadasDeBotones, int numeroDeBotones, GreenfootImage imagen) {
        this.nombresDeArchivosDeBoton = new ArrayList<String>();
        this.coordenadasDeBotones = new ArrayList<Integer>();

        this.nombresDeArchivosDeBoton.addAll(nombresDeArchivosDeBoton);
        this.coordenadasDeBotones.addAll(coordenadasDeBotones);
        this.numeroDeBotones = numeroDeBotones;

        return cargaPantallaConImagen(imagen);
    }

    // Un sprite de fondo
    public Pantalla cargaMenu(ArrayList<String> nombresDeArchivosDeBoton, ArrayList<Integer> coordenadasDeBotones, int numeroDeBotones,
    ArrayList<String> nombresDeArchivosDeMenu, int delay) {
        this.nombresDeArchivosDeBoton = new ArrayList<String>();
        this.coordenadasDeBotones = new ArrayList<Integer>();

        this.nombresDeArchivosDeBoton.addAll(nombresDeArchivosDeBoton);
        this.coordenadasDeBotones.addAll(coordenadasDeBotones);
        this.numeroDeBotones = numeroDeBotones;

        return cargaPantallaConSprite(nombresDeArchivosDeMenu, delay);
    }

    // Menu sin fondo
    public Pantalla cargaMenu(ArrayList<String> nombresDeArchivosDeBoton, ArrayList<Integer> coordenadasDeBotones, int numeroDeBotones) {
        this.nombresDeArchivosDeBoton = new ArrayList<String>();
        this.coordenadasDeBotones = new ArrayList<Integer>();

        this.nombresDeArchivosDeBoton.addAll(nombresDeArchivosDeBoton);
        this.coordenadasDeBotones.addAll(coordenadasDeBotones);
        this.numeroDeBotones = numeroDeBotones;

        return cargaPantallaEnBlanco();
    }

    @Override
    public void preparaPantalla(ArrayList<CargadorDePantalla> cargadorDePantalla) {
        preparaMenu(cargadorDePantalla);
        // Si se cargo algun sonido al menu
        if(obtenPantalla().obtenSonido() != null) {
            obtenPantalla().obtenSonido().pause(); // HACER QUE SE PONGA PLAY SOLO CUANDO SE COMIENZA EL MUNDO (Cambiar a play para probar)
        }
    }

    public void preparaMenu(ArrayList<CargadorDePantalla> cargadoresDeBotones) {
        if(cargadoresDeBotones != null)
        {
            for(int boton = 0, archivoDeBoton = 0; boton < numeroDeBotones; boton++, archivoDeBoton+=2)
            {
                obtenPantalla().addObject(cargaBoton(new ArrayList(nombresDeArchivosDeBoton.subList(archivoDeBoton, archivoDeBoton+2)),
                        coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1),
                        obtenPantalla(), boton, cargadoresDeBotones.get(boton)),
                    coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1));
            }
        }
        else
            for(int boton = 0, archivoDeBoton = 0; boton < numeroDeBotones; boton++, archivoDeBoton+=2)
            {
                obtenPantalla().addObject(cargaBoton(new ArrayList(nombresDeArchivosDeBoton.subList(archivoDeBoton, archivoDeBoton+2)),
                        coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1),
                        obtenPantalla(), boton, null),
                    coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1));
            }
    }

    public Boton cargaBoton(ArrayList<String> archivosDeBoton, int xBoton, int yBoton, Pantalla pantallaDeMenu, int idBoton, CargadorDePantalla cargadorDePantallaDeBoton) {
        BotonDeMenu botonDeMenu = new BotonDeMenu(archivosDeBoton, xBoton, yBoton, pantallaDeMenu, idBoton, cargadorDePantallaDeBoton);
        return botonDeMenu;
    }
}
