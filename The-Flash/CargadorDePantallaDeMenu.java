import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import greenfoot.World;
import greenfoot.GreenfootImage;

/**
 * Write a description of class CargadorDePantallaDeMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargadorDePantallaDeMenu extends CargadorDePantalla  
{
    private ArrayList<String> nombresDeArchivosDeBoton;
    private ArrayList<Integer> coordenadasDeBotones;
    private ArrayList<CargadorDePantalla> cargadoresDePantallaDeBotones;

    // Un sprite de fondo
    public CargadorDePantallaDeMenu(ArrayList<String> nombresDeArchivosDeBoton, ArrayList<Integer> coordenadasDeBotones,
                                        ArrayList<String> nombresDeArchivosDeMenu, int delay, ArrayList<CargadorDePantalla> cargadoresDePantallaDeBotones) {
        if(nombresDeArchivosDeBoton.size() % 2 == 0)
        {
            this.nombresDeArchivosDeBoton = new ArrayList<String>();
            this.coordenadasDeBotones = new ArrayList<Integer>();
            this.cargadoresDePantallaDeBotones = new ArrayList<CargadorDePantalla>();
            
            this.cargadoresDePantallaDeBotones.addAll(cargadoresDePantallaDeBotones);
            this.nombresDeArchivosDeBoton.addAll(nombresDeArchivosDeBoton);
            this.coordenadasDeBotones.addAll(coordenadasDeBotones);
            cargaArchivosDePantalla(nombresDeArchivosDeMenu);
            estableceDelay(delay);
        } else {
            System.out.println("Error con nombresDeArchivosDeBoton: numero de archivos incorrecto!");
        }
    }
    
    // Una sola imagen de fondo
    public CargadorDePantallaDeMenu(ArrayList<String> nombresDeArchivosDeBoton, ArrayList<Integer> coordenadasDeBotones, String imagen) {
        if(nombresDeArchivosDeBoton.size() % 2 == 0)
        {
            this.nombresDeArchivosDeBoton = new ArrayList<String>();
            this.coordenadasDeBotones = new ArrayList<Integer>();

            this.nombresDeArchivosDeBoton.addAll(nombresDeArchivosDeBoton);
            this.coordenadasDeBotones.addAll(coordenadasDeBotones);
            cargaArchivosDePantalla(new ArrayList<String>(Arrays.asList(imagen)));
        } else {
            System.out.println("Error con nombresDeArchivosDeBoton: numero de archivos incorrecto!");
        }
    }

    // Menu sin fondo
    public CargadorDePantallaDeMenu(ArrayList<String> nombresDeArchivosDeBoton, ArrayList<Integer> coordenadasDeBotones) {
        if(nombresDeArchivosDeBoton.size() % 2 == 0)
        {
            this.nombresDeArchivosDeBoton = new ArrayList<String>();
            this.coordenadasDeBotones = new ArrayList<Integer>();

            this.nombresDeArchivosDeBoton.addAll(nombresDeArchivosDeBoton);
            this.coordenadasDeBotones.addAll(coordenadasDeBotones);
        } else {
            System.out.println("Error con nombresDeArchivosDeBoton: numero de archivos incorrecto!");
        }
    }

    @Override
    public Pantalla cargaPantalla() {
        Pantalla pantallaDeMenu;
        if(obtenNombresDeArchivosDePantalla() != null)
        {
            pantallaDeMenu = cargaPantallaConSprite(obtenDelay(), obtenNombresDeArchivosDePantalla());
        }
        else
        {
            pantallaDeMenu = new Pantalla();
        }

        preparaMenu(pantallaDeMenu);
        return pantallaDeMenu;
    }

    private void preparaMenu(Pantalla pantallaDeMenu) {
        ArrayList<Boton> botonesDeMenu = new ArrayList<Boton>(nombresDeArchivosDeBoton.size()/2);
        
        if(cargadoresDePantallaDeBotones != null)
            for(int boton = 0, archivoDeBoton = 0; boton < (nombresDeArchivosDeBoton.size()/2); boton++, archivoDeBoton+=2)
            {
                pantallaDeMenu.addObject(cargaBotonConPantalla(new ArrayList(nombresDeArchivosDeBoton.subList(archivoDeBoton, archivoDeBoton+2)),
                                            coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1),
                                            pantallaDeMenu, boton, cargadoresDePantallaDeBotones.get(boton)),
                                            coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1));
            }
        else
            for(int boton = 0, archivoDeBoton = 0; boton < (nombresDeArchivosDeBoton.size()/2); boton++, archivoDeBoton+=2)
            {
                pantallaDeMenu.addObject(cargaBoton(new ArrayList(nombresDeArchivosDeBoton.subList(archivoDeBoton, archivoDeBoton+2)),
                                                coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1),
                                                pantallaDeMenu, boton),
                                                coordenadasDeBotones.get(archivoDeBoton), coordenadasDeBotones.get(archivoDeBoton+1));
            }
        
    }

    private Boton cargaBotonConPantalla(ArrayList<String> archivosDeBoton, int xBoton, int yBoton,
    Pantalla pantallaDeMenu, int idBoton, CargadorDePantalla cargadorDePantallaDeBoton) {
        return new BotonDeMenu(archivosDeBoton, xBoton, yBoton, pantallaDeMenu, idBoton, cargadorDePantallaDeBoton);
    }
    
    private Boton cargaBoton(ArrayList<String> archivosDeBoton, int xBoton, int yBoton,
    Pantalla pantallaDeMenu, int idBoton) {
        return new BotonDeMenu(archivosDeBoton, xBoton, yBoton, pantallaDeMenu, idBoton);
    }
}
