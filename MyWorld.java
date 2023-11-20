import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(1280, 720, 1); 
        
        Cabeca cabeca = new Cabeca(60, 20);
        addObject(cabeca, 60, 20);

        Barriga barriga = new Barriga(40, 20);
        addObject(barriga, 40, 20);
        
        Rabo rabo = new Rabo(20, 20);
        addObject(rabo, 20, 20);

        cabeca.setSeguidor(barriga);
        barriga.setSeguidor(rabo);
    }
}





