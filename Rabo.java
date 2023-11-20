import greenfoot.*;

public class Rabo extends Cobra
{
    private int lastX, lastY;
    
    public Rabo(int x, int y)
    {
        super();
        GreenfootImage image = new GreenfootImage("rabo.png");
        setImage(image);
        image.scale(20, 20);
    }
}