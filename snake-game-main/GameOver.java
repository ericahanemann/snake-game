import greenfoot.*;

public class GameOver extends World
{
    private int pontuacao;

    public GameOver(int pontuacao)
    {    
        super(600, 400, 1);
        this.pontuacao = pontuacao; 
        GreenfootImage imagemGameOver = new GreenfootImage("game_over.gif");
        setBackground(imagemGameOver);
        showText("Pontuação: " + pontuacao, 300, 200);
        showText("Desenvolvido por Erica, João, Estevão, Hilari", 300, 380);
        showText("Aperte R para recomeçar", 300, 300);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("r")) {
            Greenfoot.setWorld(new TelaInicial());
        }
    }
}
