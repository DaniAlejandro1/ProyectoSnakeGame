package principal;

public class Game {
    public Game(){
        GamePanel gamePanel = new GamePanel();
        new GameWindow(gamePanel);
    }
}
