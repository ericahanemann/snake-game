import greenfoot.*;

public class TelaInicial extends World
{
    public TelaInicial()
    {    
        super(600, 400, 1); 
        GreenfootImage imagemInicial = new GreenfootImage("imagem_inicial.png");
        setBackground(imagemInicial);
        showText("PARA INICIAR O JOGO PRECIONE J ",300, 200);
        showText("Desenvolvido por Erica, João, Estevão, Hilari", 300, 380);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("j")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
