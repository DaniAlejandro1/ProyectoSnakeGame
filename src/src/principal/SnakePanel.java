package principal;

import inputs.KeyBoardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel {

    private Mouseinputs mouseinputs;
    private int xDelta = 0;
    private int yDelta = 0;
    public SnakePanel() {
        mouseinputs = new Mouseinputs();
        addKeyListener(new KeyBoardinputs(this));
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(310+xDelta, 310+yDelta, 100, 50);
        repaint();
    }



    public void changeXDelta(int value){
        this.xDelta += value;

    }
    public void changeYDelta(int value){
        this.yDelta += value;

    }
}
