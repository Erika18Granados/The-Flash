import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoEjemploParaPersonaje extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MundoEjemploParaPersonaje()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Personaje(), 100, 100);
    }
}