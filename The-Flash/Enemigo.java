/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Personaje
{
    /**
     * Constructor for objects of class Enemigo
     */
    public Enemigo()
    {
    }
    
    @Override
    public void colisiona() {
        if(isTouching(Rayo.class))
        {
            System.out.println("Colision con Rayo!!");
        }
    }
}
