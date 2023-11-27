import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{
    private int pontuacao;
    private GreenfootImage textoPontuacao;
    
    public MyWorld()
    {    
        super(600, 600, 1); 
        
        Cabeca cabeca = new Cabeca(60, 20);
        addObject(cabeca, 60, 20);

        Barriga barriga = new Barriga(40, 20, 0);
        addObject(barriga, 40, 20);
        
        Rabo rabo = new Rabo(20, 20);
        addObject(rabo, 20, 20);

        cabeca.setSeguidor(barriga);
        barriga.setSeguidor(rabo);
        
        adicionarMaca();
        prepararTextoPontuacao();
    }
    
    public void incrementarPontuacao() {
        pontuacao++;
        atualizarTextoPontuacao();
    }

    private void prepararTextoPontuacao() {
        textoPontuacao = new GreenfootImage("Pontuação: 0", 24, Color.WHITE, null);
        addObject(new Actor() {}, getWidth() / 2, 20); 
        atualizarTextoPontuacao();
    }

    private void atualizarTextoPontuacao() {
    String textoAtualizado = "PONTUAÇÃO: " + pontuacao;
    
    textoPontuacao = new GreenfootImage(textoAtualizado, 24, Color.WHITE, null);
    
    List<Actor> atores = getObjectsAt(getWidth() / 2, 20, Actor.class);
    if (!atores.isEmpty()) {
        atores.get(0).setImage(textoPontuacao);
    }
}

    protected void adicionarMaca() {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(new Maca(), x, y);
    }
}
