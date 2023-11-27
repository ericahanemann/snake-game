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
    protected int currentDirection = 0;
    
    GreenfootImage imageDown = new GreenfootImage("cabeca.png");
    GreenfootImage imageRight = new GreenfootImage("cabeca.png");
    GreenfootImage imageUp = new GreenfootImage("cabeca-esquerda.png");
    GreenfootImage imageLeft = new GreenfootImage("cabeca-esquerda.png");

    public Cabeca(int x, int y)
    {
        super();
        setImage(imageRight);
        imageDown.scale(20, 20);
        imageRight.scale(20, 20);
        imageUp.scale(20, 20);
        imageLeft.scale(20, 20);
    }

    public void act()
    {
        verificarTeclas();
        moverDeAcordoComDirecao();
        verificarToqueMaca();
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

    public void verificarColisao() {
        if (isTouching(Cobra.class)) {
            Greenfoot.stop();
        }

        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 || getY() >= getWorld().getHeight() - 1) {
            Greenfoot.stop();
        }
    }
    
    private void verificarToqueMaca() {
        if (isTouching(Maca.class)) {
            World world = getWorld();
            if (world != null) {
                aumentarPontuacao();
                adicionarBarriga(getX(), getY());
                adicionarMaca(world);
            }
        }
    }
    
    private void adicionarBarriga(int x, int y) {
        int novoX = x;
        int novoY = y;
    
        if (currentDirection == RIGHT) {
            novoX -= 20;
        } else if (currentDirection == LEFT) {
            novoX += 20; 
        } else if (currentDirection == UP) {
            novoY += 20;  
        } else if (currentDirection == DOWN) {
            novoY -= 20; 
        }
    
        Cobra barriga = new Barriga(0, 0, this.currentDirection);
        barriga.setSeguidor(this.seguidor);
        getWorld().addObject(barriga, novoX, novoY);
        setSeguidor(barriga);
    }
    
    private void adicionarMaca(World world) {
        if (world instanceof MyWorld) {
            int x = Greenfoot.getRandomNumber(world.getWidth());
            int y = Greenfoot.getRandomNumber(world.getHeight());
            world.addObject(new Maca(), x, y);
        }
    }
    
    private void aumentarPontuacao() {
        World world = getWorld();
        if (world instanceof MyWorld) {
            ((MyWorld) world).incrementarPontuacao();
        }
    }
}


