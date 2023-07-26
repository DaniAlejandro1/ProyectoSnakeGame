package principal;

import principal.SnakeClass;

public class ManejodeHilos implements Runnable {
    SnakeClass snakePanel;
    private boolean estado = true;

    public ManejodeHilos(SnakeClass snakePanel) {
        this.snakePanel = snakePanel;
    }

    @Override
    public void run() {
        this.estado = true;
        while (estado) {
            snakePanel.requestFocus();
            snakePanel.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void stop() {
        this.estado = false;
    }
}
