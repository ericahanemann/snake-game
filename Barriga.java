import greenfoot.*;

public class Barriga extends Cobra
{
    private int lastX, lastY;
    private Cobra seguidor;
    
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private int currentDirection = 0;
    
    
    GreenfootImage image = new GreenfootImage("corpo.png");
    
    public Barriga(int x, int y)
    {
        super();
        setImage(image);
        image.scale(20, 20);
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
                setImage("corpo.png");
                image.scale(20, 20);
                setRotation(90);
                break;
            case RIGHT:
                setImage("corpo.png");
                image.scale(20, 20);
                setRotation(0);
                break;
            case UP:
                setImage("corpo-esquerda.png");
                image.scale(20, 20);
                setRotation(90);
                break;
            case LEFT:
                setImage("corpo-esquerda.png");
                image.scale(20, 20);
                setRotation(0);
                break;
        }
    }

    public void setLastPosition(int lastX, int lastY) {
        this.lastX = lastX;
        this.lastY = lastY;
    }
}

