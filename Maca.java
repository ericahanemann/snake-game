import greenfoot.*;

public class Maca extends Actor {
    public Maca() {
        GreenfootImage image = new GreenfootImage("maca.png");
        image.scale(20, 20);
        setImage(image);
    }

    public void act() {
        verificarColisao();
    }

    private void verificarColisao() {
        if (isTouching(Cabeca.class)) {
            World world = getWorld();
            if (world != null) {
                world.removeObject(this); 
                aumentarPontuacao();
            }
        }
    }

    private void aumentarPontuacao() {
        World world = getWorld();
        if (world instanceof MyWorld) {
            ((MyWorld) world).incrementarPontuacao();
        }
    }
}
