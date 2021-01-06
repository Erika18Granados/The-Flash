import java.util.ArrayList;
import greenfoot.World;

/**
 * Carga un sprite en base a archivos de imagen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface CargadorDeSprite  
{
    void cargaSprite(ArrayList<String> nombresDeArchivos, int frames, int delay);
    void cargaSprite(ArrayList<String> nombresDeArchivos, int delay);
}
