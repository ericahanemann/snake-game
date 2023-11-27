import greenfoot.*;

public class Barriga extends Cobra
{
    private int lastX, lastY;
    private Cobra seguidor;
    
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private int currentDirection;
    
    
    GreenfootImage imageDown = new GreenfootImage("corpo.png");
    GreenfootImage imageRight = new GreenfootImage("corpo.png");
    GreenfootImage imageUp = new GreenfootImage("corpo-esquerda.png");
    GreenfootImage imageLeft = new GreenfootImage("corpo-esquerda.png");
    
    public Barriga(int x, int y, int currentDirection)
    {
        super();
        this.currentDirection = currentDirection;
        switch(this.currentDirection) {
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
        imageDown.scale(20, 20);
        imageRight.scale(20, 20);
        imageUp.scale(20, 20);
        imageLeft.scale(20, 20);
    }
    
    public void setSeguidor(Cobra seguidor)
    {
        this.seguidor = seguidor;
    }
    
    public void moverPara(int x, int y, int direction)
    {
        setLastPosition(getX(), getY());
        
        setLocation(x, y); 
        
        if(this.seguidor != null) 
        {
            this.seguidor.moverPara(this.lastX, this.lastY, currentDirection);
        }
        
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

    public void setLastPosition(int lastX, int lastY) {
        this.lastX = lastX;
        this.lastY = lastY;
    }
}

