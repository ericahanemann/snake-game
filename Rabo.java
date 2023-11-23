import greenfoot.*;

public class Rabo extends Cobra
{
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private int currentDirection = 0;
    
    
    GreenfootImage imageDown = new GreenfootImage("rabo.png");
    GreenfootImage imageRight = new GreenfootImage("rabo.png");
    GreenfootImage imageUp = new GreenfootImage("rabo-esquerda.png");
    GreenfootImage imageLeft = new GreenfootImage("rabo-esquerda.png");
    
    public Rabo(int x, int y)
    {
        super();
        setImage(imageRight);
        imageDown.scale(20, 20);
        imageRight.scale(20, 20);
        imageUp.scale(20, 20);
        imageLeft.scale(20, 20);
    }
    
    public void moverPara(int x, int y, int direction)
    {
       setLocation(x, y); 
        
       this.currentDirection = direction;
       switch(currentDirection) {
            case DOWN:
                setImage(imageDown);
                setRotation(90);
                break;
            case RIGHT:
                setImage(imageRight);
                setRotation(0);
                break;
            case UP:
                setImage(imageUp);
                setRotation(90);
                break;
            case LEFT:
                setImage(imageLeft);
                setRotation(0);
                break;
        }
    }
}