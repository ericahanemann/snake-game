import greenfoot.*;

abstract class Cobra extends Actor
{
    protected Cobra seguidor;
    protected int x;
    protected int y;
    private int lastX, lastY;
    private static final int RIGTH = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private int currentDirection = 0;
    
    public void setSeguidor(Cobra seguidor)
    {
        this.seguidor = seguidor;
    }

    public void moverPara(int x, int y, int direction)
    {
        setLastPosition(getX(), getY());
        
        setLocation(x, y); 
        
        if(seguidor != null) 
        {
            seguidor.moverPara(this.lastX, this.lastY, currentDirection);
        }
    }
    
    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastPosition(int lastX, int lastY) {
        this.lastX = lastX;
        this.lastY = lastY;
    }
}
