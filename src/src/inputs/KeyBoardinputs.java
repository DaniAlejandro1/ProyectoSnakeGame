package inputs;

import ControlsManage.ValidacionInputs;
import principal.SnakeClass;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardinputs implements KeyListener {
    private final SnakeClass snakePanel;

    public KeyBoardinputs(SnakeClass snakePanel) {

        this.snakePanel = snakePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        String key = String.valueOf(e.getKeyChar());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                if (ValidacionInputs.giroArr(snakePanel,key)) {

                    snakePanel.setDirecciones("arr");
                }
            }
            case KeyEvent.VK_A -> {
                if (ValidacionInputs.giroIz(snakePanel,key)) {
                    snakePanel.setDirecciones("iz");
                }

            }
            case KeyEvent.VK_S -> {
                System.out.println(key);
                if (ValidacionInputs.giroAb(snakePanel,key)) {
                    snakePanel.setDirecciones("ab");
                }
            }
            case KeyEvent.VK_D -> {
                if (ValidacionInputs.giroDer(snakePanel,key)) {
                    snakePanel.setDirecciones("der");
                }
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
