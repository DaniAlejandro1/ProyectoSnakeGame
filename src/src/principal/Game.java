package principal;

public class Game {

    public Game(){
        GamePanel gamePanel = new GamePanel(800,30);
        SnakePanel snakePanel = new SnakePanel();
        new GameWindow(gamePanel);
        snakePanel.requestFocus();

    }
}
