import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoEjemploParaPersonaje extends Pantalla
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MundoEjemploParaPersonaje()
    {
        new Flash(this);
        new FlashReverso(this);
        new CargadorDePantallaDeMisiones();
    }
}
