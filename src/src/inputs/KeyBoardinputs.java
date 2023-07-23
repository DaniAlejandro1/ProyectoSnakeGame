package inputs;

import principal.Movimiento;
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
        Movimiento movimiento = new Movimiento();

        switch (e.getKeyCode()){
            case KeyEvent.VK_W -> snakePanel.moverArriba();
            case KeyEvent.VK_A -> snakePanel.moverIzquierda();
            case KeyEvent.VK_S -> snakePanel.moverAbajo();
            case KeyEvent.VK_D -> snakePanel.moverDerecha();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
