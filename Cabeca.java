import greenfoot.*;

public class Cabeca extends Cobra
{
    private int speed = 20;
    private Cobra seguidor;
    private int lastX, lastY;
    
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private int currentDirection = 0;
    
    GreenfootImage image = new GreenfootImage("cabeca.png");

    public Cabeca(int x, int y)
    {
        super();
        setImage(image);
        image.scale(20, 20);
    }

    public void act()
    {
        verificarTeclas();
        moverDeAcordoComDirecao();
        verificarColisao();
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
            this.seguidor.moverPara(this.lastX, this.lastY, this.currentDirection);
        }
        
        this.currentDirection = direction;
        switch(currentDirection) {
            case DOWN:
                setImage("cabeca.png"); 
                image.scale(10, 10);
                setRotation(90);
                break;
            case RIGHT:
                setImage("cabeca.png");
                image.scale(10, 10);
                setRotation(0);
                break;
            case UP:
                setImage("cabeca-esquerda.png");
                image.scale(10, 10);
                setRotation(90);
                break;
            case LEFT:
                setImage("cabeca-esquerda.png");
                image.scale(10, 10);
                setRotation(0);
                break;
        }
    }

    public void setLastPosition(int lastX, int lastY) {
        this.lastX = lastX;
        this.lastY = lastY;
    }

    public void verificarTeclas()
    {
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) 
        {
            if (currentDirection != LEFT) {
            currentDirection = RIGHT;
            }
        }
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) 
        {
            if (currentDirection != RIGHT){
            currentDirection = LEFT;
            }
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) 
        {
            if (currentDirection != DOWN){
            currentDirection = UP;
            }
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) 
        {
            if(currentDirection != UP){
            currentDirection = DOWN;
            }
        }
    }

    public void moverDeAcordoComDirecao()
    {
        int newX = getX();
        int newY = getY();
        
        if (currentDirection == RIGHT) 
        {
            newX += speed;
        }
        if (currentDirection == LEFT) 
        {
            newX -= speed;
        }
        if (currentDirection == UP) 
        {
            newY -= speed;
        }
        if (currentDirection == DOWN) 
        {
            newY += speed;
        }
        
        moverPara(newX, newY, currentDirection);
    }

    public void verificarColisao()
    {
        if(getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 || getY() >= getWorld().getHeight() - 1)
        {
            Greenfoot.stop();
        }
    }
}


