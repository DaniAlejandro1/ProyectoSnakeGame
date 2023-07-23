package principal;

public class Game {

    public Game(){

        SnakePanel snakePanel = new SnakePanel();
        new GameWindow(snakePanel);
        snakePanel.requestFocus();

    }


}
