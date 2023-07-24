package inputs;

import principal.SnakePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardinputs implements KeyListener {
    private SnakePanel snakePanel;
    public KeyBoardinputs(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> snakePanel.setDirecciones("arr");
            case KeyEvent.VK_A -> snakePanel.setDirecciones("iz");
            case KeyEvent.VK_S -> snakePanel.setDirecciones("ab");
            case KeyEvent.VK_D -> snakePanel.setDirecciones("der");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
